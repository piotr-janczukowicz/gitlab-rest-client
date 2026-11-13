package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ResourcestateeventsCatalogFixtures {

    private ResourcestateeventsCatalogFixtures() {}

    public static GitLabResourceStateEvent resourceStateEvent() {
        return GitLabResourceStateEventBuilder.builder()
                .id(1L)
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .resourceType("Issue")
                .resourceId(1L)
                .sourceCommit("7b09ce7e6f80347baf0316c8c94cdba9a0a7e91d")
                .sourceMergeRequestId(1L)
                .state("opened")
                .build();
    }
}
