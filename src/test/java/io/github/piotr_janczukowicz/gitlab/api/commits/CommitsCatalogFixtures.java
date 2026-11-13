package io.github.piotr_janczukowicz.gitlab.api.commits;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.Map;

public final class CommitsCatalogFixtures {

    private CommitsCatalogFixtures() {}

    public static GitLabBasicRef basicRef() {
        return GitLabBasicRefBuilder.builder().type("tag").name("v1.1.0").build();
    }

    public static GitLabCommitNote commitNote() {
        return GitLabCommitNoteBuilder.builder()
                .note("this doc is really nice")
                .path("README.md")
                .line(1)
                .lineType("new")
                .author(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCommitSequence commitSequence() {
        return GitLabCommitSequenceBuilder.builder().count(1).build();
    }

    public static GitLabCommitSignature commitSignature() {
        return GitLabCommitSignatureBuilder.builder()
                .signatureType("PGP")
                .signature(Map.of("key", "value"))
                .commitSource("gitaly")
                .build();
    }

    public static GitLabCommitStatus commitStatus() {
        return GitLabCommitStatusBuilder.builder()
                .id(1L)
                .sha("18f3e63d05582537db6d183d9d557be09e1f90c8")
                .ref("develop")
                .status("success")
                .name("default")
                .targetUrl("https://gitlab.example.com/janedoe/gitlab-foss/builds/91")
                .description("description")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .allowFailure(true)
                .coverage(1.5)
                .pipelineId(1L)
                .author(CommonCatalogFixtures.userBasic())
                .build();
    }

    public static GitLabProjectCommitsCherryPickPayload projectCommitsCherryPickPayload() {
        return GitLabProjectCommitsCherryPickPayloadBuilder.builder()
                .branch("master")
                .dryRun(true)
                .message("Initial commit")
                .build();
    }

    public static GitLabProjectCommitsCreateCommentPayload projectCommitsCreateCommentPayload() {
        return GitLabProjectCommitsCreateCommentPayloadBuilder.builder()
                .note("Nice code!")
                .path("doc/update/5.4-to-6.0.md")
                .line(1)
                .lineType(GitLabProjectCommitsCreateCommentLineType.NEW)
                .build();
    }

    public static GitLabProjectCommitsCreatePayload projectCommitsCreatePayload() {
        return GitLabProjectCommitsCreatePayloadBuilder.builder()
                .state(GitLabProjectCommitsCreateState.PENDING)
                .ref("develop")
                .targetUrl("https://gitlab.example.com/janedoe/gitlab-foss/builds/91")
                .description("description")
                .name("coverage")
                .context("coverage")
                .coverage(1.5)
                .pipelineId(1L)
                .build();
    }

    public static GitLabProjectCommitsRevertPayload projectCommitsRevertPayload() {
        return GitLabProjectCommitsRevertPayloadBuilder.builder()
                .branch("master")
                .dryRun(true)
                .build();
    }
}
