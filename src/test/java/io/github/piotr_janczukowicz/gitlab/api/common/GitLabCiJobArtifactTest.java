package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobArtifactTest {

    @Test
    void constructor_shouldAcceptNull_whenFileTypeIsNullable() {
        final GitLabCiJobArtifactBuilder builder = GitLabCiJobArtifactBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifact())
                .fileType(null);

        final GitLabCiJobArtifact built = builder.build();

        assertThat(built.fileType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabCiJobArtifactBuilder builder = GitLabCiJobArtifactBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifact())
                .size(null);

        final GitLabCiJobArtifact built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilenameIsNullable() {
        final GitLabCiJobArtifactBuilder builder = GitLabCiJobArtifactBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifact())
                .filename(null);

        final GitLabCiJobArtifact built = builder.build();

        assertThat(built.filename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileFormatIsNullable() {
        final GitLabCiJobArtifactBuilder builder = GitLabCiJobArtifactBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifact())
                .fileFormat(null);

        final GitLabCiJobArtifact built = builder.build();

        assertThat(built.fileFormat()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobArtifact value = CommonCatalogFixtures.ciJobArtifact();

        assertSoftly(softly -> {
            softly.assertThat(value.fileType()).isEqualTo(GitLabCiJobArtifactFileType.ARCHIVE);
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.filename()).isEqualTo("artifacts.zip");
            softly.assertThat(value.fileFormat()).isEqualTo(GitLabCiJobArtifactFileFormat.RAW);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobArtifact original = CommonCatalogFixtures.ciJobArtifact();

        final GitLabCiJobArtifact rebuilt =
                GitLabCiJobArtifactBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobArtifact.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fileType", "size", "filename", "fileFormat");
    }
}
