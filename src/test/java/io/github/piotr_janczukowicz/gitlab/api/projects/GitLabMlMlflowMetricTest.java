package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowMetricTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabMlMlflowMetricBuilder builder = GitLabMlMlflowMetricBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowMetric())
                .key(null);

        final GitLabMlMlflowMetric built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabMlMlflowMetricBuilder builder = GitLabMlMlflowMetricBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowMetric())
                .value(null);

        final GitLabMlMlflowMetric built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimestampIsNullable() {
        final GitLabMlMlflowMetricBuilder builder = GitLabMlMlflowMetricBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowMetric())
                .timestamp(null);

        final GitLabMlMlflowMetric built = builder.build();

        assertThat(built.timestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepIsNullable() {
        final GitLabMlMlflowMetricBuilder builder = GitLabMlMlflowMetricBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowMetric())
                .step(null);

        final GitLabMlMlflowMetric built = builder.build();

        assertThat(built.step()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowMetric value = ProjectsCatalogFixtures.mlMlflowMetric();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo(1.5);
            softly.assertThat(value.timestamp()).isEqualTo(1);
            softly.assertThat(value.step()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowMetric original = ProjectsCatalogFixtures.mlMlflowMetric();

        final GitLabMlMlflowMetric rebuilt =
                GitLabMlMlflowMetricBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowMetric.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value", "timestamp", "step");
    }
}
