package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4RunnersVerify}.
 *
 * @param token the token
 * @param systemId the system id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4RunnersVerify/requestBody")
public record GitLabInstanceRunnersVerifyPayload(
        @Nullable String token, @Nullable String systemId) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceRunnersVerifyPayload[" + "token=<redacted>" + ", systemId=" + systemId + "]";
    }
}
