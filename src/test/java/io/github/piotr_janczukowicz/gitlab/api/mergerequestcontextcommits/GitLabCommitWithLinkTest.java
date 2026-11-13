package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

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
class GitLabCommitWithLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .id(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShortIdIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .shortId(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.shortId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .createdAt(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdsIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .parentIds(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.parentIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .title(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .message(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorNameIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .authorName(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.authorName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .authorEmail(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.authorEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthoredDateIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .authoredDate(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.authoredDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterNameIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .committerName(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.committerName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitterEmailIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .committerEmail(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.committerEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommittedDateIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .committedDate(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.committedDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailersIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .trailers(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.trailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtendedTrailersIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .extendedTrailers(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.extendedTrailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .webUrl(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .author(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorGravatarUrlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .authorGravatarUrl(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.authorGravatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitUrlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .commitUrl(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.commitUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitPathIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .commitPath(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.commitPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .descriptionHtml(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleHtmlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .titleHtml(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.titleHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignatureHtmlIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .signatureHtml(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.signatureHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrevCommitIdIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .prevCommitId(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.prevCommitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextCommitIdIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .nextCommitId(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.nextCommitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineStatusPathIsNullable() {
        final GitLabCommitWithLinkBuilder builder = GitLabCommitWithLinkBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.commitWithLink())
                .pipelineStatusPath(null);

        final GitLabCommitWithLink built = builder.build();

        assertThat(built.pipelineStatusPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitWithLink value = MergerequestcontextcommitsCatalogFixtures.commitWithLink();

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
            softly.assertThat(value.author()).isEqualTo(MergerequestcontextcommitsCatalogFixtures.userPath());
            softly.assertThat(value.authorGravatarUrl()).isEqualTo("https://www.gravatar.com/avatar/abc");
            softly.assertThat(value.commitUrl()).isEqualTo("https://gitlab.example.com/project/-/commit/abc");
            softly.assertThat(value.commitPath()).isEqualTo("/project/-/commit/abc");
            softly.assertThat(value.descriptionHtml()).isEqualTo("<p>description</p>");
            softly.assertThat(value.titleHtml()).isEqualTo("<p>title</p>");
            softly.assertThat(value.signatureHtml()).isEqualTo("<p>signature</p>");
            softly.assertThat(value.prevCommitId()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.nextCommitId()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.pipelineStatusPath()).isEqualTo("/project/pipelines/1");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitWithLink original = MergerequestcontextcommitsCatalogFixtures.commitWithLink();

        final GitLabCommitWithLink rebuilt =
                GitLabCommitWithLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitWithLink.class.getRecordComponents())
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
                        "author",
                        "authorGravatarUrl",
                        "commitUrl",
                        "commitPath",
                        "descriptionHtml",
                        "titleHtml",
                        "signatureHtml",
                        "prevCommitId",
                        "nextCommitId",
                        "pipelineStatusPath");
    }
}
