package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

public final class ProjectrelationsexportCatalogFixtures {

    private ProjectrelationsexportCatalogFixtures() {}

    public static GitLabProjectProjectRelationsExportCreatePayload projectProjectRelationsExportCreatePayload() {
        return GitLabProjectProjectRelationsExportCreatePayloadBuilder.builder()
                .batched(true)
                .build();
    }
}
