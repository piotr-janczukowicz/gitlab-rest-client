package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4ProjectsIdDeploymentsDeploymentId}.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdDeploymentsDeploymentId/requestBody")
public record GitLabProjectDeploymentsUpdatePayload(GitLabProjectDeploymentsUpdateStatus status) {
    public GitLabProjectDeploymentsUpdatePayload {
        requireNonNull(status, "status");
    }
}
