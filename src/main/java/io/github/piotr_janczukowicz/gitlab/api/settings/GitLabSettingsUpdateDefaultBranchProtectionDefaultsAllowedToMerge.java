package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * The git lab settings update default branch protection defaults allowed to merge of a GitLab resource.
 *
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/putApiV4ApplicationSettings/requestBody/properties/default_branch_protection_defaults/properties/allowed_to_merge/items")
public record GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge(
        GitLabSettingsUpdateBranchProtectionMergeAccessLevel accessLevel) {
    public GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge {
        requireNonNull(accessLevel, "accessLevel");
    }
}
