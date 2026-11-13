package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobArtifactFileTest {

    @Test
    void constructor_shouldAcceptNull_whenFilenameIsNullable() {
        final GitLabCiJobArtifactFileBuilder builder = GitLabCiJobArtifactFileBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifactFile())
                .filename(null);

        final GitLabCiJobArtifactFile built = builder.build();

        assertThat(built.filename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabCiJobArtifactFileBuilder builder = GitLabCiJobArtifactFileBuilder.builder(
                        CommonCatalogFixtures.ciJobArtifactFile())
                .size(null);

        final GitLabCiJobArtifactFile built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobArtifactFile value = CommonCatalogFixtures.ciJobArtifactFile();

        assertSoftly(softly -> {
            softly.assertThat(value.filename()).isEqualTo("artifacts.zip");
            softly.assertThat(value.size()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobArtifactFile original = CommonCatalogFixtures.ciJobArtifactFile();

        final GitLabCiJobArtifactFile rebuilt =
                GitLabCiJobArtifactFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobArtifactFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filename", "size");
    }
}
