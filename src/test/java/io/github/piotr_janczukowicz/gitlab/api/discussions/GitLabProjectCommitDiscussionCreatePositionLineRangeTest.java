package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitDiscussionCreatePositionLineRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenStartIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange())
                        .start(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRange built = builder.build();

        assertThat(built.start()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndIsNullable() {
        final GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder builder =
                GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange())
                        .end(null);

        final GitLabProjectCommitDiscussionCreatePositionLineRange built = builder.build();

        assertThat(built.end()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitDiscussionCreatePositionLineRange value =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange();

        assertSoftly(softly -> {
            softly.assertThat(value.start())
                    .isEqualTo(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart());
            softly.assertThat(value.end())
                    .isEqualTo(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitDiscussionCreatePositionLineRange original =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange();

        final GitLabProjectCommitDiscussionCreatePositionLineRange rebuilt =
                GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectCommitDiscussionCreatePositionLineRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("start", "end");
    }
}
