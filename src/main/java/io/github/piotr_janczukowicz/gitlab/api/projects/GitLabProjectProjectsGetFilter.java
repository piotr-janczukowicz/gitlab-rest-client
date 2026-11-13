package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsId}, without paging.
 *
 * @param statistics the statistics
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 * @param license the license
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsId/parameters")
public record GitLabProjectProjectsGetFilter(
        @Nullable Boolean statistics,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes,

        @Nullable Boolean license) {
    public GitLabProjectProjectsGetFilter {
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsGetFilter empty() {
        return GitLabProjectProjectsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("statistics", statistics)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .value("license", license)
                .build();
    }
}
