package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4BulkImports}, without paging.
 *
 * @param sort the sort
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4BulkImports/parameters")
public record GitLabGroupAndProjectMigrationByDirectTransferListFilter(
        @Nullable GitLabGroupAndProjectMigrationByDirectTransferListSort sort,
        @Nullable GitLabGroupAndProjectMigrationByDirectTransferListStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupAndProjectMigrationByDirectTransferListFilter empty() {
        return GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("sort", sort, GitLabGroupAndProjectMigrationByDirectTransferListSort::wireValue)
                .wire("status", status, GitLabGroupAndProjectMigrationByDirectTransferListStatus::wireValue)
                .build();
    }
}
