package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApprovalRuleShort;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApprovals;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab approval state.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param mergeStatus the merge status
 * @param approved the approved
 * @param approvalsRequired the approvals required
 * @param approvalsLeft the approvals left
 * @param requirePasswordToApprove the require password to approve
 * @param approvedBy the approved by
 * @param suggestedApprovers the suggested approvers
 * @param approvers the approvers
 * @param approverGroups the approver groups
 * @param userHasApproved the user has approved
 * @param userCanApprove the user can approve
 * @param approvalRulesLeft the approval rules left
 * @param hasApprovalRules the has approval rules
 * @param mergeRequestApproversAvailable the merge request approvers available
 * @param multipleApprovalRulesAvailable the multiple approval rules available
 * @param invalidApproversRules the invalid approvers rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApprovalState")
public record GitLabApprovalState(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String mergeStatus,
        @Nullable Boolean approved,
        @Nullable Integer approvalsRequired,
        @Nullable Integer approvalsLeft,
        @Nullable Boolean requirePasswordToApprove,
        @Nullable List<GitLabApprovals> approvedBy,
        @Nullable List<GitLabUserBasic> suggestedApprovers,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> approvers,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> approverGroups,

        @Nullable Boolean userHasApproved,
        @Nullable Boolean userCanApprove,
        @Nullable List<GitLabApprovalRuleShort> approvalRulesLeft,
        @Nullable Boolean hasApprovalRules,
        @Nullable Boolean mergeRequestApproversAvailable,
        @Nullable Boolean multipleApprovalRulesAvailable,
        @Nullable List<GitLabApprovalRuleShort> invalidApproversRules) {}
