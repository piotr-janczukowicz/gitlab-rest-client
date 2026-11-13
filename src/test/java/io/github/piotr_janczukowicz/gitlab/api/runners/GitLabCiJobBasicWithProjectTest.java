package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobBasicWithProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .id(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .status(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .stage(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .name(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .ref(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .tag(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .coverage(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .allowFailure(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .createdAt(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .startedAt(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .finishedAt(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErasedAtIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .erasedAt(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.erasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .duration(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .queuedDuration(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .user(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .commit(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .pipeline(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailureReasonIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .failureReason(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.failureReason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .webUrl(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabCiJobBasicWithProjectBuilder builder = GitLabCiJobBasicWithProjectBuilder.builder(
                        RunnersCatalogFixtures.ciJobBasicWithProject())
                .project(null);

        final GitLabCiJobBasicWithProject built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobBasicWithProject value = RunnersCatalogFixtures.ciJobBasicWithProject();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("waiting_for_resource");
            softly.assertThat(value.stage()).isEqualTo("deploy");
            softly.assertThat(value.name()).isEqualTo("deploy_to_production");
            softly.assertThat(value.ref()).isEqualTo("main");
            softly.assertThat(value.tag()).isEqualTo(true);
            softly.assertThat(value.coverage()).isEqualTo(1.5);
            softly.assertThat(value.allowFailure()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.erasedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.duration()).isEqualTo(1.5);
            softly.assertThat(value.queuedDuration()).isEqualTo(1.5);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.user());
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(value.failureReason()).isEqualTo("script_failure");
            softly.assertThat(value.webUrl()).isEqualTo("https://example.com/foo/bar/-/jobs/1");
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.projectIdentity());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobBasicWithProject original = RunnersCatalogFixtures.ciJobBasicWithProject();

        final GitLabCiJobBasicWithProject rebuilt =
                GitLabCiJobBasicWithProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobBasicWithProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "status",
                        "stage",
                        "name",
                        "ref",
                        "tag",
                        "coverage",
                        "allowFailure",
                        "createdAt",
                        "startedAt",
                        "finishedAt",
                        "erasedAt",
                        "duration",
                        "queuedDuration",
                        "user",
                        "commit",
                        "pipeline",
                        "failureReason",
                        "webUrl",
                        "project");
    }
}
