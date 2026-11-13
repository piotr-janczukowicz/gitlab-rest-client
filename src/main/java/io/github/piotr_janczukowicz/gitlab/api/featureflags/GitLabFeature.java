package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureDefinition;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureGate;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature.
 *
 * @param name the name
 * @param state the state
 * @param gates the gates
 * @param definition the definition
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeature")
public record GitLabFeature(
        @Nullable String name,
        @Nullable String state,
        @Nullable List<GitLabFeatureGate> gates,
        @Nullable GitLabFeatureDefinition definition) {}
