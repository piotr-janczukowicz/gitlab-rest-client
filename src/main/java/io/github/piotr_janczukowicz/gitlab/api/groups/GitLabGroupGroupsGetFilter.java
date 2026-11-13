package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsId}, without paging.
 *
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 * @param withProjects the with projects
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsId/parameters")
public record GitLabGroupGroupsGetFilter(
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes,

        @Nullable Boolean withProjects) {
    public GitLabGroupGroupsGetFilter {
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsGetFilter empty() {
        return GitLabGroupGroupsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .value("with_projects", withProjects)
                .build();
    }
}
