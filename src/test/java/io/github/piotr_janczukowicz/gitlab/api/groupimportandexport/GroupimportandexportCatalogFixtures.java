package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

public final class GroupimportandexportCatalogFixtures {

    private GroupimportandexportCatalogFixtures() {}

    public static GitLabGroupGroupImportAndExportCreateExportRelationPayload
            groupGroupImportAndExportCreateExportRelationPayload() {
        return GitLabGroupGroupImportAndExportCreateExportRelationPayloadBuilder.builder()
                .batched(true)
                .build();
    }
}
