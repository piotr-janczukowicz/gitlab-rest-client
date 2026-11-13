package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdManagedLicensesManagedLicenseId}.
 *
 * @param name the name
 * @param approvalStatus the approval status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdManagedLicensesManagedLicenseId/requestBody")
public record GitLabProjectProjectsUpdateManagedLicensePayload(
        @Nullable String name, @Nullable GitLabProjectProjectsUpdateManagedLicenseApprovalStatus approvalStatus) {}
