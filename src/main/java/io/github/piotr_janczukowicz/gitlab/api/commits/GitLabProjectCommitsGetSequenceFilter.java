package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryCommitsShaSequence}, without paging.
 *
 * @param firstParent the first parent
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCommitsShaSequence/parameters")
public record GitLabProjectCommitsGetSequenceFilter(
        @Nullable Boolean firstParent) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectCommitsGetSequenceFilter empty() {
        return GitLabProjectCommitsGetSequenceFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("first_parent", firstParent)
                .build();
    }
}
