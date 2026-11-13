package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectExternalStatusChecksApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectExternalStatusChecksApi api() {
        return new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectExternalStatusChecksApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")
                                + "]"));

        final GitLabPage<GitLabExternalStatusCheck> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/external_status_checks");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")
                                + "]"));

        final GitLabPage<GitLabExternalStatusCheck> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/external_status_checks");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                "group/sub/project", ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                "group/sub/project", ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")));

        final GitLabExternalStatusCheck result = api().create(
                        "group/sub/project",
                        ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/external_status_checks");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project",
                        ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                1L,
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                1L,
                ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")));

        final GitLabExternalStatusCheck result = api().update(
                        "group/sub/project",
                        1L,
                        ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        1L,
                        ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listMergeRequestsStatusChecks_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listMergeRequestsStatusChecks("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listMergeRequestsStatusChecks_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listMergeRequestsStatusChecks("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listMergeRequestsStatusChecks_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabMergeRequestsStatusCheck.class, "merge-requests-status-check.json")
                                + "]"));

        final List<GitLabMergeRequestsStatusCheck> result =
                api().listMergeRequestsStatusChecks("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks");
        });
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectExternalStatusChecksApi lowTier =
                new GitLabProjectExternalStatusChecksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks/1/retry");
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
