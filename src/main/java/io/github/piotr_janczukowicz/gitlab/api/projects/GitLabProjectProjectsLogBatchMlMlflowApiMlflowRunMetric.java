package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project projects log batch ml mlflow api mlflow run metric of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 * @param timestamp the timestamp
 * @param step the step
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogBatch/requestBody/properties/metrics/items")
public record GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric(
        @Nullable String key,
        @Nullable Double value,
        @Nullable Integer timestamp,
        @Nullable Integer step) {}
