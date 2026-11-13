package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogMetric}.
 *
 * @param runId the run id
 * @param key the key
 * @param value the value
 * @param timestamp the timestamp
 * @param step the step
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogMetric/requestBody")
public record GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload(
        @Nullable String runId,
        @Nullable String key,
        @Nullable Double value,
        @Nullable Integer timestamp,
        @Nullable Integer step) {}
