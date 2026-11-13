package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature definition.
 *
 * @param name the name
 * @param featureIssueUrl the feature issue url
 * @param introducedByUrl the introduced by url
 * @param rolloutIssueUrl the rollout issue url
 * @param milestone the milestone
 * @param logStateChanges the log state changes
 * @param type the type
 * @param group the group
 * @param defaultEnabled the default enabled
 * @param intendedToRolloutBy the intended to rollout by
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeatureDefinition")
public record GitLabFeatureDefinition(
        @Nullable String name,
        @Nullable String featureIssueUrl,
        @Nullable String introducedByUrl,
        @Nullable String rolloutIssueUrl,
        @Nullable String milestone,
        @Nullable Boolean logStateChanges,
        @Nullable String type,
        @Nullable String group,
        @Nullable Boolean defaultEnabled,
        @Nullable String intendedToRolloutBy) {}
