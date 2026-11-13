package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

public final class InstanceclustersCatalogFixtures {

    private InstanceclustersCatalogFixtures() {}

    public static GitLabInstanceClustersAddPayload instanceClustersAddPayload() {
        return GitLabInstanceClustersAddPayloadBuilder.builder()
                .name("name")
                .enabled(true)
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .domain("domain")
                .managementProjectId(1L)
                .managed(true)
                .platformKubernetesAttributes(
                        InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                .build();
    }

    public static GitLabInstanceClustersAddPlatformKubernetesAttributes
            instanceClustersAddPlatformKubernetesAttributes() {
        return GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .authorizationType(
                        GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.UNKNOWN_AUTHORIZATION)
                .build();
    }

    public static GitLabInstanceClustersUpdatePayload instanceClustersUpdatePayload() {
        return GitLabInstanceClustersUpdatePayloadBuilder.builder()
                .name("name")
                .enabled(true)
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .domain("domain")
                .managementProjectId(1L)
                .managed(true)
                .platformKubernetesAttributes(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes())
                .build();
    }

    public static GitLabInstanceClustersUpdatePlatformKubernetesAttributes
            instanceClustersUpdatePlatformKubernetesAttributes() {
        return GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .build();
    }
}
