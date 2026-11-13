package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project projects log batch ml mlflow api mlflow run tag of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsLogBatch/requestBody/properties/tags/items")
public record GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag(
        @Nullable String key, @Nullable String value) {}
