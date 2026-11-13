package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCommitStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .id(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .sha(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .ref(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .status(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .name(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetUrlIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .targetUrl(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.targetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .description(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .createdAt(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .startedAt(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .finishedAt(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .allowFailure(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .coverage(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIdIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .pipelineId(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.pipelineId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabCommitStatusBuilder builder = GitLabCommitStatusBuilder.builder(
                        CommitsCatalogFixtures.commitStatus())
                .author(null);

        final GitLabCommitStatus built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitStatus value = CommitsCatalogFixtures.commitStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.sha()).isEqualTo("18f3e63d05582537db6d183d9d557be09e1f90c8");
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.name()).isEqualTo("default");
            softly.assertThat(value.targetUrl()).isEqualTo("https://gitlab.example.com/janedoe/gitlab-foss/builds/91");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.allowFailure()).isEqualTo(true);
            softly.assertThat(value.coverage()).isEqualTo(1.5);
            softly.assertThat(value.pipelineId()).isEqualTo(1L);
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitStatus original = CommitsCatalogFixtures.commitStatus();

        final GitLabCommitStatus rebuilt =
                GitLabCommitStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "sha",
                        "ref",
                        "status",
                        "name",
                        "targetUrl",
                        "description",
                        "createdAt",
                        "startedAt",
                        "finishedAt",
                        "allowFailure",
                        "coverage",
                        "pipelineId",
                        "author");
    }
}
