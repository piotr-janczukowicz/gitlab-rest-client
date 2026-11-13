package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdInvitations}.
 *
 * @param accessLevel the access level
 * @param email the email
 * @param userId the user id
 * @param expiresAt the expires at
 * @param inviteSource the invite source
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdInvitations/requestBody")
public record GitLabGroupInvitationsCreatePayload(
        GitLabGroupInvitationsCreateAccessLevel accessLevel,
        @Nullable List<String> email,
        @Nullable List<String> userId,
        @Nullable Instant expiresAt,
        @Nullable String inviteSource,
        @Nullable Long memberRoleId) {
    public GitLabGroupInvitationsCreatePayload {
        requireNonNull(accessLevel, "accessLevel");
        if (email != null) {
            email = List.copyOf(email);
        }
        if (userId != null) {
            userId = List.copyOf(userId);
        }
    }
}
