package io.github.piotr_janczukowicz.gitlab.api.analytics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsGroupActivityIssuesCountTest {

    @Test
    void constructor_shouldAcceptNull_whenIssuesCountIsNullable() {
        final GitLabAnalyticsGroupActivityIssuesCountBuilder builder =
                GitLabAnalyticsGroupActivityIssuesCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount())
                        .issuesCount(null);

        final GitLabAnalyticsGroupActivityIssuesCount built = builder.build();

        assertThat(built.issuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTooLargeIsNullable() {
        final GitLabAnalyticsGroupActivityIssuesCountBuilder builder =
                GitLabAnalyticsGroupActivityIssuesCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount())
                        .tooLarge(null);

        final GitLabAnalyticsGroupActivityIssuesCount built = builder.build();

        assertThat(built.tooLarge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsGroupActivityIssuesCount value =
                AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount();

        assertSoftly(softly -> {
            softly.assertThat(value.issuesCount()).isEqualTo(1);
            softly.assertThat(value.tooLarge()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsGroupActivityIssuesCount original =
                AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount();

        final GitLabAnalyticsGroupActivityIssuesCount rebuilt =
                GitLabAnalyticsGroupActivityIssuesCountBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsGroupActivityIssuesCount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("issuesCount", "tooLarge");
    }
}
