package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class MergerequestapprovalsCatalogFixtures {

    private MergerequestapprovalsCatalogFixtures() {}

    public static GitLabApprovalSettings approvalSettings() {
        return GitLabApprovalSettingsBuilder.builder()
                .approvers(MergerequestapprovalsCatalogFixtures.approver())
                .approverGroups(MergerequestapprovalsCatalogFixtures.approverGroup())
                .approvalsBeforeMerge(1)
                .resetApprovalsOnPush(true)
                .selectiveCodeOwnerRemovals(true)
                .disableOverridingApproversPerMergeRequest(true)
                .mergeRequestsAuthorApproval(true)
                .mergeRequestsDisableCommittersApproval(true)
                .requirePasswordToApprove(true)
                .requireReauthenticationToApprove(true)
                .build();
    }

    public static GitLabApprovalState approvalState() {
        return GitLabApprovalStateBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeStatus("can_be_merged")
                .approved(true)
                .approvalsRequired(1)
                .approvalsLeft(1)
                .requirePasswordToApprove(true)
                .approvedBy(List.of(CommonCatalogFixtures.approvals()))
                .suggestedApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvers(List.of(Map.of("key", "value")))
                .approverGroups(List.of(Map.of("key", "value")))
                .userHasApproved(true)
                .userCanApprove(true)
                .approvalRulesLeft(List.of(CommonCatalogFixtures.approvalRuleShort()))
                .hasApprovalRules(true)
                .mergeRequestApproversAvailable(true)
                .multipleApprovalRulesAvailable(true)
                .invalidApproversRules(List.of(CommonCatalogFixtures.approvalRuleShort()))
                .build();
    }

    public static GitLabApprover approver() {
        return GitLabApproverBuilder.builder()
                .user(CommonCatalogFixtures.userBasic())
                .build();
    }

    public static GitLabApproverGroup approverGroup() {
        return GitLabApproverGroupBuilder.builder()
                .group(CommonCatalogFixtures.group())
                .build();
    }

    public static GitLabMergeRequestApprovalRule mergeRequestApprovalRule() {
        return GitLabMergeRequestApprovalRuleBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .eligibleApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvalsRequired(1)
                .users(List.of(CommonCatalogFixtures.userBasic()))
                .groups(List.of(CommonCatalogFixtures.group()))
                .containsHiddenGroups(true)
                .reportType("report_type")
                .section("Backend")
                .sourceRule(CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule())
                .overridden(true)
                .build();
    }

    public static GitLabProjectMergeRequestApprovalsCreateApprovalsPayload
            projectMergeRequestApprovalsCreateApprovalsPayload() {
        return GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder()
                .approvalsBeforeMerge(1)
                .resetApprovalsOnPush(true)
                .selectiveCodeOwnerRemovals(true)
                .disableOverridingApproversPerMergeRequest(true)
                .mergeRequestsAuthorApproval(true)
                .mergeRequestsDisableCommittersApproval(true)
                .requirePasswordToApprove(true)
                .requireReauthenticationToApprove(true)
                .build();
    }

    public static GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload
            projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload() {
        return GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .approvalProjectRuleId(1L)
                .userIds(List.of(1L))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .build();
    }

    public static GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload
            projectMergeRequestApprovalsCreateRequestsApprovalsPayload() {
        return GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayloadBuilder.builder()
                .approvalsRequired(1)
                .build();
    }

    public static GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload
            projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload() {
        return GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .userIds(List.of(1L))
                .groupIds(List.of(1L))
                .usernames(List.of("usernames"))
                .removeHiddenGroups(true)
                .build();
    }
}
