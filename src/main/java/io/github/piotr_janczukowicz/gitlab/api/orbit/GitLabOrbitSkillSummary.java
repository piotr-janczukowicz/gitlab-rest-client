package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab orbit skill summary.
 *
 * @param name the name
 * @param version the version
 * @param compatibility the compatibility
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrbitSkillSummary")
public record GitLabOrbitSkillSummary(
        @Nullable String name,
        @Nullable String version,
        @Nullable String compatibility,
        @Nullable String description) {}
