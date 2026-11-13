package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesGooglePlay}.
 *
 * @param packageName the package name
 * @param serviceAccountKeyFileName the service account key file name
 * @param serviceAccountKey the service account key
 * @param googlePlayProtectedRefs the google play protected refs
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesGooglePlay/requestBody")
public record GitLabProjectIntegrationsGooglePlayServicePayload(
        @Nullable String packageName,
        @Nullable String serviceAccountKeyFileName,
        @Nullable String serviceAccountKey,
        @Nullable Boolean googlePlayProtectedRefs,
        @Nullable Boolean useInheritedSettings) {}
