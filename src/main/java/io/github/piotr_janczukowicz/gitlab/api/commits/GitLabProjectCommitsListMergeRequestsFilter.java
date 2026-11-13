package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryCommitsShaMergeRequests}, without
 * paging.
 *
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCommitsShaMergeRequests/parameters")
public record GitLabProjectCommitsListMergeRequestsFilter(
        @Nullable String state) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectCommitsListMergeRequestsFilter empty() {
        return GitLabProjectCommitsListMergeRequestsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("state", state).build();
    }
}
