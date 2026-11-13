package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class MergetrainsCatalogFixtures {

    private MergetrainsCatalogFixtures() {}

    public static GitLabMergeRequestSimple mergeRequestSimple() {
        return GitLabMergeRequestSimpleBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Test MR 1580978354")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("http://local.gitlab.test:8181/root/merge-train-race-condition/-/merge_requests/59")
                .build();
    }

    public static GitLabMergeTrainsCar mergeTrainsCar() {
        return GitLabMergeTrainsCarBuilder.builder()
                .id(1L)
                .mergeRequest(MergetrainsCatalogFixtures.mergeRequestSimple())
                .user(CommonCatalogFixtures.userBasic())
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .targetBranch("develop")
                .status(GitLabMergeTrainsCarStatus.IDLE)
                .mergedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1)
                .build();
    }

    public static GitLabProjectMergeTrainsCreateMergeRequestPayload projectMergeTrainsCreateMergeRequestPayload() {
        return GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder()
                .sha("sha")
                .squash(true)
                .whenPipelineSucceeds(true)
                .autoMerge(true)
                .build();
    }
}
