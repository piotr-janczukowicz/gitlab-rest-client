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
class GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload())
                        .name(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload())
                        .description(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload())
                        .tags(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload())
                        .runId(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.tags()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.runId()).isEqualTo("run_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload();

        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload rebuilt =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagsSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built =
                GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload())
                        .tags(source)
                        .build();
        source.clear();

        assertThat(built.tags()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagsIsRead() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload built =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload();
        final List<Map<String, Object>> values = built.tags();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateMlMlflowApiMlflowModelVersionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "tags", "runId");
    }
}
