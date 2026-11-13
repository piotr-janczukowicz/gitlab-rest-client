package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload())
                        .key(null);

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload())
                        .value(null);

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimestampIsNullable() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload())
                        .timestamp(null);

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.timestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepIsNullable() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload())
                        .step(null);

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.step()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo(1.5);
            softly.assertThat(value.timestamp()).isEqualTo(1);
            softly.assertThat(value.step()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogMetricMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId", "key", "value", "timestamp", "step");
    }
}
