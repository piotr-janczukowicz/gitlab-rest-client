package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;
import java.util.Map;

public final class GrouplevelprotectedbranchesCatalogFixtures {

    private GrouplevelprotectedbranchesCatalogFixtures() {}

    public static GitLabGroupGroupLevelProtectedBranchesCreatePayload groupGroupLevelProtectedBranchesCreatePayload() {
        return GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder()
                .name("main")
                .pushAccessLevel(GitLabGroupGroupLevelProtectedBranchesCreatePushAccessLevel.DEVELOPER)
                .mergeAccessLevel(GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.DEVELOPER)
                .allowForcePush(true)
                .unprotectAccessLevel(GitLabGroupGroupLevelProtectedBranchesCreateUnprotectAccessLevel.DEVELOPER)
                .allowedToPush(List.of(Map.of("key", "value")))
                .allowedToMerge(List.of(Map.of("key", "value")))
                .allowedToUnprotect(List.of(Map.of("key", "value")))
                .codeOwnerApprovalRequired(true)
                .build();
    }

    public static GitLabGroupGroupLevelProtectedBranchesUpdatePayload groupGroupLevelProtectedBranchesUpdatePayload() {
        return GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder()
                .allowForcePush(true)
                .unprotectAccessLevel(GitLabGroupGroupLevelProtectedBranchesUpdateUnprotectAccessLevel.DEVELOPER)
                .allowedToPush(List.of(Map.of("key", "value")))
                .allowedToMerge(List.of(Map.of("key", "value")))
                .allowedToUnprotect(List.of(Map.of("key", "value")))
                .codeOwnerApprovalRequired(true)
                .build();
    }

    public static GitLabGroupProtectedBranch groupProtectedBranch() {
        return GitLabGroupProtectedBranchBuilder.builder()
                .id(1L)
                .name("main")
                .pushAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .mergeAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .allowForcePush(true)
                .unprotectAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .codeOwnerApprovalRequired(true)
                .build();
    }
}
