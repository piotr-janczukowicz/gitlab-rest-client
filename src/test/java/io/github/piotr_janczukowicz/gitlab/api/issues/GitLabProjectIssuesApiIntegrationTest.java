package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableTimeStats;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectIssuesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void todo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/todo",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).todo("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/todo");
    }

    @Test
    void todo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/todo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.todo("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/todo");
    }

    @Test
    void subscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/subscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .subscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/subscribe");
    }

    @Test
    void subscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/subscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.subscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/subscribe");
    }

    @Test
    void unsubscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/unsubscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .unsubscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/unsubscribe");
    }

    @Test
    void unsubscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/unsubscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unsubscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/subscribable_id/unsubscribe");
    }

    @Test
    void timeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_estimate",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .timeEstimate("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesTimeEstimatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_estimate");
    }

    @Test
    void timeEstimate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_estimate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.timeEstimate(
                    "group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesTimeEstimatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_estimate");
    }

    @Test
    void resetTimeEstimate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_time_estimate",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).resetTimeEstimate("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_time_estimate");
    }

    @Test
    void resetTimeEstimate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_time_estimate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetTimeEstimate("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_time_estimate");
    }

    @Test
    void addSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/add_spent_time",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .addSpentTime("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesAddSpentTimePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/add_spent_time");
    }

    @Test
    void addSpentTime_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/add_spent_time",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.addSpentTime(
                    "group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesAddSpentTimePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/add_spent_time");
    }

    @Test
    void resetSpentTime_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_spent_time",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final GitLabIssuableTimeStats result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).resetSpentTime("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_spent_time");
    }

    @Test
    void resetSpentTime_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_spent_time",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetSpentTime("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reset_spent_time");
    }

    @Test
    void getTimeStats_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_stats",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableTimeStats.class, "issuable-time-stats.json")));

        final Optional<GitLabIssuableTimeStats> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).getTimeStats("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.issuableTimeStats());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_stats");
    }

    @Test
    void getTimeStats_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_stats", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .getTimeStats("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/time_stats");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final List<GitLabIssue> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(IssuesCatalogFixtures.issue(), IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .create("group/sub/project", IssuesCatalogFixtures.projectIssuesCreatePayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", IssuesCatalogFixtures.projectIssuesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final Optional<GitLabIssue> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesUpdatePayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIssuesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1");
    }

    @Test
    void reorder_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reorder",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .reorder("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesReorderPayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reorder");
    }

    @Test
    void reorder_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reorder", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.reorder("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesReorderPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/reorder");
    }

    @Test
    void move_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/move",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .move("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesMovePayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/move");
    }

    @Test
    void move_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/move", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.move("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesMovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/move");
    }

    @Test
    void doClone_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/clone",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final GitLabIssue result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .doClone("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesDoClonePayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/clone");
    }

    @Test
    void doClone_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/clone", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.doClone("group/sub/project", 1L, IssuesCatalogFixtures.projectIssuesDoClonePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/clone");
    }

    @Test
    void listRelatedMergeRequests_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/related_merge_requests",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final List<GitLabMergeRequestBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .listRelatedMergeRequests("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/related_merge_requests");
    }

    @Test
    void listClosedBy_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/closed_by",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final List<GitLabMergeRequestBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).listClosedBy("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/closed_by");
    }

    @Test
    void listParticipants_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/participants",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).listParticipants("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/participants");
    }

    @Test
    void getUserAgentDetail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/user_agent_detail",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserAgentDetail.class, "user-agent-detail.json")));

        final Optional<GitLabUserAgentDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).getUserAgentDetail("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.userAgentDetail());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/user_agent_detail");
    }

    @Test
    void getUserAgentDetail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/user_agent_detail",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .getUserAgentDetail("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/user_agent_detail");
    }

    @Test
    void authorizeMetricImage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIssuesApi(GitLabCaller.of(client)).authorizeMetricImage("group/sub/project", 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/authorize");
    }

    @Test
    void authorizeMetricImage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeMetricImage("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/authorize");
    }

    @Test
    void getMetricImages_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableMetricImage.class, "issuable-metric-image.json")));

        final Optional<GitLabIssuableMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).getMetricImages("group/sub/project", 1L);
        }

        assertThat(result).contains(IssuesCatalogFixtures.issuableMetricImage());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images");
    }

    @Test
    void getMetricImages_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .getMetricImages("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images");
    }

    @Test
    void createMetricImage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableMetricImage.class, "issuable-metric-image.json")));

        final GitLabIssuableMetricImage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .createMetricImage(
                            "group/sub/project",
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issuableMetricImage());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images");
    }

    @Test
    void createMetricImage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMetricImage(
                    "group/sub/project",
                    1L,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images");
    }

    @Test
    void updateMetricImage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableMetricImage.class, "issuable-metric-image.json")));

        final GitLabIssuableMetricImage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client))
                    .updateMetricImage(
                            "group/sub/project", 1L, 1L, IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload());
        }

        assertThat(result).isEqualTo(IssuesCatalogFixtures.issuableMetricImage());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1");
    }

    @Test
    void updateMetricImage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMetricImage(
                    "group/sub/project", 1L, 1L, IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1");
    }

    @Test
    void deleteMetricImage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIssuableMetricImage.class, "issuable-metric-image.json")));

        final Optional<GitLabIssuableMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).deleteMetricImage("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(IssuesCatalogFixtures.issuableMetricImage());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1");
    }

    @Test
    void deleteMetricImage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssuesApi api = new GitLabProjectIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMetricImage("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1");
    }

    @Test
    void deleteMetricImage_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabIssuableMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssuesApi(GitLabCaller.of(client)).deleteMetricImage("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/metric_images/1");
    }
}
