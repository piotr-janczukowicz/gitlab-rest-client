package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestApprovals;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectMergeRequestApprovalsApi api() {
        return new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectMergeRequestApprovalsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listMergeRequestsApprovalRules_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listMergeRequestsApprovalRules("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listMergeRequestsApprovalRules_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listMergeRequestsApprovalRules("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listMergeRequestsApprovalRules_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestApprovalRule> page =
                api().listMergeRequestsApprovalRules("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules");
        });
    }

    @Test
    void listMergeRequestsApprovalRules_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")
                                + "]"));

        final GitLabPage<GitLabMergeRequestApprovalRule> page =
                api().listMergeRequestsApprovalRules("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createMergeRequestsApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createMergeRequestsApprovalRule(
                "group/sub/project",
                1L,
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createMergeRequestsApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createMergeRequestsApprovalRule(
                "group/sub/project",
                1L,
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final GitLabMergeRequestApprovalRule result = api().createMergeRequestsApprovalRule(
                        "group/sub/project",
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createMergeRequestsApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMergeRequestsApprovalRule(
                        "group/sub/project",
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMergeRequestsApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.getMergeRequestsApprovalRule("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getMergeRequestsApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.getMergeRequestsApprovalRule("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final Optional<GitLabMergeRequestApprovalRule> result =
                api().getMergeRequestsApprovalRule("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
        });
    }

    @Test
    void getMergeRequestsApprovalRule_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequestApprovalRule> result =
                api().getMergeRequestsApprovalRule("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateMergeRequestsApprovalRule(
                "group/sub/project",
                1L,
                1L,
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateMergeRequestsApprovalRule(
                "group/sub/project",
                1L,
                1L,
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalRule.class, "merge-request-approval-rule.json")));

        final GitLabMergeRequestApprovalRule result = api().updateMergeRequestsApprovalRule(
                        "group/sub/project",
                        1L,
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateMergeRequestsApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMergeRequestsApprovalRule(
                        "group/sub/project",
                        1L,
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approval_rules/1");
    }

    @Test
    void deleteMergeRequestsApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteMergeRequestsApprovalRule("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getApprovals_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovals("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getApprovals_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovals("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabApprovalSettings.class, "approval-settings.json")));

        final GitLabApprovalSettings result = api().getApprovals("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalSettings());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/approvals");
        });
    }

    @Test
    void getApprovals_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getApprovals("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createApprovals_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovals(
                "group/sub/project",
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createApprovals_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovals(
                "group/sub/project",
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabApprovalSettings.class, "approval-settings.json")));

        final GitLabApprovalSettings result = api().createApprovals(
                        "group/sub/project",
                        MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalSettings());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/approvals");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"approvals_before_merge\":");
        });
    }

    @Test
    void createApprovals_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createApprovals(
                        "group/sub/project",
                        MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRequestsApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMergeRequestApprovals.class, "merge-request-approvals.json")));

        final Optional<GitLabMergeRequestApprovals> result = api().getRequestsApprovals("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.mergeRequestApprovals());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
        });
    }

    @Test
    void getRequestsApprovals_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeRequestApprovals> result = api().getRequestsApprovals("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void createRequestsApprovals_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createRequestsApprovals(
                "group/sub/project",
                1L,
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateRequestsApprovalsPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createRequestsApprovals_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalsApi lowTier =
                new GitLabProjectMergeRequestApprovalsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createRequestsApprovals(
                "group/sub/project",
                1L,
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateRequestsApprovalsPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createRequestsApprovals_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabApprovalState.class, "approval-state.json")));

        final GitLabApprovalState result = api().createRequestsApprovals(
                        "group/sub/project",
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsCreateRequestsApprovalsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(MergerequestapprovalsCatalogFixtures.approvalState());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/approvals");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"approvals_required\":");
        });
    }

    @Test
    void createRequestsApprovals_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRequestsApprovals(
                        "group/sub/project",
                        1L,
                        MergerequestapprovalsCatalogFixtures
                                .projectMergeRequestApprovalsCreateRequestsApprovalsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
