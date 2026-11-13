package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab ml mlflow run data of a GitLab resource.
 *
 * @param metrics the metrics
 * @param params the params
 * @param tags the tags
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowRun/properties/data")
public record GitLabMlMlflowRunData(
        @Nullable List<GitLabMlMlflowMetric> metrics,
        @Nullable List<GitLabMlMlflowKeyValue> params,
        @Nullable List<GitLabMlMlflowKeyValue> tags) {}
