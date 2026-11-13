package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow run.
 *
 * @param info the info
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowRun")
public record GitLabMlMlflowRun(
        @Nullable GitLabMlMlflowRunInfo info, @Nullable GitLabMlMlflowRunData data) {}
