package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRunners}, without paging.
 *
 * @param scope the scope
 * @param type the type
 * @param paused the paused
 * @param status the status
 * @param tagList the tag list
 * @param versionPrefix the version prefix
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRunners/parameters")
public record GitLabProjectRunnersListFilter(
        @Nullable GitLabProjectRunnersListScope scope,
        @Nullable GitLabProjectRunnersListType type,
        @Nullable Boolean paused,
        @Nullable GitLabProjectRunnersListStatus status,
        @Nullable List<String> tagList,
        @Nullable String versionPrefix) {
    public GitLabProjectRunnersListFilter {
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRunnersListFilter empty() {
        return GitLabProjectRunnersListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabProjectRunnersListScope::wireValue)
                .wire("type", type, GitLabProjectRunnersListType::wireValue)
                .value("paused", paused)
                .wire("status", status, GitLabProjectRunnersListStatus::wireValue)
                .list("tag_list", tagList)
                .text("version_prefix", versionPrefix)
                .build();
    }
}
