package io.github.piotr_janczukowicz.gitlab.api.environments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdEnvironmentsEnvironmentId}.
 *
 * @param externalUrl the external url
 * @param tier the tier
 * @param clusterAgentId the cluster agent id
 * @param kubernetesNamespace the kubernetes namespace
 * @param fluxResourcePath the flux resource path
 * @param description the description
 * @param autoStopSetting the auto stop setting
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdEnvironmentsEnvironmentId/requestBody")
public record GitLabProjectEnvironmentsUpdatePayload(
        @Nullable String externalUrl,
        @Nullable GitLabProjectEnvironmentsUpdateTier tier,
        @Nullable Long clusterAgentId,
        @Nullable String kubernetesNamespace,
        @Nullable String fluxResourcePath,
        @Nullable String description,
        @Nullable GitLabProjectEnvironmentsUpdateAutoStopSetting autoStopSetting) {}
