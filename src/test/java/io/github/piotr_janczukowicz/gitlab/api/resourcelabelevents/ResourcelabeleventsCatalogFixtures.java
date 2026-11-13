package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ResourcelabeleventsCatalogFixtures {

    private ResourcelabeleventsCatalogFixtures() {}

    public static GitLabResourceLabelEvent resourceLabelEvent() {
        return GitLabResourceLabelEventBuilder.builder()
                .id(1L)
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .resourceType("Issue")
                .resourceId(1L)
                .label(CommonCatalogFixtures.labelBasic())
                .action("add")
                .build();
    }
}
