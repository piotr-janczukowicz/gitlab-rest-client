package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AiDuoWorkflowsRevokeToken}.
 *
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsRevokeToken/requestBody")
public record GitLabDuoAgentPlatformFlowsRevokeTokenPayload(
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabDuoAgentPlatformFlowsRevokeTokenPayload[" + "token=<redacted>" + "]";
    }
}
