package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload();

        assertThat(value.runId()).isEqualTo("run_id");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsDeleteMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId");
    }
}
