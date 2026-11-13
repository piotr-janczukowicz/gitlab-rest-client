package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdDeployments}.
 *
 * @param environment the environment
 * @param sha the sha
 * @param ref the ref
 * @param tag the tag
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdDeployments/requestBody")
public record GitLabProjectDeploymentsCreatePayload(
        @Nullable String environment,
        @Nullable String sha,
        @Nullable String ref,
        @Nullable Boolean tag,
        GitLabProjectDeploymentsCreateStatus status) {
    public GitLabProjectDeploymentsCreatePayload {
        requireNonNull(status, "status");
    }
}
