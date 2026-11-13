package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project suggested reviewer create suggestion of a GitLab resource.
 *
 * @param userId the user id
 * @param reason the reason
 * @param approvalRuleId the approval rule id
 * @param approvalRuleType the approval rule type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidSuggestedReviewers/requestBody/properties/suggestions/items")
public record GitLabProjectSuggestedReviewerCreateSuggestion(
        @Nullable Long userId,
        @Nullable String reason,
        @Nullable Long approvalRuleId,
        GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType approvalRuleType) {
    public GitLabProjectSuggestedReviewerCreateSuggestion {
        requireMaxLengthIfPresent(reason, 2048, "reason");
        requireNonNull(approvalRuleType, "approvalRuleType");
    }
}
