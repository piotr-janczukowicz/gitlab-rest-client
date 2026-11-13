package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4SnippetsAll}, without paging.
 *
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param repositoryStorage the repository storage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4SnippetsAll/parameters")
public record GitLabCodeSnippetsListAllFilter(
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable String repositoryStorage) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabCodeSnippetsListAllFilter empty() {
        return GitLabCodeSnippetsListAllFilterBuilder.builder().build();
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
                .text("repository_storage", repositoryStorage)
                .build();
    }
}
