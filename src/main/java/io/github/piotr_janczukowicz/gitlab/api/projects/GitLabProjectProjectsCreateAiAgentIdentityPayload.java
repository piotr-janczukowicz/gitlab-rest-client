package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdAiAgentIdentities}.
 *
 * @param agentType the agent type
 * @param machineFingerprint the machine fingerprint
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdAiAgentIdentities/requestBody")
public record GitLabProjectProjectsCreateAiAgentIdentityPayload(
        GitLabProjectProjectsCreateAiAgentIdentityAgentType agentType,
        @Nullable String machineFingerprint) {
    public GitLabProjectProjectsCreateAiAgentIdentityPayload {
        requireNonNull(agentType, "agentType");
        requireMaxLengthIfPresent(machineFingerprint, 64, "machineFingerprint");
    }
}
