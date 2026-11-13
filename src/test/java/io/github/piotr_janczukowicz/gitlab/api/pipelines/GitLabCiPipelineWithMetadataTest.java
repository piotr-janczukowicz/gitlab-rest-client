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
class GitLabCiPipelineWithMetadataTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .id(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .iid(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .projectId(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .sha(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .ref(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .status(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .source(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .createdAt(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .updatedAt(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .webUrl(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeShaIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .beforeSha(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.beforeSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .tag(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYamlErrorsIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .yamlErrors(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.yamlErrors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .user(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .startedAt(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .finishedAt(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedAtIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .committedAt(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.committedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .duration(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .queuedDuration(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .coverage(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedStatusIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .detailedStatus(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.detailedStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .archived(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiPipelineWithMetadataBuilder builder = GitLabCiPipelineWithMetadataBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineWithMetadata())
                .name(null);

        final GitLabCiPipelineWithMetadata built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipelineWithMetadata value = PipelinesCatalogFixtures.ciPipelineWithMetadata();

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
            softly.assertThat(value.coverage()).isEqualTo("coverage");
            softly.assertThat(value.detailedStatus()).isEqualTo(CommonCatalogFixtures.detailedStatusEntity());
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.name()).isEqualTo("Build pipeline");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipelineWithMetadata original = PipelinesCatalogFixtures.ciPipelineWithMetadata();

        final GitLabCiPipelineWithMetadata rebuilt =
                GitLabCiPipelineWithMetadataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipelineWithMetadata.class.getRecordComponents())
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
                        "archived",
                        "name");
    }
}
