package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupImportAndExportCreateExportRelationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBatchedIsNullable() {
        final GitLabGroupGroupImportAndExportCreateExportRelationPayloadBuilder builder =
                GitLabGroupGroupImportAndExportCreateExportRelationPayloadBuilder.builder(
                                GroupimportandexportCatalogFixtures
                                        .groupGroupImportAndExportCreateExportRelationPayload())
                        .batched(null);

        final GitLabGroupGroupImportAndExportCreateExportRelationPayload built = builder.build();

        assertThat(built.batched()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupImportAndExportCreateExportRelationPayload value =
                GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload();

        assertThat(value.batched()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupImportAndExportCreateExportRelationPayload original =
                GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload();

        final GitLabGroupGroupImportAndExportCreateExportRelationPayload rebuilt =
                GitLabGroupGroupImportAndExportCreateExportRelationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupImportAndExportCreateExportRelationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("batched");
    }
}
