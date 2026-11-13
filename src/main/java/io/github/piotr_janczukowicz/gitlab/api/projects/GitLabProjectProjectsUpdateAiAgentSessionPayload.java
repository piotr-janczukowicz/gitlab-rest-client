package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdAiAgentSessionsSessionId}.
 *
 * @param status the status
 * @param jsonlSha256 the jsonl sha256
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdAiAgentSessionsSessionId/requestBody")
public record GitLabProjectProjectsUpdateAiAgentSessionPayload(
        GitLabProjectProjectsUpdateAiAgentSessionStatus status,
        @Nullable String jsonlSha256) {
    public GitLabProjectProjectsUpdateAiAgentSessionPayload {
        requireNonNull(status, "status");
        requireMaxLengthIfPresent(jsonlSha256, 64, "jsonlSha256");
    }
}
