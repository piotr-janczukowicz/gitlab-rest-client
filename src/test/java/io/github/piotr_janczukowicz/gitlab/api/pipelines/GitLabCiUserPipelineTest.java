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
class GitLabCiUserPipelineTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .id(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .iid(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .projectId(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .sha(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .ref(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .status(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .source(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .createdAt(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .updatedAt(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .webUrl(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .name(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .project(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .startedAt(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .finishedAt(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .duration(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .queuedDuration(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedStatusIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .detailedStatus(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.detailedStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIsNullable() {
        final GitLabCiUserPipelineBuilder builder = GitLabCiUserPipelineBuilder.builder(
                        PipelinesCatalogFixtures.ciUserPipeline())
                .mergeRequest(null);

        final GitLabCiUserPipeline built = builder.build();

        assertThat(built.mergeRequest()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiUserPipeline value = PipelinesCatalogFixtures.ciUserPipeline();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.sha()).isEqualTo("0ec9e58fdfca6cdd6652c083c9edb53abc0bad52");
            softly.assertThat(value.ref()).isEqualTo("feature-branch");
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.source()).isEqualTo("push");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab-org/gitlab-foss/-/pipelines/61");
            softly.assertThat(value.name()).isEqualTo("Build pipeline");
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.projectIdentity());
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.duration()).isEqualTo(1);
            softly.assertThat(value.queuedDuration()).isEqualTo(1);
            softly.assertThat(value.detailedStatus()).isEqualTo(CommonCatalogFixtures.detailedStatusEntity());
            softly.assertThat(value.mergeRequest()).isEqualTo(PipelinesCatalogFixtures.ciPipelineMergeRequest());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiUserPipeline original = PipelinesCatalogFixtures.ciUserPipeline();

        final GitLabCiUserPipeline rebuilt =
                GitLabCiUserPipelineBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiUserPipeline.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "sha",
                        "ref",
                        "status",
                        "source",
                        "createdAt",
                        "updatedAt",
                        "webUrl",
                        "name",
                        "project",
                        "startedAt",
                        "finishedAt",
                        "duration",
                        "queuedDuration",
                        "detailedStatus",
                        "mergeRequest");
    }
}
