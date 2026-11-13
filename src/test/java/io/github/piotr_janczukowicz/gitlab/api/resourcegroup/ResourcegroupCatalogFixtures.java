package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import java.time.Instant;

public final class ResourcegroupCatalogFixtures {

    private ResourcegroupCatalogFixtures() {}

    public static GitLabCiResourceGroup ciResourceGroup() {
        return GitLabCiResourceGroupBuilder.builder()
                .id(1L)
                .key("production")
                .processMode("unordered")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectResourceGroupUpdatePayload projectResourceGroupUpdatePayload() {
        return GitLabProjectResourceGroupUpdatePayloadBuilder.builder()
                .processMode(GitLabProjectResourceGroupUpdateProcessMode.UNORDERED)
                .build();
    }
}
