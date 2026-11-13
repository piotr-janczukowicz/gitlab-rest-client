package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStateIsNull() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .state(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("state");
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .ref(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetUrlIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .targetUrl(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.targetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .description(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .name(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .context(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .coverage(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIdIsNullable() {
        final GitLabProjectCommitsCreatePayloadBuilder builder = GitLabProjectCommitsCreatePayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsCreatePayload())
                .pipelineId(null);

        final GitLabProjectCommitsCreatePayload built = builder.build();

        assertThat(built.pipelineId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsCreatePayload value = CommitsCatalogFixtures.projectCommitsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo(GitLabProjectCommitsCreateState.PENDING);
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.targetUrl()).isEqualTo("https://gitlab.example.com/janedoe/gitlab-foss/builds/91");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.name()).isEqualTo("coverage");
            softly.assertThat(value.context()).isEqualTo("coverage");
            softly.assertThat(value.coverage()).isEqualTo(1.5);
            softly.assertThat(value.pipelineId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsCreatePayload original = CommitsCatalogFixtures.projectCommitsCreatePayload();

        final GitLabProjectCommitsCreatePayload rebuilt =
                GitLabProjectCommitsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "state", "ref", "targetUrl", "description", "name", "context", "coverage", "pipelineId");
    }
}
