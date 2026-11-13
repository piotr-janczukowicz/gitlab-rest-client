package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class ProjectclustersCatalogFixtures {

    private ProjectclustersCatalogFixtures() {}

    public static GitLabClusterProject clusterProject() {
        return GitLabClusterProjectBuilder.builder()
                .id("id")
                .name("name")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .domain("domain")
                .enabled("enabled")
                .managed("managed")
                .providerType("provider_type")
                .platformType("platform_type")
                .environmentScope("environment_scope")
                .clusterType("cluster_type")
                .namespacePerEnvironment("namespace_per_environment")
                .user(CommonCatalogFixtures.userBasic())
                .platformKubernetes(CommonCatalogFixtures.platformKubernetes())
                .providerGcp(CommonCatalogFixtures.providerGcp())
                .managementProject(CommonCatalogFixtures.projectIdentity())
                .project(CommonCatalogFixtures.basicProjectDetails())
                .build();
    }

    public static GitLabProjectClusterUserCreatePayload projectClusterUserCreatePayload() {
        return GitLabProjectClusterUserCreatePayloadBuilder.builder()
                .name("name")
                .enabled(true)
                .domain("domain")
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .managementProjectId(1L)
                .managed(true)
                .platformKubernetesAttributes(
                        ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                .build();
    }

    public static GitLabProjectClusterUserCreatePlatformKubernetesAttributes
            projectClusterUserCreatePlatformKubernetesAttributes() {
        return GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .authorizationType(
                        GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType
                                .UNKNOWN_AUTHORIZATION)
                .build();
    }

    public static GitLabProjectProjectClustersUpdatePayload projectProjectClustersUpdatePayload() {
        return GitLabProjectProjectClustersUpdatePayloadBuilder.builder()
                .name("name")
                .domain("domain")
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .managementProjectId(1L)
                .enabled(true)
                .managed(true)
                .platformKubernetesAttributes(
                        ProjectclustersCatalogFixtures.projectProjectClustersUpdatePlatformKubernetesAttributes())
                .build();
    }

    public static GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes
            projectProjectClustersUpdatePlatformKubernetesAttributes() {
        return GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .build();
    }
}
