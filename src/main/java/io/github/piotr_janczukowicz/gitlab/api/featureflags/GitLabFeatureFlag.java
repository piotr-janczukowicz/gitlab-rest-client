package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature flag.
 *
 * @param name the name
 * @param description the description
 * @param active the active
 * @param version the version
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param strategies the strategies
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeatureFlag")
public record GitLabFeatureFlag(
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean active,
        @Nullable String version,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable List<GitLabFeatureFlagStrategy> strategies) {}
