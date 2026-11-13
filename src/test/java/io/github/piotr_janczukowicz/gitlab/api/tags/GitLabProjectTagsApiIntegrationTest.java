package io.github.piotr_janczukowicz.gitlab.api.tags;

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
class GitLabProjectTagsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabTag.class, "tag.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/tags?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabTag.class, "tag.json") + "]"));

        final List<GitLabTag> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectTagsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(TagsCatalogFixtures.tag(), TagsCatalogFixtures.tag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTag.class, "tag.json")));

        final GitLabTag result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTagsApi(GitLabCaller.of(client))
                    .create("group/sub/project", TagsCatalogFixtures.projectTagsCreatePayload());
        }

        assertThat(result).isEqualTo(TagsCatalogFixtures.tag());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTagsApi api = new GitLabProjectTagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", TagsCatalogFixtures.projectTagsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTag.class, "tag.json")));

        final Optional<GitLabTag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTagsApi(GitLabCaller.of(client)).get("group/sub/project", "tag_name");
        }

        assertThat(result).contains(TagsCatalogFixtures.tag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectTagsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "tag_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTagsApi(GitLabCaller.of(client)).delete("group/sub/project", "tag_name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTagsApi api = new GitLabProjectTagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "tag_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name");
    }

    @Test
    void getSignature_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name/signature",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTagSignature.class, "tag-signature.json")));

        final Optional<GitLabTagSignature> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTagsApi(GitLabCaller.of(client)).getSignature("group/sub/project", "tag_name");
        }

        assertThat(result).contains(TagsCatalogFixtures.tagSignature());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name/signature");
    }

    @Test
    void getSignature_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name/signature",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectTagsApi(GitLabCaller.of(client))
                    .getSignature("group/sub/project", "tag_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tags/tag_name/signature");
    }
}
