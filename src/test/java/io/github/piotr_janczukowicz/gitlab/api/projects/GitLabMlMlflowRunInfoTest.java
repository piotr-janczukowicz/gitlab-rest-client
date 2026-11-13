package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowRunInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .runId(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunUuidIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .runUuid(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.runUuid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .experimentId(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartTimeIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .startTime(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.startTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndTimeIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .endTime(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.endTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunNameIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .runName(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.runName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .status(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactUriIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .artifactUri(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.artifactUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLifecycleStageIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .lifecycleStage(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.lifecycleStage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabMlMlflowRunInfoBuilder builder = GitLabMlMlflowRunInfoBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunInfo())
                .userId(null);

        final GitLabMlMlflowRunInfo built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowRunInfo value = ProjectsCatalogFixtures.mlMlflowRunInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.runUuid()).isEqualTo("run_uuid");
            softly.assertThat(value.experimentId()).isEqualTo("experiment_id");
            softly.assertThat(value.startTime()).isEqualTo(1);
            softly.assertThat(value.endTime()).isEqualTo(1);
            softly.assertThat(value.runName()).isEqualTo("run_name");
            softly.assertThat(value.status()).isEqualTo("FINISHED");
            softly.assertThat(value.artifactUri()).isEqualTo("artifact_uri");
            softly.assertThat(value.lifecycleStage()).isEqualTo("active");
            softly.assertThat(value.userId()).isEqualTo("user_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowRunInfo original = ProjectsCatalogFixtures.mlMlflowRunInfo();

        final GitLabMlMlflowRunInfo rebuilt =
                GitLabMlMlflowRunInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowRunInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "runId",
                        "runUuid",
                        "experimentId",
                        "startTime",
                        "endTime",
                        "runName",
                        "status",
                        "artifactUri",
                        "lifecycleStage",
                        "userId");
    }
}
