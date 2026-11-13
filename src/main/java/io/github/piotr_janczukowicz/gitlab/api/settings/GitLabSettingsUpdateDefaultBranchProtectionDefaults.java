package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update default branch protection defaults of a GitLab resource.
 *
 * @param allowedToPush the allowed to push
 * @param allowForcePush the allow force push
 * @param allowedToMerge the allowed to merge
 * @param codeOwnerApprovalRequired the code owner approval required
 * @param developerCanInitialPush the developer can initial push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/default_branch_protection_defaults")
public record GitLabSettingsUpdateDefaultBranchProtectionDefaults(
        @Nullable List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToPush> allowedToPush,
        @Nullable Boolean allowForcePush,
        @Nullable List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge> allowedToMerge,
        @Nullable Boolean codeOwnerApprovalRequired,
        @Nullable Boolean developerCanInitialPush) {
    public GitLabSettingsUpdateDefaultBranchProtectionDefaults {
        if (allowedToPush != null) {
            allowedToPush = List.copyOf(allowedToPush);
        }
        if (allowedToMerge != null) {
            allowedToMerge = List.copyOf(allowedToMerge);
        }
    }
}
