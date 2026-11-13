package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import java.time.Instant;

public final class RunnercontrollersCatalogFixtures {

    private RunnercontrollersCatalogFixtures() {}

    public static GitLabCiRunnerControllerDetail ciRunnerControllerDetail() {
        return GitLabCiRunnerControllerDetailBuilder.builder()
                .id(1L)
                .description("Controller for managing runner")
                .state("enabled")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .connected(true)
                .build();
    }

    public static GitLabCiRunnerControllerInstanceLevelScoping ciRunnerControllerInstanceLevelScoping() {
        return GitLabCiRunnerControllerInstanceLevelScopingBuilder.builder()
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCiRunnerControllerRunnerLevelScoping ciRunnerControllerRunnerLevelScoping() {
        return GitLabCiRunnerControllerRunnerLevelScopingBuilder.builder()
                .runnerId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabRunnerControllersCreatePayload runnerControllersCreatePayload() {
        return GitLabRunnerControllersCreatePayloadBuilder.builder()
                .description("Controller for managing runner")
                .state(GitLabRunnerControllersCreateState.DISABLED)
                .build();
    }

    public static GitLabRunnerControllersUpdatePayload runnerControllersUpdatePayload() {
        return GitLabRunnerControllersUpdatePayloadBuilder.builder()
                .description("Controller for managing runner")
                .state(GitLabRunnerControllersUpdateState.DISABLED)
                .build();
    }
}
