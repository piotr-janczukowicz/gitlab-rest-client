package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import java.time.Instant;

public final class PullmirroringCatalogFixtures {

    private PullmirroringCatalogFixtures() {}

    public static GitLabProjectPullMirroringCreatePayload projectPullMirroringCreatePayload() {
        return GitLabProjectPullMirroringCreatePayloadBuilder.builder()
                .action("action")
                .pullRequestNumber(1)
                .pullRequestHeadRef("pull_request.head.ref")
                .pullRequestHeadSha("pull_request.head.sha")
                .pullRequestHeadRepoFullName("pull_request.head.repo.full_name")
                .pullRequestBaseRef("pull_request.base.ref")
                .pullRequestBaseSha("pull_request.base.sha")
                .pullRequestBaseRepoFullName("pull_request.base.repo.full_name")
                .force(true)
                .build();
    }

    public static GitLabProjectPullMirroringUpdatePayload projectPullMirroringUpdatePayload() {
        return GitLabProjectPullMirroringUpdatePayloadBuilder.builder()
                .enabled(true)
                .url("url")
                .authUser("auth_user")
                .authPassword("auth_password")
                .mirrorTriggerBuilds(true)
                .onlyMirrorProtectedBranches(true)
                .mirrorOverwritesDivergedBranches(true)
                .mirrorBranchRegex("mirror_branch_regex")
                .build();
    }

    public static GitLabPullMirror pullMirror() {
        return GitLabPullMirrorBuilder.builder()
                .id(1L)
                .updateStatus("finished")
                .url("https://*****:*****@gitlab.com/gitlab-org/security/gitlab.git")
                .lastError("last_error")
                .lastUpdateAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUpdateStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastSuccessfulUpdateAt(Instant.parse("2026-01-01T00:00:00Z"))
                .enabled(true)
                .mirrorTriggerBuilds(true)
                .onlyMirrorProtectedBranches(true)
                .mirrorOverwritesDivergedBranches(true)
                .mirrorBranchRegex("branch_name")
                .build();
    }
}
