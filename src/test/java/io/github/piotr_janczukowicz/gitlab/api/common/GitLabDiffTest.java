package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiffTest {

    @Test
    void constructor_shouldAcceptNull_whenDiffIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).diff(null);

        final GitLabDiff built = builder.build();

        assertThat(built.diff()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCollapsedIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).collapsed(null);

        final GitLabDiff built = builder.build();

        assertThat(built.collapsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTooLargeIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).tooLarge(null);

        final GitLabDiff built = builder.build();

        assertThat(built.tooLarge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewPathIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).newPath(null);

        final GitLabDiff built = builder.build();

        assertThat(built.newPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).oldPath(null);

        final GitLabDiff built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAModeIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).aMode(null);

        final GitLabDiff built = builder.build();

        assertThat(built.aMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBModeIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).bMode(null);

        final GitLabDiff built = builder.build();

        assertThat(built.bMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewFileIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).newFile(null);

        final GitLabDiff built = builder.build();

        assertThat(built.newFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenamedFileIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).renamedFile(null);

        final GitLabDiff built = builder.build();

        assertThat(built.renamedFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletedFileIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).deletedFile(null);

        final GitLabDiff built = builder.build();

        assertThat(built.deletedFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGeneratedFileIsNullable() {
        final GitLabDiffBuilder builder =
                GitLabDiffBuilder.builder(CommonCatalogFixtures.diff()).generatedFile(null);

        final GitLabDiff built = builder.build();

        assertThat(built.generatedFile()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDiff value = CommonCatalogFixtures.diff();

        assertSoftly(softly -> {
            softly.assertThat(value.diff()).isEqualTo("@@ -71,6 +71,8 @@\\n...");
            softly.assertThat(value.collapsed()).isEqualTo(true);
            softly.assertThat(value.tooLarge()).isEqualTo(true);
            softly.assertThat(value.newPath()).isEqualTo("doc/update/5.4-to-6.0.md");
            softly.assertThat(value.oldPath()).isEqualTo("doc/update/5.4-to-6.0.md");
            softly.assertThat(value.aMode()).isEqualTo("100755");
            softly.assertThat(value.bMode()).isEqualTo("100644");
            softly.assertThat(value.newFile()).isEqualTo(true);
            softly.assertThat(value.renamedFile()).isEqualTo(true);
            softly.assertThat(value.deletedFile()).isEqualTo(true);
            softly.assertThat(value.generatedFile()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDiff original = CommonCatalogFixtures.diff();

        final GitLabDiff rebuilt = GitLabDiffBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDiff.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "diff",
                        "collapsed",
                        "tooLarge",
                        "newPath",
                        "oldPath",
                        "aMode",
                        "bMode",
                        "newFile",
                        "renamedFile",
                        "deletedFile",
                        "generatedFile");
    }
}
