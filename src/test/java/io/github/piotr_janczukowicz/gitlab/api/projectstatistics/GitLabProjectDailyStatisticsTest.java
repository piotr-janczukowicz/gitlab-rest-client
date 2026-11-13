package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDailyStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenFetchesIsNullable() {
        final GitLabProjectDailyStatisticsBuilder builder = GitLabProjectDailyStatisticsBuilder.builder(
                        ProjectstatisticsCatalogFixtures.projectDailyStatistics())
                .fetches(null);

        final GitLabProjectDailyStatistics built = builder.build();

        assertThat(built.fetches()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDailyStatistics value = ProjectstatisticsCatalogFixtures.projectDailyStatistics();

        assertThat(value.fetches()).isEqualTo(ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDailyStatistics original = ProjectstatisticsCatalogFixtures.projectDailyStatistics();

        final GitLabProjectDailyStatistics rebuilt =
                GitLabProjectDailyStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDailyStatistics.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fetches");
    }
}
