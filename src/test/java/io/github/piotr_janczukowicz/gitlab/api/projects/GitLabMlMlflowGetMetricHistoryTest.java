package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowGetMetricHistoryTest {

    @Test
    void constructor_shouldAcceptNull_whenMetricsIsNullable() {
        final GitLabMlMlflowGetMetricHistoryBuilder builder = GitLabMlMlflowGetMetricHistoryBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowGetMetricHistory())
                .metrics(null);

        final GitLabMlMlflowGetMetricHistory built = builder.build();

        assertThat(built.metrics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextPageTokenIsNullable() {
        final GitLabMlMlflowGetMetricHistoryBuilder builder = GitLabMlMlflowGetMetricHistoryBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowGetMetricHistory())
                .nextPageToken(null);

        final GitLabMlMlflowGetMetricHistory built = builder.build();

        assertThat(built.nextPageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowGetMetricHistory value = ProjectsCatalogFixtures.mlMlflowGetMetricHistory();

        assertSoftly(softly -> {
            softly.assertThat(value.metrics()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowMetric()));
            softly.assertThat(value.nextPageToken()).isEqualTo("next_page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowGetMetricHistory original = ProjectsCatalogFixtures.mlMlflowGetMetricHistory();

        final GitLabMlMlflowGetMetricHistory rebuilt =
                GitLabMlMlflowGetMetricHistoryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenNextPageTokenIsACredential() {
        final GitLabMlMlflowGetMetricHistory value = ProjectsCatalogFixtures.mlMlflowGetMetricHistory();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowGetMetricHistory.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("metrics", "nextPageToken");
    }
}
