package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class RolloutsCatalogFixtures {

    private RolloutsCatalogFixtures() {}

    public static GitLabCdRollout cdRollout() {
        return GitLabCdRolloutBuilder.builder()
                .id(1L)
                .iid(1L)
                .state("in_progress")
                .workflowRef("cd-rollout-1")
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabRolloutsCreateChannelToken rolloutsCreateChannelToken() {
        return GitLabRolloutsCreateChannelTokenBuilder.builder()
                .channelName("channel_name")
                .token("token")
                .build();
    }

    public static GitLabRolloutsCreateData rolloutsCreateData() {
        return GitLabRolloutsCreateDataBuilder.builder()
                .position(List.of(1))
                .stageName("stage_name")
                .environment("environment")
                .stepType("step_type")
                .service("service")
                .error("error")
                .reason("reason")
                .reply("reply")
                .build();
    }

    public static GitLabRolloutsCreatePayload rolloutsCreatePayload() {
        return GitLabRolloutsCreatePayloadBuilder.builder()
                .topic("topic")
                .type("type")
                .data(RolloutsCatalogFixtures.rolloutsCreateData())
                .value(Map.of("key", "value"))
                .channelTokens(List.of(RolloutsCatalogFixtures.rolloutsCreateChannelToken()))
                .build();
    }
}
