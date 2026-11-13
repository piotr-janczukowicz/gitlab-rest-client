package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestApprovals;
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
class GitLabProjectMergeRequestApprovalsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listMergeRequestsApprovalRules_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")
                        + "]"));

        final List<GitLabMergeRequestApprovalRule> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .listMergeRequestsApprovalRules("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule(),
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules", 2);
    }

    @Test
    void createMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final GitLabMergeRequestApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .createMergeRequestsApprovalRule(
                            "group/sub/project",
                            1L,
                            MergerequestapprovalsCatalogFixtures
                                    .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload());
        }

        assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules");
    }

    @Test
    void createMergeRequestsApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMergeRequestsApprovalRule(
                    "group/sub/project",
                    1L,
                    MergerequestapprovalsCatalogFixtures
                            .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules");
    }

    @Test
    void getMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final Optional<GitLabMergeRequestApprovalRule> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .getMergeRequestsApprovalRule("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void getMergeRequestsApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .getMergeRequestsApprovalRule("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final GitLabMergeRequestApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .updateMergeRequestsApprovalRule(
                            "group/sub/project",
                            1L,
                            1L,
                            MergerequestapprovalsCatalogFixtures
                                    .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload());
        }

        assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMergeRequestsApprovalRule(
                    "group/sub/project",
                    1L,
                    1L,
                    MergerequestapprovalsCatalogFixtures
                            .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void getApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/approvals",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApprovalSettings.class, "approval-settings.json")));

        final GitLabApprovalSettings result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .getApprovals("group/sub/project");
        }

        assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalSettings());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approvals");
    }

    @Test
    void getApprovals_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/approvals", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getApprovals("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approvals");
    }

    @Test
    void createApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/approvals",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApprovalSettings.class, "approval-settings.json")));

        final GitLabApprovalSettings result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .createApprovals(
                            "group/sub/project",
                            MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload());
        }

        assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalSettings());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approvals");
    }

    @Test
    void createApprovals_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/approvals", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createApprovals(
                    "group/sub/project",
                    MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approvals");
    }

    @Test
    void getRequestsApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final Optional<GitLabMergeRequestApprovals> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .getRequestsApprovals("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.mergeRequestApprovals());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
    }

    @Test
    void getRequestsApprovals_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .getRequestsApprovals("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
    }

    @Test
    void createRequestsApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabApprovalState.class, "approval-state.json")));

        final GitLabApprovalState result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client))
                    .createRequestsApprovals(
                            "group/sub/project",
                            1L,
                            MergerequestapprovalsCatalogFixtures
                                    .projectMergeRequestApprovalsCreateRequestsApprovalsPayload());
        }

        assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalState());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
    }

    @Test
    void createRequestsApprovals_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestApprovalsApi api =
                    new GitLabProjectMergeRequestApprovalsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRequestsApprovals(
                    "group/sub/project",
                    1L,
                    MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateRequestsApprovalsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
    }
}
