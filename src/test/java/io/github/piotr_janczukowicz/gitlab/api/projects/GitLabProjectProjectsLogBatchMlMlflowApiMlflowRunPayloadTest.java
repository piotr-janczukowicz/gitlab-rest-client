package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetricsIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .metrics(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.metrics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParamsIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .params(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.params()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .tags(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.metrics())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric()));
            softly.assertThat(value.params())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam()));
            softly.assertThat(value.tags())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenMetricsSourceChangesLater() {
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric> source =
                new ArrayList<>(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunMetric()));
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .metrics(source)
                        .build();
        source.clear();

        assertThat(built.metrics()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenMetricsIsRead() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload();
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunMetric> values = built.metrics();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenParamsSourceChangesLater() {
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam> source =
                new ArrayList<>(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam()));
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .params(source)
                        .build();
        source.clear();

        assertThat(built.params()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenParamsIsRead() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload();
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam> values = built.params();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagsSourceChangesLater() {
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag> source =
                new ArrayList<>(List.of(ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag()));
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload())
                        .tags(source)
                        .build();
        source.clear();

        assertThat(built.tags()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagsIsRead() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload();
        final List<GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag> values = built.tags();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId", "metrics", "params", "tags");
    }
}
