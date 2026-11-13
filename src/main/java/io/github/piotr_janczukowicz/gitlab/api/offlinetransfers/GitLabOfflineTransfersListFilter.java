package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4OfflineExports}, without paging.
 *
 * @param sort the sort
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4OfflineExports/parameters")
public record GitLabOfflineTransfersListFilter(
        @Nullable GitLabOfflineTransfersListSort sort,
        @Nullable GitLabOfflineTransfersListStatus status) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabOfflineTransfersListFilter empty() {
        return GitLabOfflineTransfersListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("sort", sort, GitLabOfflineTransfersListSort::wireValue)
                .wire("status", status, GitLabOfflineTransfersListStatus::wireValue)
                .build();
    }
}
