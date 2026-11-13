package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .experimentId(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartTimeIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .startTime(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.startTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .userId(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .tags(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunNameIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .runName(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.experimentId()).isEqualTo(1L);
            softly.assertThat(value.startTime()).isEqualTo(1);
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.tags()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.runName()).isEqualTo("run_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagsSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload())
                        .tags(source)
                        .build();
        source.clear();

        assertThat(built.tags()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagsIsRead() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload();
        final List<Map<String, Object>> values = built.tags();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId", "startTime", "userId", "tags", "runName");
    }
}
