package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabProjectProtectedTagsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_tags",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProtectedTag.class, "protected-tag.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/protected_tags?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProtectedTag.class, "protected-tag.json") + "]"));

        final List<GitLabProtectedTag> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProtectedtagsCatalogFixtures.protectedTag(), ProtectedtagsCatalogFixtures.protectedTag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_tags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProtectedTag.class, "protected-tag.json")));

        final GitLabProtectedTag result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client))
                    .create("group/sub/project", ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload());
        }

        assertThat(result).isEqualTo(ProtectedtagsCatalogFixtures.protectedTag());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedTagsApi api = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", ProtectedtagsCatalogFixtures.projectProtectedTagsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProtectedTag.class, "protected-tag.json")));

        final Optional<GitLabProtectedTag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client)).get("group/sub/project", "name");
        }

        assertThat(result).contains(ProtectedtagsCatalogFixtures.protectedTag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProtectedTagsApi(GitLabCaller.of(client)).delete("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedTagsApi api = new GitLabProjectProtectedTagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_tags/name");
    }
}
