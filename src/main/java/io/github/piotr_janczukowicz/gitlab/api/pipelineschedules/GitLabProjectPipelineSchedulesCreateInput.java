package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project pipeline schedules create input of a GitLab resource.
 *
 * @param name the name
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPipelineSchedules/requestBody/properties/inputs/items")
public record GitLabProjectPipelineSchedulesCreateInput(
        @Nullable String name, @Nullable List<String> value) {
    public GitLabProjectPipelineSchedulesCreateInput {
        if (value != null) {
            value = List.copyOf(value);
        }
    }
}
