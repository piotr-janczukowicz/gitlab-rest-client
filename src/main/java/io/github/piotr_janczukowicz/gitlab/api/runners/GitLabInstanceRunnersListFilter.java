package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Runners}, without paging.
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
@CatalogSchema("operations/getApiV4Runners/parameters")
public record GitLabInstanceRunnersListFilter(
        @Nullable GitLabInstanceRunnersListScope scope,
        @Nullable GitLabInstanceRunnersListType type,
        @Nullable Boolean paused,
        @Nullable GitLabInstanceRunnersListStatus status,
        @Nullable List<String> tagList,
        @Nullable String versionPrefix) {
    public GitLabInstanceRunnersListFilter {
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceRunnersListFilter empty() {
        return GitLabInstanceRunnersListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabInstanceRunnersListScope::wireValue)
                .wire("type", type, GitLabInstanceRunnersListType::wireValue)
                .value("paused", paused)
                .wire("status", status, GitLabInstanceRunnersListStatus::wireValue)
                .list("tag_list", tagList)
                .text("version_prefix", versionPrefix)
                .build();
    }
}
