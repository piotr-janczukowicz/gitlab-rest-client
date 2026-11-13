package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runner registration details.
 *
 * @param id the id
 * @param token the token
 * @param tokenExpiresAt the token expires at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRunnerRegistrationDetails")
public record GitLabCiRunnerRegistrationDetails(
        @Nullable String id,
        @Nullable String token,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (token_expires_at)")
        Instant tokenExpiresAt) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabCiRunnerRegistrationDetails[" + "id=" + id + ", token=<redacted>" + ", tokenExpiresAt="
                + tokenExpiresAt + "]";
    }
}
