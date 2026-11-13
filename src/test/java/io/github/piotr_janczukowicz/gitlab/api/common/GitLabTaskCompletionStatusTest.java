package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTaskCompletionStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabTaskCompletionStatusBuilder builder = GitLabTaskCompletionStatusBuilder.builder(
                        CommonCatalogFixtures.taskCompletionStatus())
                .count(null);

        final GitLabTaskCompletionStatus built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompletedCountIsNullable() {
        final GitLabTaskCompletionStatusBuilder builder = GitLabTaskCompletionStatusBuilder.builder(
                        CommonCatalogFixtures.taskCompletionStatus())
                .completedCount(null);

        final GitLabTaskCompletionStatus built = builder.build();

        assertThat(built.completedCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTaskCompletionStatus value = CommonCatalogFixtures.taskCompletionStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.completedCount()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTaskCompletionStatus original = CommonCatalogFixtures.taskCompletionStatus();

        final GitLabTaskCompletionStatus rebuilt =
                GitLabTaskCompletionStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTaskCompletionStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count", "completedCount");
    }
}
