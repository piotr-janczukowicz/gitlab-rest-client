package io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ResourceiterationeventsCatalogFixtures {

    private ResourceiterationeventsCatalogFixtures() {}

    public static GitLabResourceIterationEvent resourceIterationEvent() {
        return GitLabResourceIterationEventBuilder.builder()
                .id(1L)
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .resourceType("Issue")
                .resourceId(1L)
                .iteration(CommonCatalogFixtures.iteration())
                .action("add")
                .build();
    }
}
