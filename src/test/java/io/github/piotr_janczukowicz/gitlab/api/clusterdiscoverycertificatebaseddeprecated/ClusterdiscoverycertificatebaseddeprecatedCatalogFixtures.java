package io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated;

import java.util.Map;

public final class ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures {

    private ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures() {}

    public static GitLabDiscoveredClusters discoveredClusters() {
        return GitLabDiscoveredClustersBuilder.builder()
                .groups(Map.of("key", "value"))
                .projects(Map.of("key", "value"))
                .build();
    }
}
