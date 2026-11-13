package io.github.piotr_janczukowicz.gitlab.api.todos;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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
class GitLabToDosApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/todos",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabTodo.class, "todo.json") + "]")
                        .header("Link", "<" + base + "/api/v4/todos?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabTodo.class, "todo.json") + "]"));

        final List<GitLabTodo> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabToDosApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.todo(), CommonCatalogFixtures.todo());
        HTTP.verifyRequested(GET, "/api/v4/todos", 2);
    }

    @Test
    void markAsDoneById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/todos/1/mark_as_done",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabToDosApi(GitLabCaller.of(client)).markAsDoneById(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
        HTTP.verifyRequested(POST, "/api/v4/todos/1/mark_as_done");
    }

    @Test
    void markAsDoneById_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/todos/1/mark_as_done", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabToDosApi api = new GitLabToDosApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.markAsDoneById(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/todos/1/mark_as_done");
    }

    @Test
    void markAsDone_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/todos/mark_as_done", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabToDosApi(GitLabCaller.of(client)).markAsDone();
        }

        HTTP.verifyRequested(POST, "/api/v4/todos/mark_as_done");
    }

    @Test
    void markAsDone_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/todos/mark_as_done", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabToDosApi api = new GitLabToDosApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.markAsDone());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/todos/mark_as_done");
    }
}
