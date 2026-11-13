package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).id(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).status(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).stage(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).name(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).ref(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).tag(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).coverage(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).allowFailure(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).createdAt(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).startedAt(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).finishedAt(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErasedAtIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).erasedAt(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.erasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).duration(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).queuedDuration(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).user(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).commit(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).pipeline(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailureReasonIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).failureReason(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.failureReason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).webUrl(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).project(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsFileIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).artifactsFile(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.artifactsFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).artifacts(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.artifacts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).runner(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.runner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerManagerIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).runnerManager(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.runnerManager()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsExpireAtIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).artifactsExpireAt(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.artifactsExpireAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).archived(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabCiJobBuilder builder =
                GitLabCiJobBuilder.builder(CommonCatalogFixtures.ciJob()).tagList(null);

        final GitLabCiJob built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJob value = CommonCatalogFixtures.ciJob();

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
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.ciJobProject());
            softly.assertThat(value.artifactsFile()).isEqualTo(CommonCatalogFixtures.ciJobArtifactFile());
            softly.assertThat(value.artifacts()).isEqualTo(List.of(CommonCatalogFixtures.ciJobArtifact()));
            softly.assertThat(value.runner()).isEqualTo(CommonCatalogFixtures.ciRunner());
            softly.assertThat(value.runnerManager()).isEqualTo(CommonCatalogFixtures.ciRunnerManager());
            softly.assertThat(value.artifactsExpireAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.tagList()).isEqualTo(List.of("ubuntu18"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJob original = CommonCatalogFixtures.ciJob();

        final GitLabCiJob rebuilt = GitLabCiJobBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJob.class.getRecordComponents())
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
                        "project",
                        "artifactsFile",
                        "artifacts",
                        "runner",
                        "runnerManager",
                        "artifactsExpireAt",
                        "archived",
                        "tagList");
    }
}
