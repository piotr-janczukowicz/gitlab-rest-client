package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

import java.util.Map;

public final class NpmrepositoryCatalogFixtures {

    private NpmrepositoryCatalogFixtures() {}

    public static GitLabNpmPackage npmPackage() {
        return GitLabNpmPackageBuilder.builder()
                .name("my_package")
                .versions(Map.of("key", "value"))
                .distTags(Map.of("key", "value"))
                .build();
    }

    public static GitLabNpmPackageTag npmPackageTag() {
        return GitLabNpmPackageTagBuilder.builder()
                .distTags(Map.of("key", "value"))
                .build();
    }
}
