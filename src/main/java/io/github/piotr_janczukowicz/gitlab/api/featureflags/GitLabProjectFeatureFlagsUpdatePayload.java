package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdFeatureFlagsFeatureFlagName}.
 *
 * @param name the name
 * @param description the description
 * @param active the active
 * @param strategies the strategies
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdFeatureFlagsFeatureFlagName/requestBody")
public record GitLabProjectFeatureFlagsUpdatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean active,
        @Nullable List<GitLabProjectFeatureFlagsUpdateStrategy> strategies) {
    public GitLabProjectFeatureFlagsUpdatePayload {
        if (strategies != null) {
            strategies = List.copyOf(strategies);
        }
    }
}
