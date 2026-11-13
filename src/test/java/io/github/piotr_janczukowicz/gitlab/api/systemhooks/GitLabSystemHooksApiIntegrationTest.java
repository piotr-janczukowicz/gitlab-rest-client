package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

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
class GitLabSystemHooksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void updateUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/hooks/1/url_variables/key", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSystemHooksApi(GitLabCaller.of(client))
                    .updateUrlVariable(1L, "key", SystemhooksCatalogFixtures.systemHooksUpdateUrlVariablePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/hooks/1/url_variables/key");
    }

    @Test
    void updateUrlVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/hooks/1/url_variables/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.updateUrlVariable(1L, "key", SystemhooksCatalogFixtures.systemHooksUpdateUrlVariablePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/hooks/1/url_variables/key");
    }

    @Test
    void deleteUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1/url_variables/key", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSystemHooksApi(GitLabCaller.of(client)).deleteUrlVariable(1L, "key");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1/url_variables/key");
    }

    @Test
    void deleteUrlVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1/url_variables/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUrlVariable(1L, "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1/url_variables/key");
    }

    @Test
    void updateCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/hooks/1/custom_headers/key", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSystemHooksApi(GitLabCaller.of(client))
                    .updateCustomHeader(1L, "key", SystemhooksCatalogFixtures.systemHooksUpdateCustomHeaderPayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/hooks/1/custom_headers/key");
    }

    @Test
    void updateCustomHeader_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/hooks/1/custom_headers/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateCustomHeader(
                    1L, "key", SystemhooksCatalogFixtures.systemHooksUpdateCustomHeaderPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/hooks/1/custom_headers/key");
    }

    @Test
    void deleteCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1/custom_headers/key", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSystemHooksApi(GitLabCaller.of(client)).deleteCustomHeader(1L, "key");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1/custom_headers/key");
    }

    @Test
    void deleteCustomHeader_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1/custom_headers/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteCustomHeader(1L, "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1/custom_headers/key");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/hooks",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabHook.class, "hook.json") + "]")
                        .header("Link", "<" + base + "/api/v4/hooks?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabHook.class, "hook.json") + "]"));

        final List<GitLabHook> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabSystemHooksApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(SystemhooksCatalogFixtures.hook(), SystemhooksCatalogFixtures.hook());
        HTTP.verifyRequested(GET, "/api/v4/hooks", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/hooks",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabHook.class, "hook.json")));

        final GitLabHook result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSystemHooksApi(GitLabCaller.of(client))
                    .create(SystemhooksCatalogFixtures.systemHooksCreatePayload());
        }

        assertThat(result).isEqualTo(SystemhooksCatalogFixtures.hook());
        HTTP.verifyRequested(POST, "/api/v4/hooks");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/hooks", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(SystemhooksCatalogFixtures.systemHooksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/hooks");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabHook.class, "hook.json")));

        final Optional<GitLabHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSystemHooksApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(SystemhooksCatalogFixtures.hook());
        HTTP.verifyRequested(GET, "/api/v4/hooks/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/hooks/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabSystemHooksApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/hooks/1");
    }

    @Test
    void createByHookId_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/hooks/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSystemHooksApi(GitLabCaller.of(client)).createByHookId(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/hooks/1");
    }

    @Test
    void createByHookId_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/hooks/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createByHookId(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/hooks/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabHook.class, "hook.json")));

        final GitLabHook result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSystemHooksApi(GitLabCaller.of(client))
                    .update(1L, SystemhooksCatalogFixtures.systemHooksUpdatePayload());
        }

        assertThat(result).isEqualTo(SystemhooksCatalogFixtures.hook());
        HTTP.verifyRequested(PUT, "/api/v4/hooks/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/hooks/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, SystemhooksCatalogFixtures.systemHooksUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/hooks/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/hooks/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabHook.class, "hook.json")));

        final Optional<GitLabHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSystemHooksApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(SystemhooksCatalogFixtures.hook());
        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSystemHooksApi api = new GitLabSystemHooksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/hooks/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabHook> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSystemHooksApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/hooks/1");
    }
}
