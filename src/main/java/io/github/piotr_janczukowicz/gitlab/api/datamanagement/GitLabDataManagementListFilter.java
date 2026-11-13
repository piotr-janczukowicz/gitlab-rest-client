package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AdminDataManagementModelName}, without paging.
 *
 * @param identifiers the identifiers
 * @param checksumState the checksum state
 * @param cursor the cursor
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AdminDataManagementModelName/parameters")
public record GitLabDataManagementListFilter(
        @Nullable List<String> identifiers,
        @Nullable GitLabDataManagementListChecksumState checksumState,
        @Nullable String cursor,
        @Nullable GitLabDataManagementListSort sort) {
    public GitLabDataManagementListFilter {
        if (identifiers != null) {
            identifiers = List.copyOf(identifiers);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDataManagementListFilter empty() {
        return GitLabDataManagementListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .list("identifiers", identifiers)
                .wire("checksum_state", checksumState, GitLabDataManagementListChecksumState::wireValue)
                .text("cursor", cursor)
                .wire("sort", sort, GitLabDataManagementListSort::wireValue)
                .build();
    }
}
