package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ApplicationPlanLimits}, without paging.
 *
 * @param planName the plan name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ApplicationPlanLimits/parameters")
public record GitLabPlanLimitsGetFilter(@Nullable GitLabPlanLimitsGetPlanName planName) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabPlanLimitsGetFilter empty() {
        return GitLabPlanLimitsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("plan_name", planName, GitLabPlanLimitsGetPlanName::wireValue)
                .build();
    }
}
