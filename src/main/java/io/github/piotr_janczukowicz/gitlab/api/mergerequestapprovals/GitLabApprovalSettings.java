package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab approval settings.
 *
 * @param approvers the approvers
 * @param approverGroups the approver groups
 * @param approvalsBeforeMerge the approvals before merge
 * @param resetApprovalsOnPush the reset approvals on push
 * @param selectiveCodeOwnerRemovals the selective code owner removals
 * @param disableOverridingApproversPerMergeRequest the disable overriding approvers per merge request
 * @param mergeRequestsAuthorApproval the merge requests author approval
 * @param mergeRequestsDisableCommittersApproval the merge requests disable committers approval
 * @param requirePasswordToApprove the require password to approve
 * @param requireReauthenticationToApprove the require reauthentication to approve
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApprovalSettings")
public record GitLabApprovalSettings(
        @Nullable GitLabApprover approvers,
        @Nullable GitLabApproverGroup approverGroups,
        @Nullable Integer approvalsBeforeMerge,
        @Nullable Boolean resetApprovalsOnPush,
        @Nullable Boolean selectiveCodeOwnerRemovals,
        @Nullable Boolean disableOverridingApproversPerMergeRequest,
        @Nullable Boolean mergeRequestsAuthorApproval,
        @Nullable Boolean mergeRequestsDisableCommittersApproval,
        @Nullable Boolean requirePasswordToApprove,
        @Nullable Boolean requireReauthenticationToApprove) {}
