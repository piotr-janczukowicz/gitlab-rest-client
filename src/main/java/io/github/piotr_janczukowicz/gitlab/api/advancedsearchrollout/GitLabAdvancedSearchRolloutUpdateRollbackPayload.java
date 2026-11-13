package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetween;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4ElasticsearchIndexedNamespacesRollback}.
 *
 * @param percentage the percentage
 * @param plan the plan
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ElasticsearchIndexedNamespacesRollback/requestBody")
public record GitLabAdvancedSearchRolloutUpdateRollbackPayload(
        int percentage, GitLabAdvancedSearchRolloutUpdateRollbackPlan plan) {
    public GitLabAdvancedSearchRolloutUpdateRollbackPayload {
        requireBetween(percentage, 0, 100, "percentage");
        requireNonNull(plan, "plan");
    }
}
