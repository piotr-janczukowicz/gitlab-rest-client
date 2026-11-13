package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdMirrorPull}.
 *
 * @param enabled the enabled
 * @param url the url
 * @param authUser the auth user
 * @param authPassword the auth password
 * @param mirrorTriggerBuilds the mirror trigger builds
 * @param onlyMirrorProtectedBranches the only mirror protected branches
 * @param mirrorOverwritesDivergedBranches the mirror overwrites diverged branches
 * @param mirrorBranchRegex the mirror branch regex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdMirrorPull/requestBody")
public record GitLabProjectPullMirroringUpdatePayload(
        @Nullable Boolean enabled,
        @Nullable String url,
        @Nullable String authUser,
        @Nullable String authPassword,
        @Nullable Boolean mirrorTriggerBuilds,
        @Nullable Boolean onlyMirrorProtectedBranches,
        @Nullable Boolean mirrorOverwritesDivergedBranches,
        @Nullable String mirrorBranchRegex) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code authPassword} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectPullMirroringUpdatePayload[" + "enabled=" + enabled + ", url=" + url + ", authUser="
                + authUser + ", authPassword=<redacted>" + ", mirrorTriggerBuilds=" + mirrorTriggerBuilds
                + ", onlyMirrorProtectedBranches=" + onlyMirrorProtectedBranches + ", mirrorOverwritesDivergedBranches="
                + mirrorOverwritesDivergedBranches + ", mirrorBranchRegex=" + mirrorBranchRegex + "]";
    }
}
