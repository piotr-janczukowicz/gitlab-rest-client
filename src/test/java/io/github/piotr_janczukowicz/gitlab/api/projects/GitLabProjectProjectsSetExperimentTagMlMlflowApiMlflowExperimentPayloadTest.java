package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures
                                        .projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload())
                        .experimentId(null);

        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures
                                        .projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload())
                        .key(null);

        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures
                                        .projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload())
                        .value(null);

        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload value =
                ProjectsCatalogFixtures.projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.experimentId()).isEqualTo("experiment_id");
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload original =
                ProjectsCatalogFixtures.projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload();

        final GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload rebuilt =
                GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId", "key", "value");
    }
}
