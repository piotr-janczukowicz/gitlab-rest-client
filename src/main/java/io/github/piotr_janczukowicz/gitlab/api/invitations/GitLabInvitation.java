package io.github.piotr_janczukowicz.gitlab.api.invitations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab invitation.
 *
 * @param accessLevel the access level
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param inviteEmail the invite email
 * @param inviteToken the invite token
 * @param userName the user name
 * @param createdByName the created by name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesInvitation")
public record GitLabInvitation(
        @Nullable String accessLevel,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String expiresAt,
        @Nullable String inviteEmail,
        @Nullable String inviteToken,
        @Nullable String userName,
        @Nullable String createdByName) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code inviteToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabInvitation[" + "accessLevel=" + accessLevel + ", createdAt=" + createdAt + ", expiresAt="
                + expiresAt + ", inviteEmail=" + inviteEmail + ", inviteToken=<redacted>" + ", userName=" + userName
                + ", createdByName=" + createdByName + "]";
    }
}
