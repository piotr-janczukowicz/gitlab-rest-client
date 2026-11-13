package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload())
                        .key(null);

        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload())
                        .value(null);

        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogParameterMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId", "key", "value");
    }
}
