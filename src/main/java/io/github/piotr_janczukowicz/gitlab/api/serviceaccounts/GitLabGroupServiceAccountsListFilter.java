package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdServiceAccounts}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdServiceAccounts/parameters")
public record GitLabGroupServiceAccountsListFilter(
        @Nullable GitLabGroupServiceAccountsListOrderBy orderBy,
        @Nullable GitLabGroupServiceAccountsListSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupServiceAccountsListFilter empty() {
        return GitLabGroupServiceAccountsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabGroupServiceAccountsListOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupServiceAccountsListSort::wireValue)
                .build();
    }
}
