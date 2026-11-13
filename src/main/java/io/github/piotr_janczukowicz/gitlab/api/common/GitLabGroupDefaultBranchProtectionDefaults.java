package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group default branch protection defaults of a GitLab resource.
 *
 * @param allowedToPush the allowed to push
 * @param allowForcePush the allow force push
 * @param allowedToMerge the allowed to merge
 * @param codeOwnerApprovalRequired the code owner approval required
 * @param developerCanInitialPush the developer can initial push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroup/properties/default_branch_protection_defaults")
public record GitLabGroupDefaultBranchProtectionDefaults(
        @Nullable List<GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush> allowedToPush,
        @Nullable Boolean allowForcePush,
        @Nullable List<GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge> allowedToMerge,
        @Nullable Boolean codeOwnerApprovalRequired,
        @Nullable Boolean developerCanInitialPush) {}
