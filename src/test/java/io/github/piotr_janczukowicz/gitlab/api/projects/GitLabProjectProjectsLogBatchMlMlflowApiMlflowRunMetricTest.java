package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric())
                        .key(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric())
                        .value(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimestampIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric())
                        .timestamp(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric built = builder.build();

        assertThat(built.timestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric())
                        .step(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric built = builder.build();

        assertThat(built.step()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric value =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo(1.5);
            softly.assertThat(value.timestamp()).isEqualTo(1);
            softly.assertThat(value.step()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric original =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric();

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric rebuilt =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetricBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value", "timestamp", "step");
    }
}
