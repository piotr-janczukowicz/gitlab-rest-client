package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4GroupsIdEnterpriseUsersUserId}.
 *
 * @param name the name
 * @param email the email
 * @param projectsLimit the projects limit
 * @param canCreateGroup the can create group
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4GroupsIdEnterpriseUsersUserId/requestBody")
public record GitLabGroupGroupEnterpriseUsersUpdatePayload(
        @Nullable String name,
        @Nullable String email,
        @Nullable Integer projectsLimit,
        @Nullable Boolean canCreateGroup) {
    public GitLabGroupGroupEnterpriseUsersUpdatePayload {
        requireAtLeastIfPresent(projectsLimit, 0, "projectsLimit");
    }
}
