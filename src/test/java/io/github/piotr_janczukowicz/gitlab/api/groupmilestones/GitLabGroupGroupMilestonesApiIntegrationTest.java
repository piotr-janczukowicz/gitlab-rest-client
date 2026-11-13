package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMilestone;
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
class GitLabGroupGroupMilestonesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMilestone.class, "milestone.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/milestones?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMilestone.class, "milestone.json") + "]"));

        final List<GitLabMilestone> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.milestone(), CommonCatalogFixtures.milestone());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMilestone.class, "milestone.json")));

        final GitLabMilestone result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .create("group/sub/project", GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.milestone());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/milestones");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/milestones", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupMilestonesApi api = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/milestones");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMilestone.class, "milestone.json")));

        final Optional<GitLabMilestone> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.milestone());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMilestone.class, "milestone.json")));

        final GitLabMilestone result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.milestone());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupMilestonesApi api = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupMilestonesApi api = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1");
    }

    @Test
    void listIssues_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/issues",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabIssueBasic.class, "issue-basic.json") + "]"));

        final List<GitLabIssueBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .listIssues("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.issueBasic(), CommonCatalogFixtures.issueBasic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/issues", 2);
    }

    @Test
    void listMergeRequests_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/merge_requests",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/merge_requests?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final List<GitLabMergeRequestBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client))
                    .listMergeRequests("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.mergeRequestBasic(), CommonCatalogFixtures.mergeRequestBasic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/merge_requests", 2);
    }

    @Test
    void callBurndownEvents_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/burndown_events",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client)).callBurndownEvents("group/sub/project", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/burndown_events");
    }

    @Test
    void callBurndownEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/burndown_events",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupMilestonesApi api = new GitLabGroupGroupMilestonesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callBurndownEvents("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/milestones/1/burndown_events");
    }
}
