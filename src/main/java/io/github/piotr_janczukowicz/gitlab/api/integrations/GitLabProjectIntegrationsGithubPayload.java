package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsGithub}.
 *
 * @param token the token
 * @param repositoryUrl the repository url
 * @param staticContext the static context
 * @param pipelineEvents the pipeline events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsGithub/requestBody")
public record GitLabProjectIntegrationsGithubPayload(
        @Nullable String token,
        @Nullable String repositoryUrl,
        @Nullable Boolean staticContext,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsGithubPayload[" + "token=<redacted>" + ", repositoryUrl=" + repositoryUrl
                + ", staticContext=" + staticContext + ", pipelineEvents=" + pipelineEvents + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
