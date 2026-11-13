package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

public final class TerraformmodulesCatalogFixtures {

    private TerraformmodulesCatalogFixtures() {}

    public static GitLabTerraformModuleVersion terraformModuleVersion() {
        return GitLabTerraformModuleVersionBuilder.builder()
                .name("name")
                .provider("provider")
                .providers("providers")
                .root("root")
                .source("source")
                .submodules("submodules")
                .version("version")
                .versions("versions")
                .build();
    }

    public static GitLabTerraformModuleVersions terraformModuleVersions() {
        return GitLabTerraformModuleVersionsBuilder.builder().modules("modules").build();
    }
}
