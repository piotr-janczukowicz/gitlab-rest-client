package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitDiscussionCreatePositionTest {

    @Test
    void constructor_shouldAcceptNull_whenBaseShaIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .baseSha(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.baseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartShaIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .startSha(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.startSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadShaIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .headSha(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.headSha()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPositionTypeIsNull() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .positionType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("positionType");
    }

    @Test
    void constructor_shouldAcceptNull_whenNewPathIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .newPath(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.newPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .newLine(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .oldPath(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .oldLine(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWidthIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .width(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.width()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeightIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .height(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.height()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenXIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .x(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.x()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .y(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.y()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineRangeIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                        .lineRange(null);

        final GitLabProjectCommitDiscussionCreatePosition built = builder.build();

        assertThat(built.lineRange()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitDiscussionCreatePosition value =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition();

        assertSoftly(softly -> {
            softly.assertThat(value.baseSha()).isEqualTo("base_sha");
            softly.assertThat(value.startSha()).isEqualTo("start_sha");
            softly.assertThat(value.headSha()).isEqualTo("head_sha");
            softly.assertThat(value.positionType()).isEqualTo(GitLabProjectCommitDiscussionCreatePositionType.TEXT);
            softly.assertThat(value.newPath()).isEqualTo("new_path");
            softly.assertThat(value.newLine()).isEqualTo(1);
            softly.assertThat(value.oldPath()).isEqualTo("old_path");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.width()).isEqualTo(1);
            softly.assertThat(value.height()).isEqualTo(1);
            softly.assertThat(value.x()).isEqualTo(1);
            softly.assertThat(value.y()).isEqualTo(1);
            softly.assertThat(value.lineRange())
                    .isEqualTo(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitDiscussionCreatePosition original =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition();

        final GitLabProjectCommitDiscussionCreatePosition rebuilt =
                GitLabProjectCommitDiscussionCreatePositionBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitDiscussionCreatePosition.class.getRecordComponents())
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
