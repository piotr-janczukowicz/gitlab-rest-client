package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class LinkedepicsCatalogFixtures {

    private LinkedepicsCatalogFixtures() {}

    public static GitLabGroupLinkedEpicsCreatePayload groupLinkedEpicsCreatePayload() {
        return GitLabGroupLinkedEpicsCreatePayloadBuilder.builder()
                .targetGroupId("1")
                .targetEpicIid(1L)
                .linkType(GitLabGroupLinkedEpicsCreateLinkType.RELATES_TO)
                .build();
    }

    public static GitLabRelatedEpicLink relatedEpicLink() {
        return GitLabRelatedEpicLinkBuilder.builder()
                .id(1L)
                .sourceEpic(CommonCatalogFixtures.epic())
                .targetEpic(CommonCatalogFixtures.epic())
                .linkType("relates_to")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
