package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdInvitedGroups}, without paging.
 *
 * @param relation the relation
 * @param search the search
 * @param minAccessLevel the min access level
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdInvitedGroups/parameters")
public record GitLabProjectProjectsListInvitedGroupsFilter(
        @Nullable List<GitLabProjectProjectsListInvitedGroupsRelation> relation,
        @Nullable String search,
        @Nullable GitLabProjectProjectsListInvitedGroupsMinAccessLevel minAccessLevel,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes) {
    public GitLabProjectProjectsListInvitedGroupsFilter {
        if (relation != null) {
            relation = List.copyOf(relation);
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
    public static GitLabProjectProjectsListInvitedGroupsFilter empty() {
        return GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wireList("relation", relation, GitLabProjectProjectsListInvitedGroupsRelation::wireValue)
                .text("search", search)
                .wire(
                        "min_access_level",
                        minAccessLevel,
                        GitLabProjectProjectsListInvitedGroupsMinAccessLevel::wireValue)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .build();
    }
}
