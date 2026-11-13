package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdProtectedBranches}.
 *
 * @param name the name
 * @param pushAccessLevel the push access level
 * @param mergeAccessLevel the merge access level
 * @param allowForcePush the allow force push
 * @param unprotectAccessLevel the unprotect access level
 * @param allowedToPush the allowed to push
 * @param allowedToMerge the allowed to merge
 * @param allowedToUnprotect the allowed to unprotect
 * @param codeOwnerApprovalRequired the code owner approval required
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdProtectedBranches/requestBody")
public record GitLabGroupGroupLevelProtectedBranchesCreatePayload(
        @Nullable String name,
        @Nullable GitLabGroupGroupLevelProtectedBranchesCreatePushAccessLevel pushAccessLevel,
        @Nullable GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel mergeAccessLevel,
        @Nullable Boolean allowForcePush,
        @Nullable GitLabGroupGroupLevelProtectedBranchesCreateUnprotectAccessLevel unprotectAccessLevel,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> allowedToPush,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> allowedToMerge,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> allowedToUnprotect,

        @Nullable Boolean codeOwnerApprovalRequired) {
    public GitLabGroupGroupLevelProtectedBranchesCreatePayload {
        if (allowedToPush != null) {
            allowedToPush = List.copyOf(allowedToPush);
        }
        if (allowedToMerge != null) {
            allowedToMerge = List.copyOf(allowedToMerge);
        }
        if (allowedToUnprotect != null) {
            allowedToUnprotect = List.copyOf(allowedToUnprotect);
        }
    }
}
