package io.github.piotr_janczukowicz.gitlab.api.dependencies;

public final class DependenciesCatalogFixtures {

    private DependenciesCatalogFixtures() {}

    public static GitLabDependency dependency() {
        return GitLabDependencyBuilder.builder()
                .name("name")
                .version("version")
                .packageManager("package_manager")
                .dependencyFilePath("dependency_file_path")
                .vulnerabilities(DependenciesCatalogFixtures.dependencyEntityVulnerabilityEntity())
                .licenses(DependenciesCatalogFixtures.dependencyEntityLicenseEntity())
                .malware(true)
                .build();
    }

    public static GitLabDependencyEntityLicenseEntity dependencyEntityLicenseEntity() {
        return GitLabDependencyEntityLicenseEntityBuilder.builder()
                .spdxIdentifier("spdx_identifier")
                .name("name")
                .url("url")
                .build();
    }

    public static GitLabDependencyEntityVulnerabilityEntity dependencyEntityVulnerabilityEntity() {
        return GitLabDependencyEntityVulnerabilityEntityBuilder.builder()
                .severity("severity")
                .id("id")
                .name("name")
                .url("url")
                .build();
    }
}
