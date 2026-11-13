package io.github.piotr_janczukowicz.gitlab.api.epics;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicIssue;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelatedEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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
class GitLabGroupEpicsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listRelatedEpicLinks_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/related_epic_links",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/related_epic_links?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final List<GitLabRelatedEpic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .listRelatedEpicLinks("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.relatedEpic(), CommonCatalogFixtures.relatedEpic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/related_epic_links", 2);
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/epics?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final List<GitLabEpic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.epic(), CommonCatalogFixtures.epic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics", 2);
    }

    @Test
    void listDashed_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/epics",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/-/epics?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final List<GitLabEpic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .listDashed("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.epic(), CommonCatalogFixtures.epic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/epics", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final Optional<GitLabEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void getDashed_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final Optional<GitLabEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client)).getDashed("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/epics/1");
    }

    @Test
    void getDashed_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/epics/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .getDashed("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/epics/1");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupEpicsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void listIssues_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/epics/epic_iid/issues",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/-/epics/epic_iid/issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]"));

        final List<GitLabEpicIssue> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .listIssues("group/sub/project", "epic_iid")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.epicIssue(), CommonCatalogFixtures.epicIssue());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/epics/epic_iid/issues", 2);
    }

    @Test
    void todo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/todo",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client)).todo("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/todo");
    }

    @Test
    void todo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/todo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.todo("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/todo");
    }

    @Test
    void listAwardEmoji_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final List<GitLabAwardEmoji> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .listAwardEmoji("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.awardEmoji(), CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji", 2);
    }

    @Test
    void createAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .createAwardEmoji(
                            "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji");
    }

    @Test
    void createAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAwardEmoji(
                    "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji");
    }

    @Test
    void getAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicsApi(GitLabCaller.of(client)).getAwardEmoji("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
    }

    @Test
    void getAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupEpicsApi(GitLabCaller.of(client))
                    .getAwardEmoji("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupEpicsApi(GitLabCaller.of(client)).deleteAwardEmoji("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicsApi api = new GitLabGroupEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteAwardEmoji("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
    }
}
