package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectImportExportCreateProjectUploadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectProjectImportExportCreateProjectUploadBuilder builder =
                GitLabProjectProjectImportExportCreateProjectUploadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload())
                        .url(null);

        final GitLabProjectProjectImportExportCreateProjectUpload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpMethodIsNullable() {
        final GitLabProjectProjectImportExportCreateProjectUploadBuilder builder =
                GitLabProjectProjectImportExportCreateProjectUploadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload())
                        .httpMethod(null);

        final GitLabProjectProjectImportExportCreateProjectUpload built = builder.build();

        assertThat(built.httpMethod()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectImportExportCreateProjectUpload value =
                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.httpMethod())
                    .isEqualTo(GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.PUT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectImportExportCreateProjectUpload original =
                ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload();

        final GitLabProjectProjectImportExportCreateProjectUpload rebuilt =
                GitLabProjectProjectImportExportCreateProjectUploadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectImportExportCreateProjectUpload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "httpMethod");
    }
}
