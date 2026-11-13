package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRequestsDiscussionsPositionTest {

    @Test
    void constructor_shouldAcceptNull_whenBaseShaIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .baseSha(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.baseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartShaIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .startSha(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.startSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadShaIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .headSha(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.headSha()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPositionTypeIsNull() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .positionType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("positionType");
    }

    @Test
    void constructor_shouldAcceptNull_whenNewPathIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .newPath(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.newPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .newLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .oldPath(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .oldLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWidthIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .width(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.width()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeightIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .height(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.height()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenXIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .x(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.x()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .y(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.y()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineRangeIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                        .lineRange(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition built = builder.build();

        assertThat(built.lineRange()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition();

        assertSoftly(softly -> {
            softly.assertThat(value.baseSha()).isEqualTo("base_sha");
            softly.assertThat(value.startSha()).isEqualTo("start_sha");
            softly.assertThat(value.headSha()).isEqualTo("head_sha");
            softly.assertThat(value.positionType())
                    .isEqualTo(GitLabProjectDiscussionsCreateRequestsDiscussionsPositionType.TEXT);
            softly.assertThat(value.newPath()).isEqualTo("new_path");
            softly.assertThat(value.newLine()).isEqualTo(1);
            softly.assertThat(value.oldPath()).isEqualTo("old_path");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.width()).isEqualTo(1);
            softly.assertThat(value.height()).isEqualTo(1);
            softly.assertThat(value.x()).isEqualTo(1);
            softly.assertThat(value.y()).isEqualTo(1);
            softly.assertThat(value.lineRange())
                    .isEqualTo(
                            DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRange());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition();

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPosition rebuilt =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRequestsDiscussionsPosition.class.getRecordComponents())
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
