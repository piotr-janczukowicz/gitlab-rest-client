package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import java.time.Instant;
import java.util.List;

public final class BroadcastmessagesCatalogFixtures {

    private BroadcastmessagesCatalogFixtures() {}

    public static GitLabBroadcastMessagesCreatePayload broadcastMessagesCreatePayload() {
        return GitLabBroadcastMessagesCreatePayloadBuilder.builder()
                .message("message")
                .startsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .endsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .color("color")
                .font("font")
                .targetAccessLevels(List.of(10))
                .targetPath("target_path")
                .broadcastType(GitLabBroadcastMessagesCreateBroadcastType.BANNER)
                .dismissable(true)
                .theme(GitLabBroadcastMessagesCreateTheme.INDIGO)
                .build();
    }

    public static GitLabBroadcastMessagesUpdatePayload broadcastMessagesUpdatePayload() {
        return GitLabBroadcastMessagesUpdatePayloadBuilder.builder()
                .message("message")
                .startsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .endsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .color("color")
                .font("font")
                .targetAccessLevels(List.of(10))
                .targetPath("target_path")
                .broadcastType(GitLabBroadcastMessagesUpdateBroadcastType.BANNER)
                .dismissable(true)
                .theme(GitLabBroadcastMessagesUpdateTheme.INDIGO)
                .build();
    }

    public static GitLabSystemBroadcastMessage systemBroadcastMessage() {
        return GitLabSystemBroadcastMessageBuilder.builder()
                .id(1L)
                .message("Example broadcast message")
                .startsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .endsAt(Instant.parse("2026-01-01T00:00:00Z"))
                .color("#E75E40")
                .font("#FFFFFF")
                .targetAccessLevels(List.of(1))
                .targetPath("*/welcome")
                .broadcastType("banner")
                .theme("indigo")
                .dismissable(true)
                .active(true)
                .build();
    }
}
