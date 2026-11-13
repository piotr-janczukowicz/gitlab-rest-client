package io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdSecuritySettings}.
 *
 * @param secretPushProtectionEnabled the secret push protection enabled
 * @param preReceiveSecretDetectionEnabled the pre receive secret detection enabled
 * @param fastDependencyPathsEnabled the fast dependency paths enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdSecuritySettings/requestBody")
public record GitLabProjectProjectSecuritySettingsUpdatePayload(
        @Nullable Boolean secretPushProtectionEnabled,
        @Nullable Boolean preReceiveSecretDetectionEnabled,
        @Nullable Boolean fastDependencyPathsEnabled) {}
