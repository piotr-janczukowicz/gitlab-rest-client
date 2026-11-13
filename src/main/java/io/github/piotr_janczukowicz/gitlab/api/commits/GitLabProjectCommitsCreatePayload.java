package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdStatusesSha}.
 *
 * @param state the state
 * @param ref the ref
 * @param targetUrl the target url
 * @param description the description
 * @param name the name
 * @param context the context
 * @param coverage the coverage
 * @param pipelineId the pipeline id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdStatusesSha/requestBody")
public record GitLabProjectCommitsCreatePayload(
        GitLabProjectCommitsCreateState state,
        @Nullable String ref,
        @Nullable String targetUrl,
        @Nullable String description,
        @Nullable String name,
        @Nullable String context,
        @Nullable Double coverage,
        @Nullable Long pipelineId) {
    public GitLabProjectCommitsCreatePayload {
        requireNonNull(state, "state");
    }
}
