package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4ProjectsIdFeatureFlagsSettings}.
 *
 * @param minimumRole the minimum role
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdFeatureFlagsSettings/requestBody")
public record GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload(
        GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole minimumRole) {
    public GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload {
        requireNonNull(minimumRole, "minimumRole");
    }
}
