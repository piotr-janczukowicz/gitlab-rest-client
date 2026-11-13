package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab protected branch.
 *
 * @param id the id
 * @param name the name
 * @param pushAccessLevels the push access levels
 * @param mergeAccessLevels the merge access levels
 * @param allowForcePush the allow force push
 * @param unprotectAccessLevels the unprotect access levels
 * @param codeOwnerApprovalRequired the code owner approval required
 * @param inherited the inherited
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProtectedBranch")
public record GitLabProtectedBranch(
        @Nullable Long id,
        @Nullable String name,
        @Nullable List<GitLabProtectedRefAccess> pushAccessLevels,
        @Nullable List<GitLabProtectedRefAccess> mergeAccessLevels,
        @Nullable Boolean allowForcePush,
        @Nullable List<GitLabProtectedRefAccess> unprotectAccessLevels,
        @Nullable Boolean codeOwnerApprovalRequired,
        @Nullable Boolean inherited) {}
