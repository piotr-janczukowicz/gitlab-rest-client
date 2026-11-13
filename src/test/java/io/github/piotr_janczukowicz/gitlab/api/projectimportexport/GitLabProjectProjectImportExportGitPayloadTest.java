package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectImportExportGitPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenImportUrlIsNullable() {
        final GitLabProjectProjectImportExportGitPayloadBuilder builder =
                GitLabProjectProjectImportExportGitPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload())
                        .importUrl(null);

        final GitLabProjectProjectImportExportGitPayload built = builder.build();

        assertThat(built.importUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlUserIsNullable() {
        final GitLabProjectProjectImportExportGitPayloadBuilder builder =
                GitLabProjectProjectImportExportGitPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload())
                        .importUrlUser(null);

        final GitLabProjectProjectImportExportGitPayload built = builder.build();

        assertThat(built.importUrlUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlPasswordIsNullable() {
        final GitLabProjectProjectImportExportGitPayloadBuilder builder =
                GitLabProjectProjectImportExportGitPayloadBuilder.builder(
                                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload())
                        .importUrlPassword(null);

        final GitLabProjectProjectImportExportGitPayload built = builder.build();

        assertThat(built.importUrlPassword()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectImportExportGitPayload value =
                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.importUrl()).isEqualTo("import_url");
            softly.assertThat(value.importUrlUser()).isEqualTo("import_url_user");
            softly.assertThat(value.importUrlPassword()).isEqualTo("import_url_password");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectImportExportGitPayload original =
                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload();

        final GitLabProjectProjectImportExportGitPayload rebuilt =
                GitLabProjectProjectImportExportGitPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenImportUrlPasswordIsACredential() {
        final GitLabProjectProjectImportExportGitPayload value =
                ProjectimportexportCatalogFixtures.projectProjectImportExportGitPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectImportExportGitPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("importUrl", "importUrlUser", "importUrlPassword");
    }
}
