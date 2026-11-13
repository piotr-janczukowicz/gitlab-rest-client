package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdFeatureFlags}.
 *
 * @param name the name
 * @param description the description
 * @param active the active
 * @param strategies the strategies
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdFeatureFlags/requestBody")
public record GitLabProjectFeatureFlagsCreatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean active,
        @Nullable List<GitLabProjectFeatureFlagsCreateStrategy> strategies) {
    public GitLabProjectFeatureFlagsCreatePayload {
        if (strategies != null) {
            strategies = List.copyOf(strategies);
        }
    }
}
