package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdManageSshKeys}, without paging.
 *
 * @param createdBefore the created before
 * @param createdAfter the created after
 * @param expiresBefore the expires before
 * @param expiresAfter the expires after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdManageSshKeys/parameters")
public record GitLabGroupGroupsListManageSshKeysFilter(
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter,
        @Nullable Instant expiresBefore,
        @Nullable Instant expiresAfter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListManageSshKeysFilter empty() {
        return GitLabGroupGroupsListManageSshKeysFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .value("expires_before", expiresBefore)
                .value("expires_after", expiresAfter)
                .build();
    }
}
