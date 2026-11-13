package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner controller runner level scoping.
 *
 * @param runnerId the runner id
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerControllerRunnerLevelScoping")
public record GitLabCiRunnerControllerRunnerLevelScoping(
        @Nullable Long runnerId,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
