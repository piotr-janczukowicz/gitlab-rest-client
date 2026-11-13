package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdTriggers}.
 *
 * @param description the description
 * @param expiresAt the expires at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdTriggers/requestBody")
public record GitLabProjectPipelineTriggersCreatePayload(
        @Nullable String description, @Nullable Instant expiresAt) {}
