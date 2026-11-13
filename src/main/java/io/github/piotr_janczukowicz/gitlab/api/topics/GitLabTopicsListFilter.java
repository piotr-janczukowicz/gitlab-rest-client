package io.github.piotr_janczukowicz.gitlab.api.topics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Topics}, without paging.
 *
 * @param search the search
 * @param withoutProjects the without projects
 * @param organizationId the organization id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Topics/parameters")
public record GitLabTopicsListFilter(
        @Nullable String search,
        @Nullable Boolean withoutProjects,
        @Nullable Long organizationId) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabTopicsListFilter empty() {
        return GitLabTopicsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("search", search)
                .value("without_projects", withoutProjects)
                .value("organization_id", organizationId)
                .build();
    }
}
