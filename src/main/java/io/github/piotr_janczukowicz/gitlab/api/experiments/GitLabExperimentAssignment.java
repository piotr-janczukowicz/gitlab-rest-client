package io.github.piotr_janczukowicz.gitlab.api.experiments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab experiment assignment.
 *
 * @param experiment the experiment
 * @param variant the variant
 * @param contextKey the context key
 * @param cached the cached
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesExperimentsAssignment")
public record GitLabExperimentAssignment(
        @Nullable String experiment,
        @Nullable String variant,
        @Nullable String contextKey,
        @Nullable Boolean cached) {}
