package io.github.piotr_janczukowicz.gitlab.api.invitations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdInvitationsEmail}.
 *
 * @param accessLevel the access level
 * @param expiresAt the expires at
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdInvitationsEmail/requestBody")
public record GitLabProjectInvitationsUpdatePayload(
        @Nullable GitLabProjectInvitationsUpdateAccessLevel accessLevel,
        @Nullable Instant expiresAt,
        @Nullable Long memberRoleId) {}
