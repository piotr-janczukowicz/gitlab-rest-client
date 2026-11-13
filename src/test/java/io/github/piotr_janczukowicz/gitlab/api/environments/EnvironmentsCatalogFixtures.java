package io.github.piotr_janczukowicz.gitlab.api.environments;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class EnvironmentsCatalogFixtures {

    private EnvironmentsCatalogFixtures() {}

    public static GitLabEnvironment environment() {
        return GitLabEnvironmentBuilder.builder()
                .id(1L)
                .name("deploy")
                .slug("deploy")
                .externalUrl("https://deploy.gitlab.example.com")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .tier("development")
                .project(CommonCatalogFixtures.basicProjectDetails())
                .lastDeployment(CommonCatalogFixtures.deployment())
                .state("available")
                .autoStopAt(Instant.parse("2026-01-01T00:00:00Z"))
                .clusterAgent(CommonCatalogFixtures.clusterAgent())
                .kubernetesNamespace("kubernetes_namespace")
                .fluxResourcePath("flux_resource_path")
                .description("description")
                .autoStopSetting("always")
                .build();
    }

    public static GitLabProjectEnvironmentsCreatePayload projectEnvironmentsCreatePayload() {
        return GitLabProjectEnvironmentsCreatePayloadBuilder.builder()
                .name("name")
                .externalUrl("external_url")
                .tier(GitLabProjectEnvironmentsCreateTier.PRODUCTION)
                .clusterAgentId(1L)
                .kubernetesNamespace("kubernetes_namespace")
                .fluxResourcePath("flux_resource_path")
                .description("description")
                .autoStopSetting(GitLabProjectEnvironmentsCreateAutoStopSetting.ALWAYS)
                .build();
    }

    public static GitLabProjectEnvironmentsStopPayload projectEnvironmentsStopPayload() {
        return GitLabProjectEnvironmentsStopPayloadBuilder.builder().force(true).build();
    }

    public static GitLabProjectEnvironmentsStopStalePayload projectEnvironmentsStopStalePayload() {
        return GitLabProjectEnvironmentsStopStalePayloadBuilder.builder()
                .before(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectEnvironmentsUpdatePayload projectEnvironmentsUpdatePayload() {
        return GitLabProjectEnvironmentsUpdatePayloadBuilder.builder()
                .externalUrl("external_url")
                .tier(GitLabProjectEnvironmentsUpdateTier.PRODUCTION)
                .clusterAgentId(1L)
                .kubernetesNamespace("kubernetes_namespace")
                .fluxResourcePath("flux_resource_path")
                .description("description")
                .autoStopSetting(GitLabProjectEnvironmentsUpdateAutoStopSetting.ALWAYS)
                .build();
    }
}
