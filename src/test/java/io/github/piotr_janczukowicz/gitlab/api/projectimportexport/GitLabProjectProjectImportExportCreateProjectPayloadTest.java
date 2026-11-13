package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectImportExportCreateProjectPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectImportExportCreateProjectPayloadBuilder builder =
                GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload())
                        .description(null);

        final GitLabProjectProjectImportExportCreateProjectPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadIsNullable() {
        final GitLabProjectProjectImportExportCreateProjectPayloadBuilder builder =
                GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload())
                        .upload(null);

        final GitLabProjectProjectImportExportCreateProjectPayload built = builder.build();

        assertThat(built.upload()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludedRelationsIsNullable() {
        final GitLabProjectProjectImportExportCreateProjectPayloadBuilder builder =
                GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload())
                        .excludedRelations(null);

        final GitLabProjectProjectImportExportCreateProjectPayload built = builder.build();

        assertThat(built.excludedRelations()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectImportExportCreateProjectPayload value =
                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.upload())
                    .isEqualTo(ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload());
            softly.assertThat(value.excludedRelations()).isEqualTo(List.of("excluded_relations"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectImportExportCreateProjectPayload original =
                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload();

        final GitLabProjectProjectImportExportCreateProjectPayload rebuilt =
                GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenExcludedRelationsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("excluded_relations"));
        final GitLabProjectProjectImportExportCreateProjectPayload built =
                GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload())
                        .excludedRelations(source)
                        .build();
        source.clear();

        assertThat(built.excludedRelations()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenExcludedRelationsIsRead() {
        final GitLabProjectProjectImportExportCreateProjectPayload built =
                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectPayload();
        final List<String> values = built.excludedRelations();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectImportExportCreateProjectPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "upload", "excludedRelations");
    }
}
