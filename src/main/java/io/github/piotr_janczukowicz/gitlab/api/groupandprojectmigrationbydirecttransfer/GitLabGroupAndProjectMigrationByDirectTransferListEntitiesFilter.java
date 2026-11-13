package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4BulkImportsEntities}, without paging.
 *
 * @param sort the sort
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4BulkImportsEntities/parameters")
public record GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter(
        @Nullable GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort sort,
        @Nullable GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter empty() {
        return GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("sort", sort, GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort::wireValue)
                .wire("status", status, GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus::wireValue)
                .build();
    }
}
