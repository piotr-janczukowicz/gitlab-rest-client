package io.github.piotr_janczukowicz.gitlab.api.discussions;

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
class GitLabGroupDiscussionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDiscussion.class, "discussion.json") + "]"));

        final List<GitLabDiscussion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupDiscussionsApi(GitLabCaller.of(client))
                    .list("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(DiscussionsCatalogFixtures.discussion(), DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupDiscussionsApi(GitLabCaller.of(client))
                    .create("group/sub/project", 1L, DiscussionsCatalogFixtures.groupDiscussionsCreatePayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDiscussionsApi api = new GitLabGroupDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", 1L, DiscussionsCatalogFixtures.groupDiscussionsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final Optional<GitLabDiscussion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupDiscussionsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L, "discussion_id");
        }

        assertThat(result).contains(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupDiscussionsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L, "discussion_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDiscussion.class, "discussion.json")));

        final GitLabDiscussion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupDiscussionsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            "discussion_id",
                            DiscussionsCatalogFixtures.groupDiscussionsUpdatePayload());
        }

        assertThat(result).isEqualTo(DiscussionsCatalogFixtures.discussion());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupDiscussionsApi api = new GitLabGroupDiscussionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    1L,
                    "discussion_id",
                    DiscussionsCatalogFixtures.groupDiscussionsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/discussions/discussion_id");
    }
}
