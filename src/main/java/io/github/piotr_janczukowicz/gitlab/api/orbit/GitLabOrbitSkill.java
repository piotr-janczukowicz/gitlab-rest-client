package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab orbit skill.
 *
 * @param name the name
 * @param version the version
 * @param compatibility the compatibility
 * @param serverVersion the server version
 * @param files the files
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrbitSkill")
public record GitLabOrbitSkill(
        @Nullable String name,
        @Nullable String version,
        @Nullable String compatibility,
        @Nullable String serverVersion,
        @Nullable List<GitLabOrbitSkillFile> files) {}
