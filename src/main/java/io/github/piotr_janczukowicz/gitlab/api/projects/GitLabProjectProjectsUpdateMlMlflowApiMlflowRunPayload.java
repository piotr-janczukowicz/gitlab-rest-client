package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRunsUpdate}.
 *
 * @param runId the run id
 * @param status the status
 * @param endTime the end time
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsUpdate/requestBody")
public record GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload(
        @Nullable String runId,
        @Nullable GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus status,
        @Nullable Integer endTime) {}
