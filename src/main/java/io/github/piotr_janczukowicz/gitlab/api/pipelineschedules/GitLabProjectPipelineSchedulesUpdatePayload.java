package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPipelineSchedulesPipelineScheduleId}.
 *
 * @param description the description
 * @param ref the ref
 * @param cron the cron
 * @param cronTimezone the cron timezone
 * @param active the active
 * @param inputs the inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPipelineSchedulesPipelineScheduleId/requestBody")
public record GitLabProjectPipelineSchedulesUpdatePayload(
        @Nullable String description,
        @Nullable String ref,
        @Nullable String cron,
        @Nullable String cronTimezone,
        @Nullable Boolean active,
        @Nullable List<GitLabProjectPipelineSchedulesUpdateInput> inputs) {
    public GitLabProjectPipelineSchedulesUpdatePayload {
        if (inputs != null) {
            inputs = List.copyOf(inputs);
        }
    }
}
