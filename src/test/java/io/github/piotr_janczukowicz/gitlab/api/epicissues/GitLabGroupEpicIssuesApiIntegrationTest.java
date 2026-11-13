package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicIssue;
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
class GitLabGroupEpicIssuesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpicIssueLink.class, "epic-issue-link.json")));

        final GitLabEpicIssueLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client))
                    .create("group/sub/project", "epic_iid", "epic_issue_id");
        }

        assertThat(result).isEqualTo(EpicissuesCatalogFixtures.epicIssueLink());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicIssuesApi api = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create("group/sub/project", "epic_iid", "epic_issue_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void update_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]"));

        final List<GitLabEpicIssue> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "epic_iid",
                            "epic_issue_id",
                            EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload());
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.epicIssue());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpicIssueLink.class, "epic-issue-link.json")));

        final Optional<GitLabEpicIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "epic_iid", "epic_issue_id");
        }

        assertThat(result).contains(EpicissuesCatalogFixtures.epicIssueLink());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicIssuesApi api = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "epic_iid", "epic_issue_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabEpicIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "epic_iid", "epic_issue_id");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues/epic_issue_id");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]"));

        final List<GitLabEpicIssue> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupEpicIssuesApi(GitLabCaller.of(client))
                    .list("group/sub/project", "epic_iid")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.epicIssue(), CommonCatalogFixtures.epicIssue());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/epic_iid/issues", 2);
    }
}
