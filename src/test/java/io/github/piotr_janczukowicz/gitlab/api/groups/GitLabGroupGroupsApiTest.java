package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCluster;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryRepository;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroup;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackageMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackagesMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetSearchResults;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetServiceIndex;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackageDebianDistribution;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabGroupGroupsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupGroupsApi api() {
        return new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupGroupsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void createDependencyListExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createDependencyListExport(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createDependencyListExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createDependencyListExport(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createDependencyListExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createDependencyListExport(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/dependency_list_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"send_email\":");
        });
    }

    @Test
    void createDependencyListExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createDependencyListExport(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRepositoryStorageMoves_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRepositoryStorageMoves("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listRepositoryStorageMoves_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRepositoryStorageMoves("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabGroupRepositoryStorageMove> page = api().listRepositoryStorageMoves("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.groupRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves");
        });
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabGroupRepositoryStorageMove> page =
                api().listRepositoryStorageMoves("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.groupRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createRepositoryStorageMove(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createRepositoryStorageMove_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createRepositoryStorageMove(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")));

        final GitLabGroupRepositoryStorageMove result = api().createRepositoryStorageMove(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.groupRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"destination_storage_name\":");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRepositoryStorageMove(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRepositoryStorageMove_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getRepositoryStorageMove("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getRepositoryStorageMove_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getRepositoryStorageMove("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")));

        final Optional<GitLabGroupRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.groupRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves/1");
        });
    }

    @Test
    void getRepositoryStorageMove_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGroupRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void callManagePersonalAccessTokens_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callManagePersonalAccessTokens("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callManagePersonalAccessTokens_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callManagePersonalAccessTokens("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callManagePersonalAccessTokens_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callManagePersonalAccessTokens("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens");
    }

    @Test
    void callManagePersonalAccessTokens_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callManagePersonalAccessTokens("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callManagePersonalAccessTokens_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callManagePersonalAccessTokens(
                        "group/sub/project",
                        GitLabGroupGroupsCallManagePersonalAccessTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabGroupGroupsCallManagePersonalAccessTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("revoked", "true");
    }

    @Test
    void deleteManagePersonalAccessToken_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManagePersonalAccessToken("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteManagePersonalAccessToken_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManagePersonalAccessToken("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteManagePersonalAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManagePersonalAccessToken("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1");
    }

    @Test
    void deleteManagePersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteManagePersonalAccessToken("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rotateManagePersonalAccessToken_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotateManagePersonalAccessToken(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void rotateManagePersonalAccessToken_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotateManagePersonalAccessToken(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void rotateManagePersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result = api().rotateManagePersonalAccessToken(
                        "group/sub/project",
                        1L,
                        GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1/rotate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"expires_at\":");
        });
    }

    @Test
    void rotateManagePersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rotateManagePersonalAccessToken(
                        "group/sub/project",
                        1L,
                        GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callManageResourceAccessTokens_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callManageResourceAccessTokens("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callManageResourceAccessTokens_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callManageResourceAccessTokens("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callManageResourceAccessTokens_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callManageResourceAccessTokens("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens");
    }

    @Test
    void callManageResourceAccessTokens_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callManageResourceAccessTokens("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callManageResourceAccessTokens_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callManageResourceAccessTokens(
                        "group/sub/project",
                        GitLabGroupGroupsCallManageResourceAccessTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabGroupGroupsCallManageResourceAccessTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("revoked", "true");
    }

    @Test
    void deleteManageResourceAccessToken_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManageResourceAccessToken("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteManageResourceAccessToken_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManageResourceAccessToken("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteManageResourceAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManageResourceAccessToken("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1");
    }

    @Test
    void deleteManageResourceAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteManageResourceAccessToken("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteManageResourceAccessToken_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManageResourceAccessToken(
                        "group/sub/project",
                        1L,
                        GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                                .expiresAt(LocalDate.parse("2026-01-01"))
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("expires_at", "2026-01-01");
    }

    @Test
    void rotateManageResourceAccessToken_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotateManageResourceAccessToken(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void rotateManageResourceAccessToken_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotateManageResourceAccessToken(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void rotateManageResourceAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().rotateManageResourceAccessToken(
                        "group/sub/project",
                        1L,
                        GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1/rotate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"expires_at\":");
        });
    }

    @Test
    void rotateManageResourceAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rotateManageResourceAccessToken(
                        "group/sub/project",
                        1L,
                        GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listManageSshKeys_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listManageSshKeys("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listManageSshKeys_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listManageSshKeys("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listManageSshKeys_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]"));

        final GitLabPage<GitLabSshKeyWithUserId> page = api().listManageSshKeys("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.sshKeyWithUserId());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys");
        });
    }

    @Test
    void listManageSshKeys_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]"));

        final GitLabPage<GitLabSshKeyWithUserId> page = api().listManageSshKeys(
                        "group/sub/project",
                        GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.sshKeyWithUserId());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys");
            softly.assertThat(request.uri()).hasParameter("created_before", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listManageSshKeys_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]"));

        final GitLabPage<GitLabSshKeyWithUserId> page =
                api().listManageSshKeys("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.sshKeyWithUserId());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listManageSshKeys_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]"));

        final GitLabPage<GitLabSshKeyWithUserId> page = api().listManageSshKeys(
                        "group/sub/project",
                        GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.sshKeyWithUserId());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_before", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void deleteManageSshKey_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManageSshKey("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteManageSshKey_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteManageSshKey("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteManageSshKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManageSshKey("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys/1");
    }

    @Test
    void deleteManageSshKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteManageSshKey("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSaml_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSaml("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getSaml_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSaml("group/sub/project", "uid"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result = api().getSaml("group/sub/project", "uid");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml/uid");
        });
    }

    @Test
    void getSaml_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIdentityDetail> result = api().getSaml("group/sub/project", "uid");

        assertThat(result).isEmpty();
    }

    @Test
    void updateSaml_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateSaml_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result =
                api().updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/groups/group%2Fsub%2Fproject/saml/uid");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"extern_uid\":");
        });
    }

    @Test
    void updateSaml_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSaml_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteSaml("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteSaml_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteSaml("group/sub/project", "uid"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result = api().deleteSaml("group/sub/project", "uid");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/saml/uid");
        });
    }

    @Test
    void deleteSaml_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteSaml("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSaml_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabIdentityDetail> result = api().deleteSaml("group/sub/project", "uid");

        assertThat(result).isEmpty();
    }

    @Test
    void getScim_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getScim("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getScim_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getScim("group/sub/project", "uid"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result = api().getScim("group/sub/project", "uid");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/scim/uid");
        });
    }

    @Test
    void getScim_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIdentityDetail> result = api().getScim("group/sub/project", "uid");

        assertThat(result).isEmpty();
    }

    @Test
    void updateScim_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateScim_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result =
                api().updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/groups/group%2Fsub%2Fproject/scim/uid");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"extern_uid\":");
        });
    }

    @Test
    void updateScim_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteScim_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScim("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteScim_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScim("group/sub/project", "uid"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result = api().deleteScim("group/sub/project", "uid");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/scim/uid");
        });
    }

    @Test
    void deleteScim_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteScim("group/sub/project", "uid"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteScim_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabIdentityDetail> result = api().deleteScim("group/sub/project", "uid");

        assertThat(result).isEmpty();
    }

    @Test
    void listApprovalRules_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listApprovalRules("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listApprovalRules_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listApprovalRules("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listApprovalRules_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json") + "]"));

        final GitLabPage<GitLabGroupApprovalRule> page = api().listApprovalRules("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.groupApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/approval_rules");
        });
    }

    @Test
    void listApprovalRules_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json") + "]"));

        final GitLabPage<GitLabGroupApprovalRule> page =
                api().listApprovalRules("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupsCatalogFixtures.groupApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/approval_rules");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalRule(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalRule(
                "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json")));

        final GitLabGroupApprovalRule result = api().createApprovalRule(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/approval_rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createApprovalRule(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalRule(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalRule(
                "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json")));

        final GitLabGroupApprovalRule result = api().updateApprovalRule(
                        "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/approval_rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateApprovalRule(
                        "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesPypiFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesPypiFile("group/sub/project", "sha256", "file_identifier");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/files/sha256/file_identifier");
    }

    @Test
    void callPackagesPypiFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesPypiFile("group/sub/project", "sha256", "file_identifier"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesPypiSimple_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesPypiSimple("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple");
    }

    @Test
    void callPackagesPypiSimple_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesPypiSimple("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesPypiSimpleByPackageName_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesPypiSimpleByPackageName("group/sub/project", "package_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple/package_name");
    }

    @Test
    void callPackagesPypiSimpleByPackageName_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesPypiSimpleByPackageName("group/sub/project", "package_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackagesNugetIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabNugetServiceIndex.class, "nuget-service-index.json")));

        final GitLabNugetServiceIndex result = api().getPackagesNugetIndex("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.nugetServiceIndex());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/index");
        });
    }

    @Test
    void getPackagesNugetIndex_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getPackagesNugetIndex("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesNugetSymbolfile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesNugetSymbolfile("group/sub/project", "file_name", "signature", "same_file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/symbolfiles/file_name/signature/same_file_name");
    }

    @Test
    void callPackagesNugetSymbolfile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().callPackagesNugetSymbolfile("group/sub/project", "file_name", "signature", "same_file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesNugetV2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesNugetV2("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2");
    }

    @Test
    void callPackagesNugetV2_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesNugetV2("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPackagesNugetV2Metadata_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesNugetV2Metadata("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2/$metadata");
    }

    @Test
    void callPackagesNugetV2Metadata_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPackagesNugetV2Metadata("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackagesNugetMetadataIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNugetPackagesMetadata.class, "nuget-packages-metadata.json")));

        final Optional<GitLabNugetPackagesMetadata> result =
                api().getPackagesNugetMetadataIndex("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.nugetPackagesMetadata());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/index");
        });
    }

    @Test
    void getPackagesNugetMetadataIndex_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNugetPackagesMetadata> result =
                api().getPackagesNugetMetadataIndex("group/sub/project", "package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void getPackagesNugetMetadata_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNugetPackageMetadata.class, "nuget-package-metadata.json")));

        final Optional<GitLabNugetPackageMetadata> result =
                api().getPackagesNugetMetadata("group/sub/project", "package_name", "package_version");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.nugetPackageMetadata());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/package_version");
        });
    }

    @Test
    void getPackagesNugetMetadata_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNugetPackageMetadata> result =
                api().getPackagesNugetMetadata("group/sub/project", "package_name", "package_version");

        assertThat(result).isEmpty();
    }

    @Test
    void getPackagesNugetQuery_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNugetSearchResults.class, "nuget-search-results.json")));

        final GitLabNugetSearchResults result = api().getPackagesNugetQuery("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.nugetSearchResults());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/query");
        });
    }

    @Test
    void getPackagesNugetQuery_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getPackagesNugetQuery("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackagesNugetQuery_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNugetSearchResults.class, "nuget-search-results.json")));

        api().getPackagesNugetQuery(
                        "group/sub/project",
                        GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                                .q("q")
                                .skip(1)
                                .take(1)
                                .prerelease(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("q", "q");
    }

    @Test
    void listBillableMembers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listBillableMembers("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members");
        });
    }

    @Test
    void listBillableMembers_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listBillableMembers(
                        "group/sub/project",
                        GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                                .search("search")
                                .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listBillableMembers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listBillableMembers("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listBillableMembers_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listBillableMembers(
                        "group/sub/project",
                        GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                                .search("search")
                                .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void callPackagesMaven_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPackagesMaven("group/sub/project", "path", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/maven/path/file_name");
    }

    @Test
    void callPackagesMaven_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callPackagesMaven("group/sub/project", "path", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listPackages_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().listPackages("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/packages");
        });
    }

    @Test
    void listPackages_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().listPackages(
                        "group/sub/project",
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("exclude_subgroups", "true");
        });
    }

    @Test
    void listPackages_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().listPackages("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPackages_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().listPackages(
                        "group/sub/project",
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("exclude_subgroups", "true");
        });
    }

    @Test
    void listDebianDistributions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]"));

        final GitLabPage<GitLabPackageDebianDistribution> page = api().listDebianDistributions("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
        });
    }

    @Test
    void listDebianDistributions_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]"));

        final GitLabPage<GitLabPackageDebianDistribution> page = api().listDebianDistributions(
                        "group/sub/project",
                        GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                .codename("codename")
                                .suite("suite")
                                .origin("origin")
                                .label("label")
                                .version("1.0-1")
                                .description("description")
                                .validTimeDurationSeconds(1)
                                .components(List.of("components"))
                                .architectures(List.of("architectures"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
            softly.assertThat(request.uri()).hasParameter("codename", "codename");
        });
    }

    @Test
    void listDebianDistributions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]"));

        final GitLabPage<GitLabPackageDebianDistribution> page =
                api().listDebianDistributions("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listDebianDistributions_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]"));

        final GitLabPage<GitLabPackageDebianDistribution> page = api().listDebianDistributions(
                        "group/sub/project",
                        GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                .codename("codename")
                                .suite("suite")
                                .origin("origin")
                                .label("label")
                                .version("1.0-1")
                                .description("description")
                                .validTimeDurationSeconds(1)
                                .components(List.of("components"))
                                .architectures(List.of("architectures"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("codename", "codename");
        });
    }

    @Test
    void createDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result = api().createDebianDistribution(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"codename\":");
        });
    }

    @Test
    void createDebianDistribution_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createDebianDistribution(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result =
                api().getDebianDistribution("group/sub/project", "codename");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
        });
    }

    @Test
    void getDebianDistribution_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageDebianDistribution> result =
                api().getDebianDistribution("group/sub/project", "codename");

        assertThat(result).isEmpty();
    }

    @Test
    void updateDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result = api().updateDebianDistribution(
                        "group/sub/project",
                        "codename",
                        GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"suite\":");
        });
    }

    @Test
    void updateDebianDistribution_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateDebianDistribution(
                        "group/sub/project",
                        "codename",
                        GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteDebianDistribution_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteDebianDistribution("group/sub/project", "codename");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void deleteDebianDistribution_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteDebianDistribution("group/sub/project", "codename"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteDebianDistribution_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteDebianDistribution(
                        "group/sub/project",
                        "codename",
                        GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                .suite("suite")
                                .origin("origin")
                                .label("label")
                                .version("1.0-1")
                                .description("description")
                                .validTimeDurationSeconds(1)
                                .components(List.of("components"))
                                .architectures(List.of("architectures"))
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("suite", "suite");
    }

    @Test
    void getDebianDistributionsKeyAsc_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result =
                api().getDebianDistributionsKeyAsc("group/sub/project", "codename");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename/key.asc");
        });
    }

    @Test
    void getDebianDistributionsKeyAsc_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageDebianDistribution> result =
                api().getDebianDistributionsKeyAsc("group/sub/project", "codename");

        assertThat(result).isEmpty();
    }

    @Test
    void listRegistryRepositories_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                                + "]"));

        final GitLabPage<GitLabContainerRegistryRepository> page = api().listRegistryRepositories("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.containerRegistryRepository());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/registry/repositories");
        });
    }

    @Test
    void listRegistryRepositories_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                                + "]"));

        final GitLabPage<GitLabContainerRegistryRepository> page =
                api().listRegistryRepositories("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.containerRegistryRepository());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/registry/repositories");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listClusters_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]"));

        final GitLabPage<GitLabCluster> page = api().listClusters("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.cluster());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/clusters");
        });
    }

    @Test
    void listClusters_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]"));

        final GitLabPage<GitLabCluster> page = api().listClusters("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.cluster());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/clusters");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final Optional<GitLabClusterGroup> result = api().getCluster("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupsCatalogFixtures.clusterGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/clusters/1");
        });
    }

    @Test
    void getCluster_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabClusterGroup> result = api().getCluster("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final GitLabClusterGroup result =
                api().updateCluster("group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateClusterPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.clusterGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/clusters/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateCluster_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().updateCluster("group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateClusterPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final Optional<GitLabClusterGroup> result = api().deleteCluster("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupsCatalogFixtures.clusterGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/clusters/1");
        });
    }

    @Test
    void deleteCluster_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteCluster("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteCluster_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabClusterGroup> result = api().deleteCluster("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void userCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final GitLabClusterGroup result =
                api().userCluster("group/sub/project", GroupsCatalogFixtures.groupClusterUserCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.clusterGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/clusters/user");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void userCluster_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().userCluster("group/sub/project", GroupsCatalogFixtures.groupClusterUserCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getAvatar_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getAvatar("group/sub/project", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getAvatar_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getAvatar("group/sub/project", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void listRunners_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listRunners("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/runners");
        });
    }

    @Test
    void listRunners_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listRunners(
                        "group/sub/project",
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/runners");
            softly.assertThat(request.uri()).hasParameter("type", "instance_type");
        });
    }

    @Test
    void listRunners_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page =
                api().listRunners("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/runners");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listRunners_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listRunners(
                        "group/sub/project",
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/runners");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("type", "instance_type");
        });
    }

    @Test
    void resetRegistrationTokenRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result = api().resetRegistrationTokenRunner("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/runners/reset_registration_token");
        });
    }

    @Test
    void resetRegistrationTokenRunner_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetRegistrationTokenRunner("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/groups");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().list(GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/groups");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().list(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result =
                api().create(MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final Optional<GitLabGroupDetail> result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupsCatalogFixtures.groupDetail());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGroupDetail> result = api().get("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        api().get(
                        "group/sub/project",
                        GitLabGroupGroupsGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withProjects(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("with_custom_attributes", "true");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result = api().update(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void archive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result = api().archive("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/archive");
        });
    }

    @Test
    void archive_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().archive("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unarchive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result = api().unarchive("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/unarchive");
        });
    }

    @Test
    void unarchive_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unarchive("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void restore_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().restore("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/restore");
    }

    @Test
    void restore_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().restore("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listShared_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listShared("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/groups/shared");
        });
    }

    @Test
    void listShared_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listShared(
                        "group/sub/project",
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/groups/shared");
            softly.assertThat(request.uri()).hasParameter("skip_groups", "1");
        });
    }

    @Test
    void listShared_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listShared("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/groups/shared");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listShared_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listShared(
                        "group/sub/project",
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/groups/shared");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("skip_groups", "1");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listInvitedGroups("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/invited_groups");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listInvitedGroups(
                        "group/sub/project",
                        GitLabGroupGroupsListInvitedGroupsFilterBuilder.builder()
                                .relation(List.of(GitLabGroupGroupsListInvitedGroupsRelation.DIRECT))
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListInvitedGroupsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("relation", "direct");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listInvitedGroups("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listInvitedGroups(
                        "group/sub/project",
                        GitLabGroupGroupsListInvitedGroupsFilterBuilder.builder()
                                .relation(List.of(GitLabGroupGroupsListInvitedGroupsRelation.DIRECT))
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListInvitedGroupsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("relation", "direct");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjects("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjects(
                        "group/sub/project",
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects");
            softly.assertThat(request.uri()).hasParameter("active", "true");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjects("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjects(
                        "group/sub/project",
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("active", "true");
        });
    }

    @Test
    void listProjectsShared_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjectsShared("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects/shared");
        });
    }

    @Test
    void listProjectsShared_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjectsShared(
                        "group/sub/project",
                        GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                .simple(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects/shared");
            softly.assertThat(request.uri()).hasParameter("archived", "true");
        });
    }

    @Test
    void listProjectsShared_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjectsShared("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects/shared");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listProjectsShared_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().listProjectsShared(
                        "group/sub/project",
                        GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                .simple(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/projects/shared");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("archived", "true");
        });
    }

    @Test
    void listGroup_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listGroup("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/subgroups");
        });
    }

    @Test
    void listGroup_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listGroup(
                        "group/sub/project",
                        GitLabGroupGroupsListGroupFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListGroupVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .orderBy(GitLabGroupGroupsListGroupOrderBy.NAME)
                                .sort(GitLabGroupGroupsListGroupSort.ASC)
                                .minAccessLevel(GitLabGroupGroupsListGroupMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/subgroups");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void listGroup_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listGroup("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/subgroups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listGroup_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listGroup(
                        "group/sub/project",
                        GitLabGroupGroupsListGroupFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListGroupVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .orderBy(GitLabGroupGroupsListGroupOrderBy.NAME)
                                .sort(GitLabGroupGroupsListGroupSort.ASC)
                                .minAccessLevel(GitLabGroupGroupsListGroupMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/subgroups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void listDescendantGroups_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listDescendantGroups("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/descendant_groups");
        });
    }

    @Test
    void listDescendantGroups_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listDescendantGroups(
                        "group/sub/project",
                        GitLabGroupGroupsListDescendantGroupsFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListDescendantGroupsVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .orderBy(GitLabGroupGroupsListDescendantGroupsOrderBy.NAME)
                                .sort(GitLabGroupGroupsListDescendantGroupsSort.ASC)
                                .minAccessLevel(GitLabGroupGroupsListDescendantGroupsMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/descendant_groups");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void listDescendantGroups_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listDescendantGroups("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/descendant_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listDescendantGroups_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listDescendantGroups(
                        "group/sub/project",
                        GitLabGroupGroupsListDescendantGroupsFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListDescendantGroupsVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .orderBy(GitLabGroupGroupsListDescendantGroupsOrderBy.NAME)
                                .sort(GitLabGroupGroupsListDescendantGroupsSort.ASC)
                                .minAccessLevel(GitLabGroupGroupsListDescendantGroupsMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/descendant_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("statistics", "true");
        });
    }

    @Test
    void createProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result = api().createProject("group/sub/project", "project_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/projects/project_id");
        });
    }

    @Test
    void createProject_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createProject("group/sub/project", "project_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listTransferLocations("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/transfer_locations");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listTransferLocations(
                        "group/sub/project",
                        GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                                .search("search")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page =
                api().listTransferLocations("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final GitLabPage<GitLabGroup> page = api().listTransferLocations(
                        "group/sub/project",
                        GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                                .search("search")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.group());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void transfer_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().transfer("group/sub/project", GroupsCatalogFixtures.groupGroupsTransferPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/transfer");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"group_id\":");
        });
    }

    @Test
    void transfer_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().transfer("group/sub/project", GroupsCatalogFixtures.groupGroupsTransferPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void transferToOrganization_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result = api().transferToOrganization(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/transfer_to_organization");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"organization_id\":");
        });
    }

    @Test
    void transferToOrganization_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().transferToOrganization(
                        "group/sub/project", GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void share_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result =
                api().share("group/sub/project", GroupsCatalogFixtures.groupGroupsSharePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/share");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"group_id\":");
        });
    }

    @Test
    void share_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().share("group/sub/project", GroupsCatalogFixtures.groupGroupsSharePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteShare_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteShare("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void deleteShare_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteShare("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSharedProject_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteSharedProject("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/shared_projects/1");
    }

    @Test
    void deleteSharedProject_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteSharedProject("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void ldapSync_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.ldapSync("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void ldapSync_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.ldapSync("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void ldapSync_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().ldapSync("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/ldap_sync");
    }

    @Test
    void ldapSync_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().ldapSync("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAuditEvents_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAuditEvents("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAuditEvents_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAuditEvents("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/audit_events");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents(
                        "group/sub/project",
                        GitLabGroupGroupsListAuditEventsFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents(
                        "group/sub/project",
                        GitLabGroupGroupsListAuditEventsFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void getAuditEvent_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAuditEvent("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getAuditEvent_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAuditEvent("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getAuditEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAuditEvent.class, "audit-event.json")));

        final Optional<GitLabAuditEvent> result = api().getAuditEvent("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/audit_events/1");
        });
    }

    @Test
    void getAuditEvent_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAuditEvent> result = api().getAuditEvent("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listSamlUsers_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listSamlUsers("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listSamlUsers_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listSamlUsers("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listSamlUsers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listSamlUsers("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_users");
        });
    }

    @Test
    void listSamlUsers_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listSamlUsers(
                        "group/sub/project",
                        GitLabGroupGroupsListSamlUsersFilterBuilder.builder()
                                .username("username")
                                .search("search")
                                .active(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_users");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }

    @Test
    void listSamlUsers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listSamlUsers("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listSamlUsers_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listSamlUsers(
                        "group/sub/project",
                        GitLabGroupGroupsListSamlUsersFilterBuilder.builder()
                                .username("username")
                                .search("search")
                                .active(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }

    @Test
    void listProvisionedUsers_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listProvisionedUsers("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listProvisionedUsers_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupsApi lowTier =
                new GitLabGroupGroupsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listProvisionedUsers("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listProvisionedUsers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listProvisionedUsers("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/provisioned_users");
        });
    }

    @Test
    void listProvisionedUsers_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listProvisionedUsers(
                        "group/sub/project",
                        GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                .username("username")
                                .search("search")
                                .active(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/provisioned_users");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }

    @Test
    void listProvisionedUsers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page =
                api().listProvisionedUsers("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/provisioned_users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listProvisionedUsers_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final GitLabPage<GitLabUserPublic> page = api().listProvisionedUsers(
                        "group/sub/project",
                        GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                .username("username")
                                .search("search")
                                .active(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/provisioned_users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }
}
