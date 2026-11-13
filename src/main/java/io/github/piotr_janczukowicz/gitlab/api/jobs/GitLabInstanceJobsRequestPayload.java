package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4JobsRequest}.
 *
 * @param token the token
 * @param systemId the system id
 * @param lastUpdate the last update
 * @param info the info
 * @param session the session
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsRequest/requestBody")
public record GitLabInstanceJobsRequestPayload(
        @Nullable String token,
        @Nullable String systemId,
        @Nullable String lastUpdate,
        @Nullable GitLabInstanceJobsRequestInfo info,
        @Nullable GitLabInstanceJobsRequestSession session) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsRequestPayload[" + "token=<redacted>" + ", systemId=" + systemId + ", lastUpdate="
                + lastUpdate + ", info=" + info + ", session=" + session + "]";
    }
}
