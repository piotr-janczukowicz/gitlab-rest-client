package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdComplianceExternalControlsControlIdStatus}.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdComplianceExternalControlsControlIdStatus/requestBody")
public record GitLabProjectProjectsStatusComplianceExternalControlPayload(
        GitLabProjectProjectsStatusComplianceExternalControlStatus status) {
    public GitLabProjectProjectsStatusComplianceExternalControlPayload {
        requireNonNull(status, "status");
    }
}
