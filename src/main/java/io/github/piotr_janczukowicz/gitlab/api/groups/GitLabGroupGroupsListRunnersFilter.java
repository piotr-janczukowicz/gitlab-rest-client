package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdRunners}, without paging.
 *
 * @param type the type
 * @param paused the paused
 * @param status the status
 * @param tagList the tag list
 * @param versionPrefix the version prefix
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdRunners/parameters")
public record GitLabGroupGroupsListRunnersFilter(
        @Nullable GitLabGroupGroupsListRunnersType type,
        @Nullable Boolean paused,
        @Nullable GitLabGroupGroupsListRunnersStatus status,
        @Nullable List<String> tagList,
        @Nullable String versionPrefix) {
    public GitLabGroupGroupsListRunnersFilter {
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListRunnersFilter empty() {
        return GitLabGroupGroupsListRunnersFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("type", type, GitLabGroupGroupsListRunnersType::wireValue)
                .value("paused", paused)
                .wire("status", status, GitLabGroupGroupsListRunnersStatus::wireValue)
                .list("tag_list", tagList)
                .text("version_prefix", versionPrefix)
                .build();
    }
}
