package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab granular scope.
 *
 * @param access the access
 * @param permissions the permissions
 * @param projectId the project id
 * @param groupId the group id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGranularScope")
public record GitLabGranularScope(
        @Nullable String access,
        @Nullable List<String> permissions,
        @Nullable Long projectId,
        @Nullable Long groupId) {}
