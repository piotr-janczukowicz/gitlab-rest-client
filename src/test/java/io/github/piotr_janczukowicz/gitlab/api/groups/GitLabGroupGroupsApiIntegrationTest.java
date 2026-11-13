package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabGroupGroupsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createDependencyListExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/dependency_list_exports", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .createDependencyListExport(
                            "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/dependency_list_exports");
    }

    @Test
    void createDependencyListExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/dependency_list_exports", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createDependencyListExport(
                    "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/dependency_list_exports");
    }

    @Test
    void listRepositoryStorageMoves_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")
                        + "]"));

        final List<GitLabGroupRepositoryStorageMove> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listRepositoryStorageMoves("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.groupRepositoryStorageMove(),
                        CommonCatalogFixtures.groupRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves", 2);
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")));

        final GitLabGroupRepositoryStorageMove result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .createRepositoryStorageMove(
                            "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupRepositoryStorageMove());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void createRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRepositoryStorageMove(
                    "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGroupRepositoryStorageMove.class, "group-repository-storage-move.json")));

        final Optional<GitLabGroupRepositoryStorageMove> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabGroupGroupsApi(GitLabCaller.of(client)).getRepositoryStorageMove("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.groupRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void getRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getRepositoryStorageMove("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void callManagePersonalAccessTokens_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).callManagePersonalAccessTokens("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens");
    }

    @Test
    void callManagePersonalAccessTokens_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callManagePersonalAccessTokens("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens");
    }

    @Test
    void deleteManagePersonalAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteManagePersonalAccessToken("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1");
    }

    @Test
    void deleteManagePersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteManagePersonalAccessToken("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1");
    }

    @Test
    void rotateManagePersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .rotateManagePersonalAccessToken(
                            "group/sub/project",
                            1L,
                            GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1/rotate");
    }

    @Test
    void rotateManagePersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1/rotate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotateManagePersonalAccessToken(
                    "group/sub/project",
                    1L,
                    GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/manage/personal_access_tokens/1/rotate");
    }

    @Test
    void callManageResourceAccessTokens_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).callManageResourceAccessTokens("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens");
    }

    @Test
    void callManageResourceAccessTokens_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callManageResourceAccessTokens("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens");
    }

    @Test
    void deleteManageResourceAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteManageResourceAccessToken("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1");
    }

    @Test
    void deleteManageResourceAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteManageResourceAccessToken("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1");
    }

    @Test
    void rotateManageResourceAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1/rotate",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .rotateManageResourceAccessToken(
                            "group/sub/project",
                            1L,
                            GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1/rotate");
    }

    @Test
    void rotateManageResourceAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1/rotate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotateManageResourceAccessToken(
                    "group/sub/project",
                    1L,
                    GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/manage/resource_access_tokens/1/rotate");
    }

    @Test
    void listManageSshKeys_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabSshKeyWithUserId.class, "ssh-key-with-user-id.json") + "]"));

        final List<GitLabSshKeyWithUserId> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listManageSshKeys("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(GroupsCatalogFixtures.sshKeyWithUserId(), GroupsCatalogFixtures.sshKeyWithUserId());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys", 2);
    }

    @Test
    void deleteManageSshKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteManageSshKey("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys/1");
    }

    @Test
    void deleteManageSshKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteManageSshKey("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/manage/ssh_keys/1");
    }

    @Test
    void getSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getSaml("group/sub/project", "uid");
        }

        assertThat(result).contains(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void getSaml_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getSaml("group/sub/project", "uid")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void updateSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/groups/group%2Fsub%2Fproject/saml/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void updateSaml_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.updateSaml("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateSamlPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void deleteSaml_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/saml/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteSaml("group/sub/project", "uid");
        }

        assertThat(result).contains(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void deleteSaml_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSaml("group/sub/project", "uid"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void deleteSaml_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid", GitLabApiStubSupport.noContent());

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteSaml("group/sub/project", "uid");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml/uid");
    }

    @Test
    void getScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/scim/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getScim("group/sub/project", "uid");
        }

        assertThat(result).contains(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void getScim_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getScim("group/sub/project", "uid")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void updateScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/groups/group%2Fsub%2Fproject/scim/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void updateScim_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.updateScim("group/sub/project", "uid", GroupsCatalogFixtures.groupGroupsUpdateScimPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void deleteScim_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/scim/uid",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteScim("group/sub/project", "uid");
        }

        assertThat(result).contains(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void deleteScim_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteScim("group/sub/project", "uid"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void deleteScim_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid", GitLabApiStubSupport.noContent());

        final Optional<GitLabIdentityDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteScim("group/sub/project", "uid");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/scim/uid");
    }

    @Test
    void listApprovalRules_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/approval_rules",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/approval_rules?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json") + "]"));

        final List<GitLabGroupApprovalRule> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listApprovalRules("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(GroupsCatalogFixtures.groupApprovalRule(), GroupsCatalogFixtures.groupApprovalRule());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules", 2);
    }

    @Test
    void createApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/approval_rules",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json")));

        final GitLabGroupApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .createApprovalRule(
                            "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupApprovalRule());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules");
    }

    @Test
    void createApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createApprovalRule(
                    "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules");
    }

    @Test
    void updateApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/approval_rules/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabGroupApprovalRule.class, "group-approval-rule.json")));

        final GitLabGroupApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .updateApprovalRule(
                            "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupApprovalRule());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void updateApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateApprovalRule(
                    "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void callPackagesPypiFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/files/sha256/file_identifier",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .callPackagesPypiFile("group/sub/project", "sha256", "file_identifier");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/files/sha256/file_identifier");
    }

    @Test
    void callPackagesPypiFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/files/sha256/file_identifier",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesPypiFile("group/sub/project", "sha256", "file_identifier"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/files/sha256/file_identifier");
    }

    @Test
    void callPackagesPypiSimple_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).callPackagesPypiSimple("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple");
    }

    @Test
    void callPackagesPypiSimple_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesPypiSimple("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple");
    }

    @Test
    void callPackagesPypiSimpleByPackageName_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .callPackagesPypiSimpleByPackageName("group/sub/project", "package_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple/package_name");
    }

    @Test
    void callPackagesPypiSimpleByPackageName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesPypiSimpleByPackageName("group/sub/project", "package_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/pypi/simple/package_name");
    }

    @Test
    void getPackagesNugetIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/index",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetServiceIndex.class, "nuget-service-index.json")));

        final GitLabNugetServiceIndex result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getPackagesNugetIndex("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.nugetServiceIndex());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/index");
    }

    @Test
    void getPackagesNugetIndex_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/index", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getPackagesNugetIndex("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/index");
    }

    @Test
    void callPackagesNugetSymbolfile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/symbolfiles/file_name/signature/same_file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .callPackagesNugetSymbolfile("group/sub/project", "file_name", "signature", "same_file_name");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/symbolfiles/file_name/signature/same_file_name");
    }

    @Test
    void callPackagesNugetSymbolfile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/symbolfiles/file_name/signature/same_file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callPackagesNugetSymbolfile("group/sub/project", "file_name", "signature", "same_file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/symbolfiles/file_name/signature/same_file_name");
    }

    @Test
    void callPackagesNugetV2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).callPackagesNugetV2("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2");
    }

    @Test
    void callPackagesNugetV2_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesNugetV2("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2");
    }

    @Test
    void callPackagesNugetV2Metadata_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2/$metadata",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).callPackagesNugetV2Metadata("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2/$metadata");
    }

    @Test
    void callPackagesNugetV2Metadata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2/$metadata",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesNugetV2Metadata("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/v2/$metadata");
    }

    @Test
    void getPackagesNugetMetadataIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/index",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetPackagesMetadata.class, "nuget-packages-metadata.json")));

        final Optional<GitLabNugetPackagesMetadata> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getPackagesNugetMetadataIndex("group/sub/project", "package_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.nugetPackagesMetadata());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/index");
    }

    @Test
    void getPackagesNugetMetadataIndex_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/index",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getPackagesNugetMetadataIndex("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/index");
    }

    @Test
    void getPackagesNugetMetadata_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/package_version",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetPackageMetadata.class, "nuget-package-metadata.json")));

        final Optional<GitLabNugetPackageMetadata> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getPackagesNugetMetadata("group/sub/project", "package_name", "package_version");
        }

        assertThat(result).contains(CommonCatalogFixtures.nugetPackageMetadata());
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/package_version");
    }

    @Test
    void getPackagesNugetMetadata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/package_version",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getPackagesNugetMetadata("group/sub/project", "package_name", "package_version")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/metadata/package_name/package_version");
    }

    @Test
    void getPackagesNugetQuery_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/query",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetSearchResults.class, "nuget-search-results.json")));

        final GitLabNugetSearchResults result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getPackagesNugetQuery("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.nugetSearchResults());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/query");
    }

    @Test
    void getPackagesNugetQuery_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/query", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getPackagesNugetQuery("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/nuget/query");
    }

    @Test
    void listBillableMembers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/billable_members",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/billable_members?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final List<GitLabMember> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listBillableMembers("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.member(), CommonCatalogFixtures.member());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/billable_members", 2);
    }

    @Test
    void callPackagesMaven_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/maven/path/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .callPackagesMaven("group/sub/project", "path", "file_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/maven/path/file_name");
    }

    @Test
    void callPackagesMaven_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/maven/path/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPackagesMaven("group/sub/project", "path", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/maven/path/file_name");
    }

    @Test
    void listPackages_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/packages",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/packages?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final List<GitLabPackage> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listPackages("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.packageValue(), CommonCatalogFixtures.packageValue());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/packages", 2);
    }

    @Test
    void listDebianDistributions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                        + "]"));

        final List<GitLabPackageDebianDistribution> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listDebianDistributions("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.packageDebianDistribution(),
                        CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions", 2);
    }

    @Test
    void createDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .createDebianDistribution(
                            "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
    }

    @Test
    void createDebianDistribution_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createDebianDistribution(
                    "group/sub/project", GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions");
    }

    @Test
    void getDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getDebianDistribution("group/sub/project", "codename");
        }

        assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void getDebianDistribution_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getDebianDistribution("group/sub/project", "codename")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void updateDebianDistribution_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .updateDebianDistribution(
                            "group/sub/project",
                            "codename",
                            GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void updateDebianDistribution_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateDebianDistribution(
                    "group/sub/project",
                    "codename",
                    GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void deleteDebianDistribution_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteDebianDistribution("group/sub/project", "codename");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void deleteDebianDistribution_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteDebianDistribution("group/sub/project", "codename"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename");
    }

    @Test
    void getDebianDistributionsKeyAsc_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename/key.asc",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getDebianDistributionsKeyAsc("group/sub/project", "codename");
        }

        assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename/key.asc");
    }

    @Test
    void getDebianDistributionsKeyAsc_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename/key.asc",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getDebianDistributionsKeyAsc("group/sub/project", "codename")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/debian_distributions/codename/key.asc");
    }

    @Test
    void listRegistryRepositories_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/registry/repositories",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/registry/repositories?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                        + "]"));

        final List<GitLabContainerRegistryRepository> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listRegistryRepositories("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.containerRegistryRepository(),
                        CommonCatalogFixtures.containerRegistryRepository());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/registry/repositories", 2);
    }

    @Test
    void listClusters_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/clusters",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/clusters?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]"));

        final List<GitLabCluster> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listClusters("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.cluster(), CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/clusters", 2);
    }

    @Test
    void getCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final Optional<GitLabClusterGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getCluster("group/sub/project", 1L);
        }

        assertThat(result).contains(GroupsCatalogFixtures.clusterGroup());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void getCluster_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getCluster("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void updateCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final GitLabClusterGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .updateCluster("group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateClusterPayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.clusterGroup());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void updateCluster_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateCluster(
                    "group/sub/project", 1L, GroupsCatalogFixtures.groupGroupsUpdateClusterPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void deleteCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final Optional<GitLabClusterGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteCluster("group/sub/project", 1L);
        }

        assertThat(result).contains(GroupsCatalogFixtures.clusterGroup());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void deleteCluster_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteCluster("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void deleteCluster_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabClusterGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteCluster("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void userCluster_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/clusters/user",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterGroup.class, "cluster-group.json")));

        final GitLabClusterGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .userCluster("group/sub/project", GroupsCatalogFixtures.groupClusterUserCreatePayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.clusterGroup());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/clusters/user");
    }

    @Test
    void userCluster_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/clusters/user", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.userCluster("group/sub/project", GroupsCatalogFixtures.groupClusterUserCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/clusters/user");
    }

    @Test
    void getAvatar_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/avatar",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).getAvatar("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getAvatar_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/avatar",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getAvatar("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void listRunners_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/runners",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/runners?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final List<GitLabCiRunnerWithUuid> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listRunners("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciRunnerWithUuid(), CommonCatalogFixtures.ciRunnerWithUuid());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/runners", 2);
    }

    @Test
    void resetRegistrationTokenRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/runners/reset_registration_token",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabGroupGroupsApi(GitLabCaller.of(client)).resetRegistrationTokenRunner("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/runners/reset_registration_token");
    }

    @Test
    void resetRegistrationTokenRunner_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/runners/reset_registration_token",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetRegistrationTokenRunner("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/runners/reset_registration_token");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header("Link", "<" + base + "/api/v4/groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.group());
        HTTP.verifyRequested(POST, "/api/v4/groups");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final Optional<GitLabGroupDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(GroupsCatalogFixtures.groupDetail());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).delete("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject");
    }

    @Test
    void archive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/archive",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).archive("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.group());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/archive");
    }

    @Test
    void archive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/archive", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.archive("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/archive");
    }

    @Test
    void unarchive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/unarchive",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroup.class, "group.json")));

        final GitLabGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).unarchive("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.group());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/unarchive");
    }

    @Test
    void unarchive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/unarchive", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unarchive("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/unarchive");
    }

    @Test
    void restore_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/restore", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).restore("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/restore");
    }

    @Test
    void restore_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/restore", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.restore("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/restore");
    }

    @Test
    void listShared_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/groups/shared",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/groups/shared?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listShared("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/groups/shared", 2);
    }

    @Test
    void listInvitedGroups_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/invited_groups",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/invited_groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listInvitedGroups("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/invited_groups", 2);
    }

    @Test
    void listProjects_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/projects",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabProject.class, "project.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final List<GitLabProject> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listProjects("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.project(), CommonCatalogFixtures.project());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/projects", 2);
    }

    @Test
    void listProjectsShared_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/projects/shared",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabProject.class, "project.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/projects/shared?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final List<GitLabProject> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listProjectsShared("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.project(), CommonCatalogFixtures.project());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/projects/shared", 2);
    }

    @Test
    void listGroup_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/subgroups",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/subgroups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listGroup("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/subgroups", 2);
    }

    @Test
    void listDescendantGroups_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/descendant_groups",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/descendant_groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listDescendantGroups("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/descendant_groups", 2);
    }

    @Test
    void createProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/projects/project_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).createProject("group/sub/project", "project_id");
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/projects/project_id");
    }

    @Test
    void createProject_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/projects/project_id", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createProject("group/sub/project", "project_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/projects/project_id");
    }

    @Test
    void listTransferLocations_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/transfer_locations",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/transfer_locations?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGroup.class, "group.json") + "]"));

        final List<GitLabGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listTransferLocations("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.group(), CommonCatalogFixtures.group());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/transfer_locations", 2);
    }

    @Test
    void transfer_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .transfer("group/sub/project", GroupsCatalogFixtures.groupGroupsTransferPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer");
    }

    @Test
    void transfer_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.transfer("group/sub/project", GroupsCatalogFixtures.groupGroupsTransferPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer");
    }

    @Test
    void transferToOrganization_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/transfer_to_organization",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .transferToOrganization(
                            "group/sub/project", GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer_to_organization");
    }

    @Test
    void transferToOrganization_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer_to_organization", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.transferToOrganization(
                    "group/sub/project", GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/transfer_to_organization");
    }

    @Test
    void share_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/share",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupDetail.class, "group-detail.json")));

        final GitLabGroupDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .share("group/sub/project", GroupsCatalogFixtures.groupGroupsSharePayload());
        }

        assertThat(result).isEqualTo(GroupsCatalogFixtures.groupDetail());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/share");
    }

    @Test
    void share_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/share", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.share("group/sub/project", GroupsCatalogFixtures.groupGroupsSharePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/share");
    }

    @Test
    void deleteShare_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/share/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteShare("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void deleteShare_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/share/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteShare("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void deleteSharedProject_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/shared_projects/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).deleteSharedProject("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/shared_projects/1");
    }

    @Test
    void deleteSharedProject_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/shared_projects/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSharedProject("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/shared_projects/1");
    }

    @Test
    void ldapSync_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_sync", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupsApi(GitLabCaller.of(client)).ldapSync("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_sync");
    }

    @Test
    void ldapSync_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_sync", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupsApi api = new GitLabGroupGroupsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.ldapSync("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_sync");
    }

    @Test
    void listAuditEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/audit_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/audit_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final List<GitLabAuditEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listAuditEvents("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.auditEvent(), CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/audit_events", 2);
    }

    @Test
    void getAuditEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/audit_events/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAuditEvent.class, "audit-event.json")));

        final Optional<GitLabAuditEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupsApi(GitLabCaller.of(client)).getAuditEvent("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/audit_events/1");
    }

    @Test
    void getAuditEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/audit_events/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .getAuditEvent("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/audit_events/1");
    }

    @Test
    void listSamlUsers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_users",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/saml_users?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final List<GitLabUserPublic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listSamlUsers("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userPublic(), CommonCatalogFixtures.userPublic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml_users", 2);
    }

    @Test
    void listProvisionedUsers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/provisioned_users",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/provisioned_users?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserPublic.class, "user-public.json") + "]"));

        final List<GitLabUserPublic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupsApi(GitLabCaller.of(client))
                    .listProvisionedUsers("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userPublic(), CommonCatalogFixtures.userPublic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/provisioned_users", 2);
    }
}
