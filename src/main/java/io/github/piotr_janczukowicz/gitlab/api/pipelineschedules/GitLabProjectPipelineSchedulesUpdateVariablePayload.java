package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdVariablesKey}.
 *
 * @param value the value
 * @param variableType the variable type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdVariablesKey/requestBody")
public record GitLabProjectPipelineSchedulesUpdateVariablePayload(
        @Nullable String value, @Nullable GitLabProjectPipelineSchedulesUpdateVariableType variableType) {}
