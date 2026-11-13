package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AdminMemberRoles}.
 *
 * @param name the name
 * @param description the description
 * @param readAdminCicd the read admin cicd
 * @param readAdminGroups the read admin groups
 * @param readAdminProjects the read admin projects
 * @param readAdminSubscription the read admin subscription
 * @param readAdminMonitoring the read admin monitoring
 * @param readAdminUsers the read admin users
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AdminMemberRoles/requestBody")
public record GitLabGroupMemberRolesCreateAdminMemberRolePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean readAdminCicd,
        @Nullable Boolean readAdminGroups,
        @Nullable Boolean readAdminProjects,
        @Nullable Boolean readAdminSubscription,
        @Nullable Boolean readAdminMonitoring,
        @Nullable Boolean readAdminUsers) {}
