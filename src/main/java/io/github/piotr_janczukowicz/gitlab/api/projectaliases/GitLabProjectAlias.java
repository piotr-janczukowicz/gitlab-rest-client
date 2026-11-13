package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project alias.
 *
 * @param id the id
 * @param projectId the project id
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectAlias")
public record GitLabProjectAlias(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String name) {}
