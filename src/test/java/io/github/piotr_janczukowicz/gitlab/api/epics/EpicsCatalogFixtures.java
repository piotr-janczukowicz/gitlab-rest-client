package io.github.piotr_janczukowicz.gitlab.api.epics;

import java.time.Instant;
import java.util.List;

public final class EpicsCatalogFixtures {

    private EpicsCatalogFixtures() {}

    public static GitLabGroupEpicsCreateAwardEmojiPayload groupEpicsCreateAwardEmojiPayload() {
        return GitLabGroupEpicsCreateAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabGroupEpicsCreatePayload groupEpicsCreatePayload() {
        return GitLabGroupEpicsCreatePayloadBuilder.builder()
                .title("My Epic")
                .description("Epic description")
                .color("#1068bf")
                .confidential(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate("2018-07-31")
                .startDateFixed("2018-07-31")
                .startDateIsFixed(true)
                .endDate("2019-08-11")
                .dueDateFixed("2019-08-11")
                .dueDateIsFixed(true)
                .labels(List.of("labels"))
                .parentId(1L)
                .build();
    }

    public static GitLabGroupEpicsUpdatePayload groupEpicsUpdatePayload() {
        return GitLabGroupEpicsUpdatePayloadBuilder.builder()
                .title("My Epic")
                .color("#1068bf")
                .description("Epic description")
                .confidential(true)
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate("2018-07-31")
                .startDateFixed("2018-07-31")
                .startDateIsFixed(true)
                .endDate("2019-08-11")
                .dueDateFixed("2019-08-11")
                .dueDateIsFixed(true)
                .labels(List.of("labels"))
                .addLabels(List.of("add_labels"))
                .removeLabels(List.of("remove_labels"))
                .stateEvent(GitLabGroupEpicsUpdateStateEvent.REOPEN)
                .parentId(1L)
                .build();
    }
}
