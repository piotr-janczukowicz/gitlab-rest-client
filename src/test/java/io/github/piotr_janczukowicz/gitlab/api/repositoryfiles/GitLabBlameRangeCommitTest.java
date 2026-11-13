package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBlameRangeCommitTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .id(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdsIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .parentIds(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.parentIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .message(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthoredDateIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .authoredDate(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.authoredDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorNameIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .authorName(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.authorName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .authorEmail(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.authorEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedDateIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .committedDate(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.committedDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterNameIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .committerName(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.committerName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterEmailIsNullable() {
        final GitLabBlameRangeCommitBuilder builder = GitLabBlameRangeCommitBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRangeCommit())
                .committerEmail(null);

        final GitLabBlameRangeCommit built = builder.build();

        assertThat(built.committerEmail()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBlameRangeCommit value = RepositoryfilesCatalogFixtures.blameRangeCommit();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.parentIds()).isEqualTo(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"));
            softly.assertThat(value.message()).isEqualTo("Initial commit");
            softly.assertThat(value.authoredDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.authorName()).isEqualTo("John Smith");
            softly.assertThat(value.authorEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.committedDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.committerName()).isEqualTo("Jack Smith");
            softly.assertThat(value.committerEmail()).isEqualTo("jack@example.com");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBlameRangeCommit original = RepositoryfilesCatalogFixtures.blameRangeCommit();

        final GitLabBlameRangeCommit rebuilt =
                GitLabBlameRangeCommitBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBlameRangeCommit.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "parentIds",
                        "message",
                        "authoredDate",
                        "authorName",
                        "authorEmail",
                        "committedDate",
                        "committerName",
                        "committerEmail");
    }
}
