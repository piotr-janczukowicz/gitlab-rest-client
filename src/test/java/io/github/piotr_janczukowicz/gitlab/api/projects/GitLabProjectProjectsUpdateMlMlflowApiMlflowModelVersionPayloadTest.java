package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload())
                        .name(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload())
                        .description(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload();

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload rebuilt =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateMlMlflowApiMlflowModelVersionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description");
    }
}
