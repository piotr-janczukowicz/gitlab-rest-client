package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPlatformKubernetes;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectIdentity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProviderGcp;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cluster group.
 *
 * @param id the id
 * @param name the name
 * @param createdAt the created at
 * @param domain the domain
 * @param enabled the enabled
 * @param managed the managed
 * @param providerType the provider type
 * @param platformType the platform type
 * @param environmentScope the environment scope
 * @param clusterType the cluster type
 * @param namespacePerEnvironment the namespace per environment
 * @param user the user
 * @param platformKubernetes the platform kubernetes
 * @param providerGcp the provider gcp
 * @param managementProject the management project
 * @param group the group
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesClusterGroup")
public record GitLabClusterGroup(
        @Nullable String id,
        @Nullable String name,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String domain,
        @Nullable String enabled,
        @Nullable String managed,
        @Nullable String providerType,
        @Nullable String platformType,
        @Nullable String environmentScope,
        @Nullable String clusterType,
        @Nullable String namespacePerEnvironment,
        @Nullable GitLabUserBasic user,
        @Nullable GitLabPlatformKubernetes platformKubernetes,
        @Nullable GitLabProviderGcp providerGcp,
        @Nullable GitLabProjectIdentity managementProject,
        @Nullable GitLabBasicGroupDetails group) {}
