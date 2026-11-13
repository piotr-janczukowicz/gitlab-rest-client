package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class PipelinetriggersCatalogFixtures {

    private PipelinetriggersCatalogFixtures() {}

    public static GitLabProjectPipelineTriggersCreatePayload projectPipelineTriggersCreatePayload() {
        return GitLabProjectPipelineTriggersCreatePayloadBuilder.builder()
                .description("my trigger token description")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectPipelineTriggersUpdatePayload projectPipelineTriggersUpdatePayload() {
        return GitLabProjectPipelineTriggersUpdatePayloadBuilder.builder()
                .description("description")
                .build();
    }

    public static GitLabTrigger trigger() {
        return GitLabTriggerBuilder.builder()
                .id(1L)
                .token("6d056f63e50fe6f8c5f8f4aa10edb7")
                .description("test")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsed(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .owner(CommonCatalogFixtures.userBasic())
                .build();
    }
}
