package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdManagedLicenses}.
 *
 * @param name the name
 * @param approvalStatus the approval status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdManagedLicenses/requestBody")
public record GitLabProjectProjectsCreateManagedLicensePayload(
        @Nullable String name, GitLabProjectProjectsCreateManagedLicenseApprovalStatus approvalStatus) {
    public GitLabProjectProjectsCreateManagedLicensePayload {
        requireNonNull(approvalStatus, "approvalStatus");
    }
}
