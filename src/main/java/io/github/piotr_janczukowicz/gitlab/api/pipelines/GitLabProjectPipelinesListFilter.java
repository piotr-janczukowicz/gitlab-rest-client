package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Pipelines}, without paging.
 *
 * @param source the source
 * @param createdBefore the created before
 * @param createdAfter the created after
 * @param orderBy the order by
 * @param sort the sort
 * @param cursor the cursor
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Pipelines/parameters")
public record GitLabProjectPipelinesListFilter(
        @Nullable GitLabProjectPipelinesListSource source,
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter,
        @Nullable GitLabProjectPipelinesListOrderBy orderBy,
        @Nullable GitLabProjectPipelinesListSort sort,
        @Nullable String cursor) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPipelinesListFilter empty() {
        return GitLabProjectPipelinesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("source", source, GitLabProjectPipelinesListSource::wireValue)
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .wire("order_by", orderBy, GitLabProjectPipelinesListOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectPipelinesListSort::wireValue)
                .text("cursor", cursor)
                .build();
    }
}
