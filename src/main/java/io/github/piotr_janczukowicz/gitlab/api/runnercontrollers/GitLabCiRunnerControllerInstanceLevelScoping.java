package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner controller instance level scoping.
 *
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerControllerInstanceLevelScoping")
public record GitLabCiRunnerControllerInstanceLevelScoping(
        @Nullable Instant createdAt, @Nullable Instant updatedAt) {}
