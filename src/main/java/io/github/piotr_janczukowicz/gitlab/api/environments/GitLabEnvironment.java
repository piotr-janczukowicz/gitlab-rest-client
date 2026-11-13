package io.github.piotr_janczukowicz.gitlab.api.environments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabClusterAgent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployment;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab environment.
 *
 * @param id the id
 * @param name the name
 * @param slug the slug
 * @param externalUrl the external url
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param tier the tier
 * @param project the project
 * @param lastDeployment the last deployment
 * @param state the state
 * @param autoStopAt the auto stop at
 * @param clusterAgent the cluster agent
 * @param kubernetesNamespace the kubernetes namespace
 * @param fluxResourcePath the flux resource path
 * @param description the description
 * @param autoStopSetting the auto stop setting
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEnvironment")
public record GitLabEnvironment(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String slug,
        @Nullable String externalUrl,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String tier,
        @Nullable GitLabBasicProjectDetails project,
        @Nullable GitLabDeployment lastDeployment,
        @Nullable String state,
        @Nullable Instant autoStopAt,
        @Nullable GitLabClusterAgent clusterAgent,
        @Nullable String kubernetesNamespace,
        @Nullable String fluxResourcePath,
        @Nullable String description,
        @Nullable String autoStopSetting) {}
