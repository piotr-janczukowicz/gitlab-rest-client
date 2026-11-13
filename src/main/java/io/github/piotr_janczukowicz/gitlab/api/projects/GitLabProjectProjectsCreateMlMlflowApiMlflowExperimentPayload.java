package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowExperimentsCreate}.
 *
 * @param name the name
 * @param tags the tags
 * @param artifactLocation the artifact location
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowExperimentsCreate/requestBody")
public record GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload(
        @Nullable String name,
        @Nullable List<Map<String, Object>> tags,
        @Nullable String artifactLocation) {
    public GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload {
        if (tags != null) {
            tags = List.copyOf(tags);
        }
    }
}
