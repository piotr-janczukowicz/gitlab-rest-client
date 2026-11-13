package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRunsCreate}.
 *
 * @param experimentId the experiment id
 * @param startTime the start time
 * @param userId the user id
 * @param tags the tags
 * @param runName the run name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsCreate/requestBody")
public record GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload(
        @Nullable Long experimentId,
        @Nullable Integer startTime,
        @Nullable String userId,
        @Nullable List<Map<String, Object>> tags,
        @Nullable String runName) {
    public GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload {
        if (tags != null) {
            tags = List.copyOf(tags);
        }
    }
}
