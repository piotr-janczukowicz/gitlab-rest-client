package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project pipeline schedules update input of a GitLab resource.
 *
 * @param name the name
 * @param destroy the destroy
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPipelineSchedulesPipelineScheduleId/requestBody/properties/inputs/items")
public record GitLabProjectPipelineSchedulesUpdateInput(
        @Nullable String name,
        @Nullable Boolean destroy,
        @Nullable List<String> value) {
    public GitLabProjectPipelineSchedulesUpdateInput {
        if (value != null) {
            value = List.copyOf(value);
        }
    }
}
