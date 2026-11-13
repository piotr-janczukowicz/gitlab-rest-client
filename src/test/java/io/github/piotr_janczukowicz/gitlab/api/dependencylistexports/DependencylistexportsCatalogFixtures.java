package io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;

public final class DependencylistexportsCatalogFixtures {

    private DependencylistexportsCatalogFixtures() {}

    public static GitLabDependencyListExportsCreatePayload dependencyListExportsCreatePayload() {
        return GitLabDependencyListExportsCreatePayloadBuilder.builder()
                .sendEmail(true)
                .exportType(GitLabDependencyListExportsCreateExportType.SBOM)
                .build();
    }
}
