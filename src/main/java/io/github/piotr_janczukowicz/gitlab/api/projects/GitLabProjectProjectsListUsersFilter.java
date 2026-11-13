package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdUsers}, without paging.
 *
 * @param search the search
 * @param skipUsers the skip users
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdUsers/parameters")
public record GitLabProjectProjectsListUsersFilter(
        @Nullable String search, @Nullable List<Integer> skipUsers) {
    public GitLabProjectProjectsListUsersFilter {
        if (skipUsers != null) {
            skipUsers = List.copyOf(skipUsers);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsListUsersFilter empty() {
        return GitLabProjectProjectsListUsersFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("search", search)
                .list("skip_users", skipUsers)
                .build();
    }
}
