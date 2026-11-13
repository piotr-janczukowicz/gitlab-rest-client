package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab orbit skill collection.
 *
 * @param skills the skills
 * @param serverVersion the server version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrbitSkillCollection")
public record GitLabOrbitSkillCollection(
        @Nullable List<GitLabOrbitSkillSummary> skills,
        @Nullable String serverVersion) {}
