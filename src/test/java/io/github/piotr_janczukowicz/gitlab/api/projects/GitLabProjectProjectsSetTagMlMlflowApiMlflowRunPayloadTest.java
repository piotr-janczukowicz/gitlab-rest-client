package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload())
                        .key(null);

        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload())
                        .value(null);

        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsSetTagMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId", "key", "value");
    }
}
