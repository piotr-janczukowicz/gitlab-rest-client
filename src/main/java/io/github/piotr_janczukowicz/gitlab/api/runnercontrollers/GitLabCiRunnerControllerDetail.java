package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner controller detail.
 *
 * @param id the id
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param connected the connected
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerControllerDetail")
public record GitLabCiRunnerControllerDetail(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Boolean connected) {}
