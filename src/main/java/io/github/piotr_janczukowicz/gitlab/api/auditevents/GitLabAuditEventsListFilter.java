package io.github.piotr_janczukowicz.gitlab.api.auditevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AuditEvents}, without paging.
 *
 * @param entityId the entity id
 * @param createdAfter the created after
 * @param createdBefore the created before
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AuditEvents/parameters")
public record GitLabAuditEventsListFilter(
        @Nullable Long entityId,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabAuditEventsListFilter empty() {
        return GitLabAuditEventsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("entity_id", entityId)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .build();
    }
}
