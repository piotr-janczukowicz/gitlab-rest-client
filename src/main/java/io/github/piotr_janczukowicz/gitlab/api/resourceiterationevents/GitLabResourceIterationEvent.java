package io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIteration;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource iteration event.
 *
 * @param id the id
 * @param user the user
 * @param createdAt the created at
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param iteration the iteration
 * @param action the action
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceIterationEvent")
public record GitLabResourceIterationEvent(
        @Nullable Long id,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable String resourceType,
        @Nullable Long resourceId,
        @Nullable GitLabIteration iteration,
        @Nullable String action) {}
