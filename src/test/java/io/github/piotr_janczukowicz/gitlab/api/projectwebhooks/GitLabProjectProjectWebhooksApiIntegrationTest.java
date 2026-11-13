package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProjectWebhooksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void updateUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .updateUrlVariable(
                            "group/sub/project",
                            1L,
                            "key",
                            ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariablePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key");
    }

    @Test
    void updateUrlVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateUrlVariable(
                    "group/sub/project",
                    1L,
                    "key",
                    ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariablePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key");
    }

    @Test
    void deleteUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .deleteUrlVariable("group/sub/project", 1L, "key");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key");
    }

    @Test
    void deleteUrlVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUrlVariable("group/sub/project", 1L, "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/url_variables/key");
    }

    @Test
    void updateCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .updateCustomHeader(
                            "group/sub/project",
                            1L,
                            "key",
                            ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeaderPayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
    }

    @Test
    void updateCustomHeader_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateCustomHeader(
                    "group/sub/project",
                    1L,
                    "key",
                    ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeaderPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
    }

    @Test
    void deleteCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .deleteCustomHeader("group/sub/project", 1L, "key");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
    }

    @Test
    void deleteCustomHeader_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteCustomHeader("group/sub/project", 1L, "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProjectHook.class, "project-hook.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/hooks?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectHook.class, "project-hook.json") + "]"));

        final List<GitLabProjectHook> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectwebhooksCatalogFixtures.projectHook(), ProjectwebhooksCatalogFixtures.projectHook());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectHook.class, "project-hook.json")));

        final GitLabProjectHook result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .create("group/sub/project", ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload());
        }

        assertThat(result).isEqualTo(ProjectwebhooksCatalogFixtures.projectHook());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectHook.class, "project-hook.json")));

        final Optional<GitLabProjectHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectwebhooksCatalogFixtures.projectHook());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectHook.class, "project-hook.json")));

        final GitLabProjectHook result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload());
        }

        assertThat(result).isEqualTo(ProjectwebhooksCatalogFixtures.projectHook());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectHook.class, "project-hook.json")));

        final Optional<GitLabProjectHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectwebhooksCatalogFixtures.projectHook());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabProjectHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void callEvents_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client)).callEvents("group/sub/project", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events");
    }

    @Test
    void callEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callEvents("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events");
    }

    @Test
    void createTest_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/test/confidential_issues_events",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client))
                    .createTest(
                            "group/sub/project",
                            1L,
                            GitLabProjectProjectWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/test/confidential_issues_events");
    }

    @Test
    void createTest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/test/confidential_issues_events",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createTest(
                    "group/sub/project", 1L, GitLabProjectProjectWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/test/confidential_issues_events");
    }

    @Test
    void resendEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events/1/resend",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client)).resendEvent("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events/1/resend");
    }

    @Test
    void resendEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events/1/resend",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectWebhooksApi api = new GitLabProjectProjectWebhooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resendEvent("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/hooks/1/events/1/resend");
    }
}
