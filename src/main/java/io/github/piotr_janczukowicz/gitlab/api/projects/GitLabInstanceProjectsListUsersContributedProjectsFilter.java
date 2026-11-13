package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4UsersUserIdContributedProjects}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param simple the simple
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4UsersUserIdContributedProjects/parameters")
public record GitLabInstanceProjectsListUsersContributedProjectsFilter(
        @Nullable GitLabInstanceProjectsListUsersContributedProjectsOrderBy orderBy,
        @Nullable GitLabInstanceProjectsListUsersContributedProjectsSort sort,
        @Nullable Boolean simple) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceProjectsListUsersContributedProjectsFilter empty() {
        return GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabInstanceProjectsListUsersContributedProjectsOrderBy::wireValue)
                .wire("sort", sort, GitLabInstanceProjectsListUsersContributedProjectsSort::wireValue)
                .value("simple", simple)
                .build();
    }
}
