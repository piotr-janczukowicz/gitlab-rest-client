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
class GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload())
                        .name(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload())
                        .tags(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactLocationIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload())
                        .artifactLocation(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.artifactLocation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.tags()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.artifactLocation()).isEqualTo("artifact_location");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload();

        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload rebuilt =
                GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagsSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload built =
                GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload())
                        .tags(source)
                        .build();
        source.clear();

        assertThat(built.tags()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagsIsRead() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload built =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload();
        final List<Map<String, Object>> values = built.tags();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateMlMlflowApiMlflowExperimentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "tags", "artifactLocation");
    }
}
