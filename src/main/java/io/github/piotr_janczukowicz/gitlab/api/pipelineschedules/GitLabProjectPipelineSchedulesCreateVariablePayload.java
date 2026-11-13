package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdVariables}.
 *
 * @param key the key
 * @param value the value
 * @param variableType the variable type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdVariables/requestBody")
public record GitLabProjectPipelineSchedulesCreateVariablePayload(
        @Nullable String key,
        @Nullable String value,
        @Nullable GitLabProjectPipelineSchedulesCreateVariableType variableType) {}
