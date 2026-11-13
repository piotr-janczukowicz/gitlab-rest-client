package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsGoogleCloudPlatformArtifactRegistry}.
 *
 * @param artifactRegistryProjectId the artifact registry project id
 * @param artifactRegistryRepositories the artifact registry repositories
 * @param artifactRegistryLocation the artifact registry location
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsGoogleCloudPlatformArtifactRegistry/requestBody")
public record GitLabProjectGoogleCloudArtifactRegistryPayload(
        @Nullable String artifactRegistryProjectId,
        @Nullable String artifactRegistryRepositories,
        @Nullable String artifactRegistryLocation,
        @Nullable Boolean useInheritedSettings) {}
