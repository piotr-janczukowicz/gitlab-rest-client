package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import java.time.Instant;
import java.util.Map;

public final class ActivecontextCatalogFixtures {

    private ActivecontextCatalogFixtures() {}

    public static GitLabActiveContextActivateConnectionPayload activeContextActivateConnectionPayload() {
        return GitLabActiveContextActivateConnectionPayloadBuilder.builder()
                .connectionId(1L)
                .build();
    }

    public static GitLabActiveContextDeactivateConnectionPayload activeContextDeactivateConnectionPayload() {
        return GitLabActiveContextDeactivateConnectionPayloadBuilder.builder()
                .connectionId(1L)
                .build();
    }

    public static GitLabActiveContextReplayDeadQueuePayload activeContextReplayDeadQueuePayload() {
        return GitLabActiveContextReplayDeadQueuePayloadBuilder.builder()
                .queue("queue")
                .build();
    }

    public static GitLabActiveContextUpdateCodeEnabledNamespacePayload
            activeContextUpdateCodeEnabledNamespacePayload() {
        return GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder.builder()
                .namespaceId("text")
                .state(GitLabActiveContextUpdateCodeEnabledNamespaceState.PENDING)
                .connectionId(1L)
                .build();
    }

    public static GitLabActiveContextUpdateCollectionPayload activeContextUpdateCollectionPayload() {
        return GitLabActiveContextUpdateCollectionPayloadBuilder.builder()
                .queueShardCount(1)
                .queueShardLimit(1)
                .connectionId(1L)
                .build();
    }

    public static GitLabAiActiveContextCodeEnabledNamespace aiActiveContextCodeEnabledNamespace() {
        return GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder()
                .id(1L)
                .namespaceId(1L)
                .connectionId(1L)
                .state("pending")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAiActiveContextCollection aiActiveContextCollection() {
        return GitLabAiActiveContextCollectionBuilder.builder()
                .id(1L)
                .name("gitlab_active_context_code")
                .connectionId(1L)
                .options(Map.of("key", "value"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAiActiveContextConnection aiActiveContextConnection() {
        return GitLabAiActiveContextConnectionBuilder.builder()
                .id(1L)
                .name("elastic")
                .adapterClass("ActiveContext::Databases::Elasticsearch::Adapter")
                .prefix("gitlab")
                .active(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
