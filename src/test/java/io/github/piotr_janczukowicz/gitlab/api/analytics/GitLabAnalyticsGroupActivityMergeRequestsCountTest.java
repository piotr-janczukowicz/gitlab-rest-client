package io.github.piotr_janczukowicz.gitlab.api.analytics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsGroupActivityMergeRequestsCountTest {

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabAnalyticsGroupActivityMergeRequestsCountBuilder builder =
                GitLabAnalyticsGroupActivityMergeRequestsCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount())
                        .mergeRequestsCount(null);

        final GitLabAnalyticsGroupActivityMergeRequestsCount built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTooLargeIsNullable() {
        final GitLabAnalyticsGroupActivityMergeRequestsCountBuilder builder =
                GitLabAnalyticsGroupActivityMergeRequestsCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount())
                        .tooLarge(null);

        final GitLabAnalyticsGroupActivityMergeRequestsCount built = builder.build();

        assertThat(built.tooLarge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsGroupActivityMergeRequestsCount value =
                AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount();

        assertSoftly(softly -> {
            softly.assertThat(value.mergeRequestsCount()).isEqualTo(1);
            softly.assertThat(value.tooLarge()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsGroupActivityMergeRequestsCount original =
                AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount();

        final GitLabAnalyticsGroupActivityMergeRequestsCount rebuilt =
                GitLabAnalyticsGroupActivityMergeRequestsCountBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsGroupActivityMergeRequestsCount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("mergeRequestsCount", "tooLarge");
    }
}
