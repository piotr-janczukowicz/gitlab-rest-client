package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPipelinesPipelineIdMetadata}.
 *
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPipelinesPipelineIdMetadata/requestBody")
public record GitLabProjectPipelinesMetadataPayload(
        @Nullable String name) {}
