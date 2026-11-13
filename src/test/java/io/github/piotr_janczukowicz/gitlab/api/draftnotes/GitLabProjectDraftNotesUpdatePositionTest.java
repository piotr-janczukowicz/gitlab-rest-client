package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesUpdatePositionTest {

    @Test
    void constructor_shouldAcceptNull_whenBaseShaIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .baseSha(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.baseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartShaIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .startSha(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.startSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadShaIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .headSha(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.headSha()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPositionTypeIsNull() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .positionType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("positionType");
    }

    @Test
    void constructor_shouldAcceptNull_whenNewPathIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .newPath(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.newPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .newLine(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .oldPath(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .oldLine(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWidthIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .width(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.width()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeightIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .height(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.height()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenXIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .x(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.x()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .y(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.y()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineRangeIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionBuilder builder =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                        .lineRange(null);

        final GitLabProjectDraftNotesUpdatePosition built = builder.build();

        assertThat(built.lineRange()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesUpdatePosition value = DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition();

        assertSoftly(softly -> {
            softly.assertThat(value.baseSha()).isEqualTo("base_sha");
            softly.assertThat(value.startSha()).isEqualTo("start_sha");
            softly.assertThat(value.headSha()).isEqualTo("head_sha");
            softly.assertThat(value.positionType()).isEqualTo(GitLabProjectDraftNotesUpdatePositionType.TEXT);
            softly.assertThat(value.newPath()).isEqualTo("new_path");
            softly.assertThat(value.newLine()).isEqualTo(1);
            softly.assertThat(value.oldPath()).isEqualTo("old_path");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.width()).isEqualTo(1);
            softly.assertThat(value.height()).isEqualTo(1);
            softly.assertThat(value.x()).isEqualTo(1);
            softly.assertThat(value.y()).isEqualTo(1);
            softly.assertThat(value.lineRange())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesUpdatePosition original =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition();

        final GitLabProjectDraftNotesUpdatePosition rebuilt =
                GitLabProjectDraftNotesUpdatePositionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesUpdatePosition.class.getRecordComponents())
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
