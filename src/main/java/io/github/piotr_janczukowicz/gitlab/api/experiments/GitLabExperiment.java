package io.github.piotr_janczukowicz.gitlab.api.experiments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureDefinition;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab experiment.
 *
 * @param key the key
 * @param context the context
 * @param definition the definition
 * @param currentStatus the current status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesExperiment")
public record GitLabExperiment(
        @Nullable String key,
        @Nullable List<String> context,
        @Nullable GitLabFeatureDefinition definition,
        @Nullable GitLabExperimentCurrentStatus currentStatus) {}
