package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDailyFetchesTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabProjectDailyFetchesBuilder builder = GitLabProjectDailyFetchesBuilder.builder(
                        CommonCatalogFixtures.projectDailyFetches())
                .count(null);

        final GitLabProjectDailyFetches built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDateIsNullable() {
        final GitLabProjectDailyFetchesBuilder builder = GitLabProjectDailyFetchesBuilder.builder(
                        CommonCatalogFixtures.projectDailyFetches())
                .date(null);

        final GitLabProjectDailyFetches built = builder.build();

        assertThat(built.date()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDailyFetches value = CommonCatalogFixtures.projectDailyFetches();

        assertSoftly(softly -> {
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.date()).isEqualTo(LocalDate.parse("2026-01-01"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDailyFetches original = CommonCatalogFixtures.projectDailyFetches();

        final GitLabProjectDailyFetches rebuilt =
                GitLabProjectDailyFetchesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDailyFetches.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count", "date");
    }
}
