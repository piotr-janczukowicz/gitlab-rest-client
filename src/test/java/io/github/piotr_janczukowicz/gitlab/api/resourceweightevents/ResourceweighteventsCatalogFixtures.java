package io.github.piotr_janczukowicz.gitlab.api.resourceweightevents;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ResourceweighteventsCatalogFixtures {

    private ResourceweighteventsCatalogFixtures() {}

    public static GitLabResourceWeightEvent resourceWeightEvent() {
        return GitLabResourceWeightEventBuilder.builder()
                .id(1L)
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .issueId(1L)
                .weight(1)
                .build();
    }
}
