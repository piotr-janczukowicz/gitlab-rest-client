package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deployment.
 *
 * @param id the id
 * @param iid the iid
 * @param ref the ref
 * @param sha the sha
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param user the user
 * @param environment the environment
 * @param deployable the deployable
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeployment")
public record GitLabDeployment(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String ref,
        @Nullable String sha,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable GitLabUserBasic user,
        @Nullable GitLabEnvironmentBasic environment,
        @Nullable GitLabCiJob deployable,
        @Nullable String status) {}
