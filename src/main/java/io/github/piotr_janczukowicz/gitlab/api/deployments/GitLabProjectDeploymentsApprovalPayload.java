package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdDeploymentsDeploymentIdApproval}.
 *
 * @param status the status
 * @param comment the comment
 * @param representedAs the represented as
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdDeploymentsDeploymentIdApproval/requestBody")
public record GitLabProjectDeploymentsApprovalPayload(
        GitLabProjectDeploymentsApprovalStatus status,
        @Nullable String comment,
        @Nullable String representedAs) {
    public GitLabProjectDeploymentsApprovalPayload {
        requireNonNull(status, "status");
    }
}
