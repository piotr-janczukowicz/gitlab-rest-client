package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdGroups}, without paging.
 *
 * @param search the search
 * @param skipGroups the skip groups
 * @param withShared the with shared
 * @param sharedVisibleOnly the shared visible only
 * @param sharedMinAccessLevel the shared min access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdGroups/parameters")
public record GitLabProjectProjectsListGroupsFilter(
        @Nullable String search,
        @Nullable List<Integer> skipGroups,
        @Nullable Boolean withShared,
        @Nullable Boolean sharedVisibleOnly,
        @Nullable GitLabProjectProjectsListGroupsSharedMinAccessLevel sharedMinAccessLevel) {
    public GitLabProjectProjectsListGroupsFilter {
        if (skipGroups != null) {
            skipGroups = List.copyOf(skipGroups);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsListGroupsFilter empty() {
        return GitLabProjectProjectsListGroupsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("search", search)
                .list("skip_groups", skipGroups)
                .value("with_shared", withShared)
                .value("shared_visible_only", sharedVisibleOnly)
                .wire(
                        "shared_min_access_level",
                        sharedMinAccessLevel,
                        GitLabProjectProjectsListGroupsSharedMinAccessLevel::wireValue)
                .build();
    }
}
