package io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ResourcemilestoneeventsCatalogFixtures {

    private ResourcemilestoneeventsCatalogFixtures() {}

    public static GitLabResourceMilestoneEvent resourceMilestoneEvent() {
        return GitLabResourceMilestoneEventBuilder.builder()
                .id(1L)
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .resourceType("Issue")
                .resourceId(1L)
                .milestone(CommonCatalogFixtures.milestone())
                .action("add")
                .state("active")
                .build();
    }
}
