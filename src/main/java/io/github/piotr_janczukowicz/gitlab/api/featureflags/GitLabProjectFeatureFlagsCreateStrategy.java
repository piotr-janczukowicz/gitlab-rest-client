package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project feature flags create strategy of a GitLab resource.
 *
 * @param name the name
 * @param parameters the parameters
 * @param userListId the user list id
 * @param scopes the scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdFeatureFlags/requestBody/properties/strategies/items")
public record GitLabProjectFeatureFlagsCreateStrategy(
        @Nullable String name,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> parameters,

        @Nullable Long userListId,
        @Nullable List<GitLabProjectFeatureFlagsCreateStrategyScope> scopes) {
    public GitLabProjectFeatureFlagsCreateStrategy {
        if (parameters != null) {
            parameters = Map.copyOf(parameters);
        }
        if (scopes != null) {
            scopes = List.copyOf(scopes);
        }
    }
}
