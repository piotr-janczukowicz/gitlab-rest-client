package io.github.piotr_janczukowicz.gitlab.api.organizations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4OrganizationsIdUsers}, without paging.
 *
 * @param cursor the cursor
 * @param orderBy the order by
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4OrganizationsIdUsers/parameters")
public record GitLabOrganizationsListUsersFilter(
        @Nullable String cursor,
        @Nullable GitLabOrganizationsListUsersOrderBy orderBy,
        @Nullable GitLabOrganizationsListUsersSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabOrganizationsListUsersFilter empty() {
        return GitLabOrganizationsListUsersFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("cursor", cursor)
                .wire("order_by", orderBy, GitLabOrganizationsListUsersOrderBy::wireValue)
                .wire("sort", sort, GitLabOrganizationsListUsersSort::wireValue)
                .build();
    }
}
