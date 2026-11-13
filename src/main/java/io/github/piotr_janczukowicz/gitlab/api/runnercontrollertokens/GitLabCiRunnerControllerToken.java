package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner controller token.
 *
 * @param id the id
 * @param runnerControllerId the runner controller id
 * @param description the description
 * @param lastUsedAt the last used at
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerControllerToken")
public record GitLabCiRunnerControllerToken(
        @Nullable Long id,
        @Nullable Long runnerControllerId,
        @Nullable String description,
        @Nullable Instant lastUsedAt,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
