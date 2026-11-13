package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryDivergingCommits}, without paging.
 *
 * @param maxCount the max count
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryDivergingCommits/parameters")
public record GitLabProjectRepositoriesGetDivergingCommitsFilter(
        @Nullable Integer maxCount) {
    public GitLabProjectRepositoriesGetDivergingCommitsFilter {
        requireAtLeastIfPresent(maxCount, 0, "maxCount");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesGetDivergingCommitsFilter empty() {
        return GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("max_count", maxCount).build();
    }
}
