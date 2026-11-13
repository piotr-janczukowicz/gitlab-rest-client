package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitDiscussionCreatePositionLineRangeEndTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd())
                        .lineCode(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd())
                        .type(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd())
                        .oldLine(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd())
                        .newLine(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd value =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd original =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd();

        final GitLabProjectCommitDiscussionCreatePositionLineRangeEnd rebuilt =
                GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectCommitDiscussionCreatePositionLineRangeEnd.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
