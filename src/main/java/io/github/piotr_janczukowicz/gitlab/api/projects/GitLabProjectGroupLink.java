package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project group link.
 *
 * @param id the id
 * @param projectId the project id
 * @param groupId the group id
 * @param groupAccess the group access
 * @param expiresAt the expires at
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectGroupLink")
public record GitLabProjectGroupLink(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable Long groupId,
        @Nullable Integer groupAccess,
        @Nullable LocalDate expiresAt,
        @Nullable Long memberRoleId) {}
