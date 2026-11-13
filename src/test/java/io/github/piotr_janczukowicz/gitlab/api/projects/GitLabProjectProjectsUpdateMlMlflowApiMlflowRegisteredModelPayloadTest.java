package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload())
                        .name(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload())
                        .description(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload();

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload rebuilt =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description");
    }
}
