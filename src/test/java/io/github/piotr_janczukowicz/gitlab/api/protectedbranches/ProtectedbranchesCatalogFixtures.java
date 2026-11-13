package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

import java.util.List;
import java.util.Map;

public final class ProtectedbranchesCatalogFixtures {

    private ProtectedbranchesCatalogFixtures() {}

    public static GitLabProjectProtectedBranchesCreatePayload projectProtectedBranchesCreatePayload() {
        return GitLabProjectProtectedBranchesCreatePayloadBuilder.builder()
                .name("main")
                .pushAccessLevel(GitLabProjectProtectedBranchesCreatePushAccessLevel.DEVELOPER)
                .mergeAccessLevel(GitLabProjectProtectedBranchesCreateMergeAccessLevel.DEVELOPER)
                .allowForcePush(true)
                .allowedToPush(List.of(Map.of("key", "value")))
                .unprotectAccessLevel(GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.DEVELOPER)
                .allowedToMerge(List.of(Map.of("key", "value")))
                .allowedToUnprotect(List.of(Map.of("key", "value")))
                .codeOwnerApprovalRequired(true)
                .build();
    }

    public static GitLabProjectProtectedBranchesUpdatePayload projectProtectedBranchesUpdatePayload() {
        return GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder()
                .allowForcePush(true)
                .allowedToPush(List.of(Map.of("key", "value")))
                .unprotectAccessLevel(GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.DEVELOPER)
                .allowedToMerge(List.of(Map.of("key", "value")))
                .allowedToUnprotect(List.of(Map.of("key", "value")))
                .codeOwnerApprovalRequired(true)
                .build();
    }
}
