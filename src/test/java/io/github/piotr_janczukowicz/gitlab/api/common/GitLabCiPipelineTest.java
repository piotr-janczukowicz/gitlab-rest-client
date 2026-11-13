package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiPipelineTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .id(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .iid(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .projectId(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .sha(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .ref(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .status(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .source(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .createdAt(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .updatedAt(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .webUrl(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeShaIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .beforeSha(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.beforeSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .tag(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYamlErrorsIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .yamlErrors(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.yamlErrors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .user(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .startedAt(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .finishedAt(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedAtIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .committedAt(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.committedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .duration(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .queuedDuration(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .coverage(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedStatusIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .detailedStatus(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.detailedStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabCiPipelineBuilder builder = GitLabCiPipelineBuilder.builder(CommonCatalogFixtures.ciPipeline())
                .archived(null);

        final GitLabCiPipeline built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipeline value = CommonCatalogFixtures.ciPipeline();

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
            softly.assertThat(value.beforeSha()).isEqualTo("a91957a858320c0e17f3a0eca7cfacbff50ea29a");
            softly.assertThat(value.tag()).isEqualTo(true);
            softly.assertThat(value.yamlErrors()).isEqualTo("widgets:build: needs 'widgets:test'");
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.committedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.duration()).isEqualTo(1);
            softly.assertThat(value.queuedDuration()).isEqualTo(1);
            softly.assertThat(value.coverage()).isEqualTo(1.5);
            softly.assertThat(value.detailedStatus()).isEqualTo(CommonCatalogFixtures.detailedStatusEntity());
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipeline original = CommonCatalogFixtures.ciPipeline();

        final GitLabCiPipeline rebuilt =
                GitLabCiPipelineBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipeline.class.getRecordComponents())
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
                        "beforeSha",
                        "tag",
                        "yamlErrors",
                        "user",
                        "startedAt",
                        "finishedAt",
                        "committedAt",
                        "duration",
                        "queuedDuration",
                        "coverage",
                        "detailedStatus",
                        "archived");
    }
}
