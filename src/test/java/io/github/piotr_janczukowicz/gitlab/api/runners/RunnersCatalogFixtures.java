package io.github.piotr_janczukowicz.gitlab.api.runners;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class RunnersCatalogFixtures {

    private RunnersCatalogFixtures() {}

    public static GitLabCiJobBasicWithProject ciJobBasicWithProject() {
        return GitLabCiJobBasicWithProjectBuilder.builder()
                .id(1L)
                .status("waiting_for_resource")
                .stage("deploy")
                .name("deploy_to_production")
                .ref("main")
                .tag(true)
                .coverage(1.5)
                .allowFailure(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .erasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1.5)
                .queuedDuration(1.5)
                .user(CommonCatalogFixtures.user())
                .commit(CommonCatalogFixtures.commit())
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .failureReason("script_failure")
                .webUrl("https://example.com/foo/bar/-/jobs/1")
                .project(CommonCatalogFixtures.projectIdentity())
                .build();
    }

    public static GitLabCiJobRouterDiscoveryInformation ciJobRouterDiscoveryInformation() {
        return GitLabCiJobRouterDiscoveryInformationBuilder.builder()
                .serverUrl("wss://kas.example.com")
                .build();
    }

    public static GitLabCiRunnerDetails ciRunnerDetails() {
        return GitLabCiRunnerDetailsBuilder.builder()
                .id(1L)
                .description("test-1-20150125")
                .ipAddress("127.0.0.1")
                .active(true)
                .paused(true)
                .isShared(true)
                .runnerType(GitLabCiRunnerDetailsRunnerType.INSTANCE_TYPE)
                .name("test")
                .online(true)
                .createdBy(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .status("online")
                .jobExecutionStatus(GitLabCiRunnerDetailsJobExecutionStatus.ACTIVE)
                .uuid("01966aa0-f383-7a6b-b694-cd4f2f96cca1")
                .tagList("tag_list")
                .runUntagged("run_untagged")
                .locked("locked")
                .maximumTimeout("maximum_timeout")
                .accessLevel("access_level")
                .tokenExpiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .version("version")
                .revision("revision")
                .platform("platform")
                .architecture("architecture")
                .contactedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .maintenanceNote("maintenance_note")
                .projects(List.of(CommonCatalogFixtures.basicProjectDetails()))
                .groups(List.of(CommonCatalogFixtures.basicGroupDetails()))
                .build();
    }

    public static GitLabInstanceRunnersCreateInfo instanceRunnersCreateInfo() {
        return GitLabInstanceRunnersCreateInfoBuilder.builder()
                .name("name")
                .version("version")
                .revision("revision")
                .platform("platform")
                .architecture("architecture")
                .build();
    }

    public static GitLabInstanceRunnersCreatePayload instanceRunnersCreatePayload() {
        return GitLabInstanceRunnersCreatePayloadBuilder.builder()
                .token("token")
                .description("description")
                .maintainerNote("maintainer_note")
                .maintenanceNote("maintenance_note")
                .info(RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .active(true)
                .paused(true)
                .locked(true)
                .accessLevel(GitLabInstanceRunnersCreateAccessLevel.NOT_PROTECTED)
                .runUntagged(true)
                .tagList(List.of("tag_list"))
                .maximumTimeout(1)
                .build();
    }

    public static GitLabInstanceRunnersResetAuthenticationTokenPayload
            instanceRunnersResetAuthenticationTokenPayload() {
        return GitLabInstanceRunnersResetAuthenticationTokenPayloadBuilder.builder()
                .token("token")
                .build();
    }

    public static GitLabInstanceRunnersUpdatePayload instanceRunnersUpdatePayload() {
        return GitLabInstanceRunnersUpdatePayloadBuilder.builder()
                .description("description")
                .active(true)
                .paused(true)
                .tagList(List.of("tag_list"))
                .runUntagged(true)
                .locked(true)
                .accessLevel(GitLabInstanceRunnersUpdateAccessLevel.NOT_PROTECTED)
                .maximumTimeout(1)
                .maintenanceNote("maintenance_note")
                .build();
    }

    public static GitLabInstanceRunnersVerifyPayload instanceRunnersVerifyPayload() {
        return GitLabInstanceRunnersVerifyPayloadBuilder.builder()
                .token("token")
                .systemId("system_id")
                .build();
    }

    public static GitLabProjectRunnersCreatePayload projectRunnersCreatePayload() {
        return GitLabProjectRunnersCreatePayloadBuilder.builder().runnerId(1L).build();
    }
}
