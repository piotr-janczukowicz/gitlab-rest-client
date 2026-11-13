package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import java.time.Instant;

public final class RunnercontrollertokensCatalogFixtures {

    private RunnercontrollertokensCatalogFixtures() {}

    public static GitLabCiRunnerControllerToken ciRunnerControllerToken() {
        return GitLabCiRunnerControllerTokenBuilder.builder()
                .id(1L)
                .runnerControllerId(1L)
                .description("Controller for managing runner")
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCiRunnerControllerTokenWithToken ciRunnerControllerTokenWithToken() {
        return GitLabCiRunnerControllerTokenWithTokenBuilder.builder()
                .id(1L)
                .runnerControllerId(1L)
                .description("Controller for managing runner")
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .token("token")
                .build();
    }

    public static GitLabRunnerControllerTokensCreatePayload runnerControllerTokensCreatePayload() {
        return GitLabRunnerControllerTokensCreatePayloadBuilder.builder()
                .description("Token for managing runner")
                .build();
    }
}
