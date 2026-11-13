package io.github.piotr_janczukowicz.gitlab.api.environments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdEnvironments}, without paging.
 *
 * @param name the name
 * @param search the search
 * @param states the states
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdEnvironments/parameters")
public record GitLabProjectEnvironmentsListFilter(
        @Nullable String name,
        @Nullable String search,
        @Nullable GitLabProjectEnvironmentsListStates states) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectEnvironmentsListFilter empty() {
        return GitLabProjectEnvironmentsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("name", name)
                .text("search", search)
                .wire("states", states, GitLabProjectEnvironmentsListStates::wireValue)
                .build();
    }
}
