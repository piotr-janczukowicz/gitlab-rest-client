package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdVariablesKey}, without paging.
 *
 * @param filterEnvironmentScope the filter environment scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdVariablesKey/parameters")
public record GitLabProjectProjectLevelVariablesDeleteFilter(
        @Nullable @JsonProperty("filter[environment_scope]") String filterEnvironmentScope) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectLevelVariablesDeleteFilter empty() {
        return GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("filter[environment_scope]", filterEnvironmentScope)
                .build();
    }
}
