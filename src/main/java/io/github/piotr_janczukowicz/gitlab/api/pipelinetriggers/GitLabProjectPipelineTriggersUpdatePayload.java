package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdTriggersTriggerId}.
 *
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdTriggersTriggerId/requestBody")
public record GitLabProjectPipelineTriggersUpdatePayload(
        @Nullable String description) {}
