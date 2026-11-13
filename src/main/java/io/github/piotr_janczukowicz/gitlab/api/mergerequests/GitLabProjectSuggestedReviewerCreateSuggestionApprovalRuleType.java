package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project suggested reviewer create suggestion approval rule type. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidSuggestedReviewers/requestBody/properties/suggestions/items/properties/approval_rule_type")
public enum GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType {
    MERGE_REQUEST_RULE("merge_request_rule"),
    PROJECT_RULE("project_rule");

    private static final EnumUtils.WireIndex<GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.class,
                    GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType::wireValue);

    private final String wireValue;

    GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
