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
class GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload())
                        .name(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload())
                        .description(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder builder =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload())
                        .tags(null);

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.tags()).isEqualTo(List.of(Map.of("key", "value")));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload();

        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload rebuilt =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagsSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload built =
                GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload())
                        .tags(source)
                        .build();
        source.clear();

        assertThat(built.tags()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagsIsRead() {
        final GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload built =
                ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload();
        final List<Map<String, Object>> values = built.tags();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "tags");
    }
}
