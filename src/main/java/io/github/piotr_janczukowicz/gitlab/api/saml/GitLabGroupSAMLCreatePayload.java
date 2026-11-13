package io.github.piotr_janczukowicz.gitlab.api.saml;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdSamlGroupLinks}.
 *
 * @param samlGroupName the saml group name
 * @param accessLevel the access level
 * @param memberRoleId the member role id
 * @param provider the provider
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdSamlGroupLinks/requestBody")
public record GitLabGroupSAMLCreatePayload(
        @Nullable String samlGroupName,
        GitLabGroupSAMLCreateAccessLevel accessLevel,
        @Nullable Long memberRoleId,
        @Nullable String provider) {
    public GitLabGroupSAMLCreatePayload {
        requireNonNull(accessLevel, "accessLevel");
    }
}
