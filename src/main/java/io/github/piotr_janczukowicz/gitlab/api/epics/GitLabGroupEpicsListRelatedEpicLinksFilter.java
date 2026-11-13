package io.github.piotr_janczukowicz.gitlab.api.epics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdRelatedEpicLinks}, without paging.
 *
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 * @param createdBefore the created before
 * @param createdAfter the created after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdRelatedEpicLinks/parameters")
public record GitLabGroupEpicsListRelatedEpicLinksFilter(
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupEpicsListRelatedEpicLinksFilter empty() {
        return GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .build();
    }
}
