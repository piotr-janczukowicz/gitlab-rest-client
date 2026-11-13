package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow experiment.
 *
 * @param experimentId the experiment id
 * @param name the name
 * @param lifecycleStage the lifecycle stage
 * @param artifactLocation the artifact location
 * @param tags the tags
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowExperiment")
public record GitLabMlMlflowExperiment(
        @Nullable String experimentId,
        @Nullable String name,
        @Nullable String lifecycleStage,
        @Nullable String artifactLocation,
        @Nullable List<GitLabMlMlflowKeyValue> tags) {}
