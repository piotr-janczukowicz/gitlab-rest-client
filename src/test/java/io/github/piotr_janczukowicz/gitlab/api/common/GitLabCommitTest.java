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
class GitLabCommitTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).id(null);

        final GitLabCommit built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShortIdIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).shortId(null);

        final GitLabCommit built = builder.build();

        assertThat(built.shortId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).createdAt(null);

        final GitLabCommit built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdsIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).parentIds(null);

        final GitLabCommit built = builder.build();

        assertThat(built.parentIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).title(null);

        final GitLabCommit built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).message(null);

        final GitLabCommit built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorNameIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).authorName(null);

        final GitLabCommit built = builder.build();

        assertThat(built.authorName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).authorEmail(null);

        final GitLabCommit built = builder.build();

        assertThat(built.authorEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthoredDateIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).authoredDate(null);

        final GitLabCommit built = builder.build();

        assertThat(built.authoredDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterNameIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).committerName(null);

        final GitLabCommit built = builder.build();

        assertThat(built.committerName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterEmailIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).committerEmail(null);

        final GitLabCommit built = builder.build();

        assertThat(built.committerEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedDateIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).committedDate(null);

        final GitLabCommit built = builder.build();

        assertThat(built.committedDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailersIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).trailers(null);

        final GitLabCommit built = builder.build();

        assertThat(built.trailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtendedTrailersIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).extendedTrailers(null);

        final GitLabCommit built = builder.build();

        assertThat(built.extendedTrailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCommitBuilder builder =
                GitLabCommitBuilder.builder(CommonCatalogFixtures.commit()).webUrl(null);

        final GitLabCommit built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommit value = CommonCatalogFixtures.commit();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommit original = CommonCatalogFixtures.commit();

        final GitLabCommit rebuilt = GitLabCommitBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommit.class.getRecordComponents())
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
                        "webUrl");
    }
}
