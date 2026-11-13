package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Groups}, without paging.
 *
 * @param statistics the statistics
 * @param archived the archived
 * @param skipGroups the skip groups
 * @param allAvailable the all available
 * @param visibility the visibility
 * @param search the search
 * @param owned the owned
 * @param minAccessLevel the min access level
 * @param topLevelOnly the top level only
 * @param markedForDeletionOn the marked for deletion on
 * @param active the active
 * @param repositoryStorage the repository storage
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Groups/parameters")
public record GitLabGroupGroupsListFilter(
        @Nullable Boolean statistics,
        @Nullable Boolean archived,
        @Nullable List<Integer> skipGroups,
        @Nullable Boolean allAvailable,
        @Nullable GitLabGroupGroupsListVisibility visibility,
        @Nullable String search,
        @Nullable Boolean owned,
        @Nullable GitLabGroupGroupsListMinAccessLevel minAccessLevel,
        @Nullable Boolean topLevelOnly,
        @Nullable LocalDate markedForDeletionOn,
        @Nullable Boolean active,
        @Nullable String repositoryStorage,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes) {
    public GitLabGroupGroupsListFilter {
        if (skipGroups != null) {
            skipGroups = List.copyOf(skipGroups);
        }
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsListFilter empty() {
        return GitLabGroupGroupsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("statistics", statistics)
                .value("archived", archived)
                .list("skip_groups", skipGroups)
                .value("all_available", allAvailable)
                .wire("visibility", visibility, GitLabGroupGroupsListVisibility::wireValue)
                .text("search", search)
                .value("owned", owned)
                .wire("min_access_level", minAccessLevel, GitLabGroupGroupsListMinAccessLevel::wireValue)
                .value("top_level_only", topLevelOnly)
                .value("marked_for_deletion_on", markedForDeletionOn)
                .value("active", active)
                .text("repository_storage", repositoryStorage)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .build();
    }
}
