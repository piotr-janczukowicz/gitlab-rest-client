package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdClustersClusterId}.
 *
 * @param name the name
 * @param domain the domain
 * @param environmentScope the environment scope
 * @param namespacePerEnvironment the namespace per environment
 * @param managementProjectId the management project id
 * @param enabled the enabled
 * @param managed the managed
 * @param platformKubernetesAttributes the platform kubernetes attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdClustersClusterId/requestBody")
public record GitLabProjectProjectClustersUpdatePayload(
        @Nullable String name,
        @Nullable String domain,
        @Nullable String environmentScope,
        @Nullable Boolean namespacePerEnvironment,
        @Nullable Long managementProjectId,
        @Nullable Boolean enabled,
        @Nullable Boolean managed,
        @Nullable GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes platformKubernetesAttributes) {}
