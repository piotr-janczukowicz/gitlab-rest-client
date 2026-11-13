package io.github.piotr_janczukowicz.gitlab.api.groupplaceholderreassignments;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupGroupPlaceholderReassignmentsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabGroupGroupPlaceholderReassignmentsApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments");
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupPlaceholderReassignmentsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupPlaceholderReassignmentsApi api =
                    new GitLabGroupGroupPlaceholderReassignmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments");
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupPlaceholderReassignmentsApi(GitLabCaller.of(client)).authorize("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupPlaceholderReassignmentsApi api =
                    new GitLabGroupGroupPlaceholderReassignmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/placeholder_reassignments/authorize");
    }
}
