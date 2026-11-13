package io.github.piotr_janczukowicz.gitlab.api.events;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class EventsCatalogFixtures {

    private EventsCatalogFixtures() {}

    public static GitLabEvent event() {
        return GitLabEventBuilder.builder()
                .id(1L)
                .projectId(1L)
                .actionName("closed")
                .targetId(1L)
                .targetIid(1L)
                .targetType("Issue")
                .authorId(1L)
                .targetTitle("Public project search field")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .note(CommonCatalogFixtures.note())
                .author(CommonCatalogFixtures.userBasic())
                .wikiPage(CommonCatalogFixtures.wikiPageBasic())
                .imported(true)
                .importedFrom("none")
                .pushData(EventsCatalogFixtures.pushEventPayload())
                .authorUsername("root")
                .build();
    }

    public static GitLabPushEventPayload pushEventPayload() {
        return GitLabPushEventPayloadBuilder.builder()
                .commitCount(1)
                .action("pushed")
                .refType("branch")
                .commitFrom("50d4420237a9de7be1304607147aec22e4a14af7")
                .commitTo("c5feabde2d8cd023215af4d2ceeb7a64839fc428")
                .ref("master")
                .commitTitle("Add simple search to projects in public area")
                .refCount(1)
                .build();
    }
}
