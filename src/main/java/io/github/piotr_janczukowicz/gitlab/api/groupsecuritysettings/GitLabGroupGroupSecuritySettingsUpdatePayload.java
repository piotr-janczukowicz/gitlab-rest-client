package io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdSecuritySettings}.
 *
 * @param secretPushProtectionEnabled the secret push protection enabled
 * @param projectsToExclude the projects to exclude
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdSecuritySettings/requestBody")
public record GitLabGroupGroupSecuritySettingsUpdatePayload(
        @Nullable Boolean secretPushProtectionEnabled,
        @Nullable List<Integer> projectsToExclude) {
    public GitLabGroupGroupSecuritySettingsUpdatePayload {
        if (projectsToExclude != null) {
            projectsToExclude = List.copyOf(projectsToExclude);
        }
    }
}
