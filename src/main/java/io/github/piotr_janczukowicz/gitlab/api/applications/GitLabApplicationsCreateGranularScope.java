package io.github.piotr_janczukowicz.gitlab.api.applications;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab applications create granular scope of a GitLab resource.
 *
 * @param access the access
 * @param permissions the permissions
 * @param projectIds the project ids
 * @param groupIds the group ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Applications/requestBody/properties/granular_scopes/items")
public record GitLabApplicationsCreateGranularScope(
        GitLabApplicationsCreateGranularScopeAccess access,
        @Nullable List<String> permissions,
        @Nullable List<Long> projectIds,
        @Nullable List<Long> groupIds) {
    public GitLabApplicationsCreateGranularScope {
        requireNonNull(access, "access");
        if (permissions != null) {
            permissions = List.copyOf(permissions);
        }
        if (projectIds != null) {
            projectIds = List.copyOf(projectIds);
        }
        if (groupIds != null) {
            groupIds = List.copyOf(groupIds);
        }
    }
}
