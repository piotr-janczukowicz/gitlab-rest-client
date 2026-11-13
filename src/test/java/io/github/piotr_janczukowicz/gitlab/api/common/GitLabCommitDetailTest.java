package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCommitDetailTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .id(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShortIdIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .shortId(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.shortId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .createdAt(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdsIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .parentIds(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.parentIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .title(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .message(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorNameIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .authorName(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.authorName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .authorEmail(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.authorEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthoredDateIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .authoredDate(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.authoredDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterNameIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .committerName(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.committerName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterEmailIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .committerEmail(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.committerEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedDateIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .committedDate(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.committedDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailersIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .trailers(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.trailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtendedTrailersIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .extendedTrailers(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.extendedTrailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .webUrl(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatsIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .stats(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.stats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .status(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .projectId(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastPipelineIsNullable() {
        final GitLabCommitDetailBuilder builder = GitLabCommitDetailBuilder.builder(
                        CommonCatalogFixtures.commitDetail())
                .lastPipeline(null);

        final GitLabCommitDetail built = builder.build();

        assertThat(built.lastPipeline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitDetail value = CommonCatalogFixtures.commitDetail();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.shortId()).isEqualTo("2695effb");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.parentIds()).isEqualTo(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"));
            softly.assertThat(value.title()).isEqualTo("Initial commit");
            softly.assertThat(value.message()).isEqualTo("Initial commit");
            softly.assertThat(value.authorName()).isEqualTo("John Smith");
            softly.assertThat(value.authorEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.authoredDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.committerName()).isEqualTo("Jack Smith");
            softly.assertThat(value.committerEmail()).isEqualTo("jack@example.com");
            softly.assertThat(value.committedDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.trailers()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.extendedTrailers()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.webUrl())
                    .isEqualTo(
                            "https://gitlab.example.com/janedoe/gitlab-foss/-/commit/ed899a2f4b50b4370feeea94676502b42383c746");
            softly.assertThat(value.stats()).isEqualTo(CommonCatalogFixtures.commitStats());
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.lastPipeline()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitDetail original = CommonCatalogFixtures.commitDetail();

        final GitLabCommitDetail rebuilt =
                GitLabCommitDetailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitDetail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "shortId",
                        "createdAt",
                        "parentIds",
                        "title",
                        "message",
                        "authorName",
                        "authorEmail",
                        "authoredDate",
                        "committerName",
                        "committerEmail",
                        "committedDate",
                        "trailers",
                        "extendedTrailers",
                        "webUrl",
                        "stats",
                        "status",
                        "projectId",
                        "lastPipeline");
    }
}
