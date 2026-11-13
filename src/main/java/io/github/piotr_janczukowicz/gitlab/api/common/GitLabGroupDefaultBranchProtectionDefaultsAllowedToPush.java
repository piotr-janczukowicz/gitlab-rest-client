package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * The git lab group default branch protection defaults allowed to push of a GitLab resource.
 *
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "components/schemas/APIEntitiesGroup/properties/default_branch_protection_defaults/properties/allowed_to_push/items")
public record GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush(
        GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushAccessLevel accessLevel) {
    public GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush {
        requireNonNull(accessLevel, "accessLevel");
    }
}
