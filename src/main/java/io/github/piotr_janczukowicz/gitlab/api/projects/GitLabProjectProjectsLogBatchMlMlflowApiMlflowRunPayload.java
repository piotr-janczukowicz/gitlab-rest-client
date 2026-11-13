package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogBatch}.
 *
 * @param runId the run id
 * @param metrics the metrics
 * @param params the params
 * @param tags the tags
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogBatch/requestBody")
public record GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload(
        @Nullable String runId,
        @Nullable List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric> metrics,
        @Nullable List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam> params,
        @Nullable List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag> tags) {
    public GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload {
        if (metrics != null) {
            metrics = List.copyOf(metrics);
        }
        if (params != null) {
            params = List.copyOf(params);
        }
        if (tags != null) {
            tags = List.copyOf(tags);
        }
    }
}
