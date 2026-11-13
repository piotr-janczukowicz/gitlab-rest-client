package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidStatusCheckResponses}.
 *
 * @param externalStatusCheckId the external status check id
 * @param sha the sha
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidStatusCheckResponses/requestBody")
public record GitLabProjectMergeRequestsCreateStatusCheckResponsePayload(
        @Nullable Long externalStatusCheckId,
        @Nullable String sha,
        GitLabProjectMergeRequestsCreateStatusCheckResponseStatus status) {
    public GitLabProjectMergeRequestsCreateStatusCheckResponsePayload {
        requireNonNull(status, "status");
    }
}
