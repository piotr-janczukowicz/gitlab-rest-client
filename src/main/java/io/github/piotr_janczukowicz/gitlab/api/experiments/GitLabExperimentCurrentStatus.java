package io.github.piotr_janczukowicz.gitlab.api.experiments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureGate;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab experiment current status.
 *
 * @param state the state
 * @param gates the gates
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesExperimentCurrentStatus")
public record GitLabExperimentCurrentStatus(
        @Nullable String state, @Nullable GitLabFeatureGate gates) {}
