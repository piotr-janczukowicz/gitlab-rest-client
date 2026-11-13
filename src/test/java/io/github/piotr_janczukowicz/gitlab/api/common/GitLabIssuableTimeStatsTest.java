package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssuableTimeStatsTest {

    @Test
    void constructor_shouldAcceptNull_whenTimeEstimateIsNullable() {
        final GitLabIssuableTimeStatsBuilder builder = GitLabIssuableTimeStatsBuilder.builder(
                        CommonCatalogFixtures.issuableTimeStats())
                .timeEstimate(null);

        final GitLabIssuableTimeStats built = builder.build();

        assertThat(built.timeEstimate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalTimeSpentIsNullable() {
        final GitLabIssuableTimeStatsBuilder builder = GitLabIssuableTimeStatsBuilder.builder(
                        CommonCatalogFixtures.issuableTimeStats())
                .totalTimeSpent(null);

        final GitLabIssuableTimeStats built = builder.build();

        assertThat(built.totalTimeSpent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanTimeEstimateIsNullable() {
        final GitLabIssuableTimeStatsBuilder builder = GitLabIssuableTimeStatsBuilder.builder(
                        CommonCatalogFixtures.issuableTimeStats())
                .humanTimeEstimate(null);

        final GitLabIssuableTimeStats built = builder.build();

        assertThat(built.humanTimeEstimate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanTotalTimeSpentIsNullable() {
        final GitLabIssuableTimeStatsBuilder builder = GitLabIssuableTimeStatsBuilder.builder(
                        CommonCatalogFixtures.issuableTimeStats())
                .humanTotalTimeSpent(null);

        final GitLabIssuableTimeStats built = builder.build();

        assertThat(built.humanTotalTimeSpent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssuableTimeStats value = CommonCatalogFixtures.issuableTimeStats();

        assertSoftly(softly -> {
            softly.assertThat(value.timeEstimate()).isEqualTo(1);
            softly.assertThat(value.totalTimeSpent()).isEqualTo(1);
            softly.assertThat(value.humanTimeEstimate()).isEqualTo("3h 30m");
            softly.assertThat(value.humanTotalTimeSpent()).isEqualTo("1h");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssuableTimeStats original = CommonCatalogFixtures.issuableTimeStats();

        final GitLabIssuableTimeStats rebuilt =
                GitLabIssuableTimeStatsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssuableTimeStats.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("timeEstimate", "totalTimeSpent", "humanTimeEstimate", "humanTotalTimeSpent");
    }
}
