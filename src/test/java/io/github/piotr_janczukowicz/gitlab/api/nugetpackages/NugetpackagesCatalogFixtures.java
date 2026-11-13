package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import java.util.List;

public final class NugetpackagesCatalogFixtures {

    private NugetpackagesCatalogFixtures() {}

    public static GitLabNugetPackagesVersions nugetPackagesVersions() {
        return GitLabNugetPackagesVersionsBuilder.builder()
                .versions(List.of("1.3.0.17"))
                .build();
    }
}
