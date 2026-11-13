package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload())
                        .runId(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload())
                        .status(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndTimeIsNullable() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload())
                        .endTime(null);

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.endTime()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.status()).isEqualTo(GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.RUNNING);
            softly.assertThat(value.endTime()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runId", "status", "endTime");
    }
}
