package io.github.piotr_janczukowicz.gitlab.api.goproxy;

public final class GoproxyCatalogFixtures {

    private GoproxyCatalogFixtures() {}

    public static GitLabGoModuleVersion goModuleVersion() {
        return GitLabGoModuleVersionBuilder.builder()
                .version("v1.0.0")
                .time("1617822312 -0600")
                .build();
    }
}
