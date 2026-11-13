package io.github.piotr_janczukowicz.gitlab.api.branches;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;

public final class BranchesCatalogFixtures {

    private BranchesCatalogFixtures() {}

    public static GitLabBranch branch() {
        return GitLabBranchBuilder.builder()
                .name("master")
                .commit(CommonCatalogFixtures.commit())
                .merged(true)
                .protectedValue(true)
                .developersCanPush(true)
                .developersCanMerge(true)
                .canPush(true)
                .defaultValue(true)
                .webUrl("https://gitlab.example.com/Commit921/the-dude/-/tree/master")
                .build();
    }

    public static GitLabProjectBranchesCreatePayload projectBranchesCreatePayload() {
        return GitLabProjectBranchesCreatePayloadBuilder.builder()
                .branch("branch")
                .ref("ref")
                .build();
    }

    public static GitLabProjectBranchesProtectPayload projectBranchesProtectPayload() {
        return GitLabProjectBranchesProtectPayloadBuilder.builder()
                .developersCanPush(true)
                .developersCanMerge(true)
                .build();
    }
}
