package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4OrganizationsIdUsersUserId}.
 *
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4OrganizationsIdUsersUserId/requestBody")
public record GitLabOrganizationsUpdateUserPayload(GitLabOrganizationsUpdateUserAccessLevel accessLevel) {
    public GitLabOrganizationsUpdateUserPayload {
        requireNonNull(accessLevel, "accessLevel");
    }
}
