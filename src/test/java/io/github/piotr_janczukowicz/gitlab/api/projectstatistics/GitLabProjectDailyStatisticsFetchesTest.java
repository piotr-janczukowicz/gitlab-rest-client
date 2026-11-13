package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDailyStatisticsFetchesTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalIsNullable() {
        final GitLabProjectDailyStatisticsFetchesBuilder builder = GitLabProjectDailyStatisticsFetchesBuilder.builder(
                        ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches())
                .total(null);

        final GitLabProjectDailyStatisticsFetches built = builder.build();

        assertThat(built.total()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDaysIsNullable() {
        final GitLabProjectDailyStatisticsFetchesBuilder builder = GitLabProjectDailyStatisticsFetchesBuilder.builder(
                        ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches())
                .days(null);

        final GitLabProjectDailyStatisticsFetches built = builder.build();

        assertThat(built.days()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDailyStatisticsFetches value =
                ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches();

        assertSoftly(softly -> {
            softly.assertThat(value.total()).isEqualTo(1);
            softly.assertThat(value.days()).isEqualTo(List.of(CommonCatalogFixtures.projectDailyFetches()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDailyStatisticsFetches original =
                ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches();

        final GitLabProjectDailyStatisticsFetches rebuilt =
                GitLabProjectDailyStatisticsFetchesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDailyStatisticsFetches.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("total", "days");
    }
}
