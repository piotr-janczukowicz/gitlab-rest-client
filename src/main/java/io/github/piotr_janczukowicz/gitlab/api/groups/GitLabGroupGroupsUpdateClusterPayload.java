package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdClustersClusterId}.
 *
 * @param name the name
 * @param enabled the enabled
 * @param domain the domain
 * @param environmentScope the environment scope
 * @param namespacePerEnvironment the namespace per environment
 * @param managementProjectId the management project id
 * @param managed the managed
 * @param platformKubernetesAttributes the platform kubernetes attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdClustersClusterId/requestBody")
public record GitLabGroupGroupsUpdateClusterPayload(
        @Nullable String name,
        @Nullable Boolean enabled,
        @Nullable String domain,
        @Nullable String environmentScope,
        @Nullable Boolean namespacePerEnvironment,
        @Nullable Long managementProjectId,
        @Nullable Boolean managed,
        @Nullable GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes platformKubernetesAttributes) {}
