package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Snippets}, without paging.
 *
 * @param createdAfter the created after
 * @param createdBefore the created before
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Snippets/parameters")
public record GitLabCodeSnippetsListFilter(
        @Nullable Instant createdAfter, @Nullable Instant createdBefore) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabCodeSnippetsListFilter empty() {
        return GitLabCodeSnippetsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .build();
    }
}
