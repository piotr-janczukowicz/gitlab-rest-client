package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectExternalStatusChecksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json") + "]"));

        final List<GitLabExternalStatusCheck> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck(),
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")));

        final GitLabExternalStatusCheck result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload());
        }

        assertThat(result).isEqualTo(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectExternalStatusChecksApi api =
                    new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabExternalStatusCheck.class, "external-status-check.json")));

        final GitLabExternalStatusCheck result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload());
        }

        assertThat(result).isEqualTo(ExternalstatuschecksCatalogFixtures.externalStatusCheck());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectExternalStatusChecksApi api =
                    new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    1L,
                    ExternalstatuschecksCatalogFixtures.projectExternalStatusChecksUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectExternalStatusChecksApi api =
                    new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/external_status_checks/1");
    }

    @Test
    void listMergeRequestsStatusChecks_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabMergeRequestsStatusCheck.class, "merge-requests-status-check.json")
                        + "]"));

        final List<GitLabMergeRequestsStatusCheck> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client))
                    .listMergeRequestsStatusChecks("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks");
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks/1/retry",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client))
                    .retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks/1/retry");
    }

    @Test
    void retryMergeRequestsStatusCheck_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks/1/retry",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectExternalStatusChecksApi api =
                    new GitLabProjectExternalStatusChecksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.retryMergeRequestsStatusCheck("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/status_checks/1/retry");
    }
}
