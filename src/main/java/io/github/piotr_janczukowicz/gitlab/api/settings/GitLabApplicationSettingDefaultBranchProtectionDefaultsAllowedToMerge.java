package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * The git lab application setting default branch protection defaults allowed to merge of a GitLab resource.
 *
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "components/schemas/APIEntitiesApplicationSetting/properties/default_branch_protection_defaults/properties/allowed_to_merge/items")
public record GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge(
        GitLabApplicationSettingBranchProtectionMergeAccessLevel accessLevel) {
    public GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge {
        requireNonNull(accessLevel, "accessLevel");
    }
}
