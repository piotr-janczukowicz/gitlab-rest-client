package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitDiscussionCreatePositionLineRangeStartTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart())
                        .lineCode(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart())
                        .type(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart())
                        .oldLine(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart())
                        .newLine(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart value =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart original =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart();

        final GitLabProjectCommitDiscussionCreatePositionLineRangeStart rebuilt =
                GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectCommitDiscussionCreatePositionLineRangeStart.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
