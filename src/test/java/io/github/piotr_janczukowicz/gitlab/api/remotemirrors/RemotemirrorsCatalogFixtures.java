package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import java.time.Instant;
import java.util.List;

public final class RemotemirrorsCatalogFixtures {

    private RemotemirrorsCatalogFixtures() {}

    public static GitLabMirrorHostKey mirrorHostKey() {
        return GitLabMirrorHostKeyBuilder.builder()
                .fingerprintSha256("SHA256:abcd1234")
                .build();
    }

    public static GitLabProjectRemoteMirrorsCreatePayload projectRemoteMirrorsCreatePayload() {
        return GitLabProjectRemoteMirrorsCreatePayloadBuilder.builder()
                .url("https://*****:*****@example.com/gitlab/example.git")
                .enabled(true)
                .authMethod(GitLabProjectRemoteMirrorsCreateAuthMethod.SSH_PUBLIC_KEY)
                .keepDivergentRefs(true)
                .onlyProtectedBranches(true)
                .mirrorBranchRegex("mirror_branch_regex")
                .hostKeys(List.of("host_keys"))
                .build();
    }

    public static GitLabProjectRemoteMirrorsUpdatePayload projectRemoteMirrorsUpdatePayload() {
        return GitLabProjectRemoteMirrorsUpdatePayloadBuilder.builder()
                .enabled(true)
                .authMethod("auth_method")
                .keepDivergentRefs(true)
                .onlyProtectedBranches(true)
                .mirrorBranchRegex("mirror_branch_regex")
                .hostKeys(List.of("host_keys"))
                .build();
    }

    public static GitLabRemoteMirror remoteMirror() {
        return GitLabRemoteMirrorBuilder.builder()
                .id(1L)
                .enabled(true)
                .url("https://*****:*****@example.com/gitlab/example.git")
                .updateStatus("finished")
                .lastUpdateAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUpdateStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastSuccessfulUpdateAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastError("The remote mirror URL is invalid.")
                .onlyProtectedBranches(true)
                .keepDivergentRefs(true)
                .authMethod("password")
                .hostKeys(List.of(RemotemirrorsCatalogFixtures.mirrorHostKey()))
                .mirrorBranchRegex("feature-.*")
                .build();
    }
}
