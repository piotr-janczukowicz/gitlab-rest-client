package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiBridgeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .id(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .status(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .stage(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .name(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .ref(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .tag(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .coverage(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .allowFailure(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .createdAt(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .startedAt(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .finishedAt(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErasedAtIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .erasedAt(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.erasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .duration(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .queuedDuration(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .user(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .commit(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .pipeline(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailureReasonIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .failureReason(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.failureReason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .webUrl(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .project(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownstreamPipelineIsNullable() {
        final GitLabCiBridgeBuilder builder = GitLabCiBridgeBuilder.builder(PipelinesCatalogFixtures.ciBridge())
                .downstreamPipeline(null);

        final GitLabCiBridge built = builder.build();

        assertThat(built.downstreamPipeline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiBridge value = PipelinesCatalogFixtures.ciBridge();

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
            softly.assertThat(value.project()).isEqualTo(PipelinesCatalogFixtures.ciBridgeProject());
            softly.assertThat(value.downstreamPipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiBridge original = PipelinesCatalogFixtures.ciBridge();

        final GitLabCiBridge rebuilt = GitLabCiBridgeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiBridge.class.getRecordComponents())
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
                        "downstreamPipeline");
    }
}
