package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryCompare}, without paging.
 *
 * @param fromProjectId the from project id
 * @param straight the straight
 * @param unidiff the unidiff
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCompare/parameters")
public record GitLabProjectRepositoriesGetCompareFilter(
        @Nullable Long fromProjectId,
        @Nullable Boolean straight,
        @Nullable Boolean unidiff) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesGetCompareFilter empty() {
        return GitLabProjectRepositoriesGetCompareFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("from_project_id", fromProjectId)
                .value("straight", straight)
                .value("unidiff", unidiff)
                .build();
    }
}
