package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupAccess;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectAccess;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project with access and catalog permissions of a GitLab resource.
 *
 * @param projectAccess the project access
 * @param groupAccess the group access
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectsWithAccessAndCatalogSetting/properties/permissions")
public record GitLabProjectWithAccessAndCatalogPermissions(
        @Nullable GitLabProjectAccess projectAccess,
        @Nullable GitLabGroupAccess groupAccess) {}
