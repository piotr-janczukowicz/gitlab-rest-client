package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesCreatePositionTest {

    @Test
    void constructor_shouldAcceptNull_whenBaseShaIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .baseSha(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.baseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartShaIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .startSha(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.startSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadShaIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .headSha(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.headSha()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPositionTypeIsNull() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .positionType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("positionType");
    }

    @Test
    void constructor_shouldAcceptNull_whenNewPathIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .newPath(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.newPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .newLine(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .oldPath(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .oldLine(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWidthIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .width(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.width()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeightIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .height(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.height()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenXIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .x(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.x()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .y(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.y()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineRangeIsNullable() {
        final GitLabProjectDraftNotesCreatePositionBuilder builder =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                        .lineRange(null);

        final GitLabProjectDraftNotesCreatePosition built = builder.build();

        assertThat(built.lineRange()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesCreatePosition value = DraftnotesCatalogFixtures.projectDraftNotesCreatePosition();

        assertSoftly(softly -> {
            softly.assertThat(value.baseSha()).isEqualTo("base_sha");
            softly.assertThat(value.startSha()).isEqualTo("start_sha");
            softly.assertThat(value.headSha()).isEqualTo("head_sha");
            softly.assertThat(value.positionType()).isEqualTo(GitLabProjectDraftNotesCreatePositionType.TEXT);
            softly.assertThat(value.newPath()).isEqualTo("new_path");
            softly.assertThat(value.newLine()).isEqualTo(1);
            softly.assertThat(value.oldPath()).isEqualTo("old_path");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.width()).isEqualTo(1);
            softly.assertThat(value.height()).isEqualTo(1);
            softly.assertThat(value.x()).isEqualTo(1);
            softly.assertThat(value.y()).isEqualTo(1);
            softly.assertThat(value.lineRange())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesCreatePosition original =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePosition();

        final GitLabProjectDraftNotesCreatePosition rebuilt =
                GitLabProjectDraftNotesCreatePositionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesCreatePosition.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "baseSha",
                        "startSha",
                        "headSha",
                        "positionType",
                        "newPath",
                        "newLine",
                        "oldPath",
                        "oldLine",
                        "width",
                        "height",
                        "x",
                        "y",
                        "lineRange");
    }
}
