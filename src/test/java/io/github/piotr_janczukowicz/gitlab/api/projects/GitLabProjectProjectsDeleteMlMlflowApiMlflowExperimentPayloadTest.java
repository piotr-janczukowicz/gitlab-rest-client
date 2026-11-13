package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload())
                        .experimentId(null);

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload value =
                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload();

        assertThat(value.experimentId()).isEqualTo("experiment_id");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload original =
                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload();

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload rebuilt =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsDeleteMlMlflowApiMlflowExperimentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId");
    }
}
