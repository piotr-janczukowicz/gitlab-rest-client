package io.github.piotr_janczukowicz.gitlab.api.organizations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4OrganizationsIdUsers}.
 *
 * @param username the username
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OrganizationsIdUsers/requestBody")
public record GitLabOrganizationsCreateUserPayload(
        @Nullable String username, @Nullable GitLabOrganizationsCreateUserAccessLevel accessLevel) {}
