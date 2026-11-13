package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
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
class GitLabProjectProjectSnippetsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/snippets?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json") + "]"));

        final List<GitLabProjectSnippet> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsnippetsCatalogFixtures.projectSnippet(),
                        ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final GitLabProjectSnippet result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .create("group/sub/project", ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload());
        }

        assertThat(result).isEqualTo(ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectSnippetsApi api = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/snippets");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final GitLabProjectSnippet result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload());
        }

        assertThat(result).isEqualTo(ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectSnippetsApi api = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectSnippetsApi api = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void getRaw_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/raw",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client)).getRaw("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/raw");
    }

    @Test
    void getRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/raw", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .getRaw("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/raw");
    }

    @Test
    void getFilesRaw_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/files/ref/file_path/raw",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .getFilesRaw("group/sub/project", 1L, "ref", "file_path");
        }

        assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/files/ref/file_path/raw");
    }

    @Test
    void getFilesRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/files/ref/file_path/raw",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .getFilesRaw("group/sub/project", 1L, "ref", "file_path")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/files/ref/file_path/raw");
    }

    @Test
    void getUserAgentDetail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/user_agent_detail",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserAgentDetail.class, "user-agent-detail.json")));

        final Optional<GitLabUserAgentDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .getUserAgentDetail("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.userAgentDetail());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/user_agent_detail");
    }

    @Test
    void getUserAgentDetail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/user_agent_detail",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectSnippetsApi(GitLabCaller.of(client))
                    .getUserAgentDetail("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/snippets/1/user_agent_detail");
    }
}
