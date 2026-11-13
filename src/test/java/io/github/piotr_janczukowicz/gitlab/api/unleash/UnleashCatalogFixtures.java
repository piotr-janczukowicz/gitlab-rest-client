package io.github.piotr_janczukowicz.gitlab.api.unleash;

public final class UnleashCatalogFixtures {

    private UnleashCatalogFixtures() {}

    public static GitLabUnleashCreateClientMetricPayload unleashCreateClientMetricPayload() {
        return GitLabUnleashCreateClientMetricPayloadBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();
    }

    public static GitLabUnleashRegisterClientPayload unleashRegisterClientPayload() {
        return GitLabUnleashRegisterClientPayloadBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();
    }
}
