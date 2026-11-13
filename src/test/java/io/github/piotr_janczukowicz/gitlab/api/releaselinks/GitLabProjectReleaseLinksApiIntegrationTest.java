package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

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
class GitLabProjectReleaseLinksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabReleaseLink.class, "release-link.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabReleaseLink.class, "release-link.json") + "]"));

        final List<GitLabReleaseLink> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .list("group/sub/project", "tag_name")
                    .all();
        }

        assertThat(items)
                .containsExactly(ReleaselinksCatalogFixtures.releaseLink(), ReleaselinksCatalogFixtures.releaseLink());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabReleaseLink.class, "release-link.json")));

        final GitLabReleaseLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            "tag_name",
                            ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload());
        }

        assertThat(result).isEqualTo(ReleaselinksCatalogFixtures.releaseLink());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleaseLinksApi api = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", "tag_name", ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabReleaseLink.class, "release-link.json")));

        final Optional<GitLabReleaseLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client)).get("group/sub/project", "tag_name", 1L);
        }

        assertThat(result).contains(ReleaselinksCatalogFixtures.releaseLink());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .get("group/sub/project", "tag_name", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabReleaseLink.class, "release-link.json")));

        final GitLabReleaseLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "tag_name",
                            1L,
                            ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload());
        }

        assertThat(result).isEqualTo(ReleaselinksCatalogFixtures.releaseLink());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleaseLinksApi api = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "tag_name",
                    1L,
                    ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabReleaseLink.class, "release-link.json")));

        final Optional<GitLabReleaseLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "tag_name", 1L);
        }

        assertThat(result).contains(ReleaselinksCatalogFixtures.releaseLink());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleaseLinksApi api = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "tag_name", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabReleaseLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleaseLinksApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "tag_name", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/assets/links/1");
    }
}
