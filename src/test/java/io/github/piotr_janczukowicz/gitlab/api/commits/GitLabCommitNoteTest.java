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
class GitLabCommitNoteTest {

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .note(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .path(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .line(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.line()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineTypeIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .lineType(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.lineType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .author(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCommitNoteBuilder builder = GitLabCommitNoteBuilder.builder(CommitsCatalogFixtures.commitNote())
                .createdAt(null);

        final GitLabCommitNote built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitNote value = CommitsCatalogFixtures.commitNote();

        assertSoftly(softly -> {
            softly.assertThat(value.note()).isEqualTo("this doc is really nice");
            softly.assertThat(value.path()).isEqualTo("README.md");
            softly.assertThat(value.line()).isEqualTo(1);
            softly.assertThat(value.lineType()).isEqualTo("new");
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitNote original = CommitsCatalogFixtures.commitNote();

        final GitLabCommitNote rebuilt =
                GitLabCommitNoteBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitNote.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("note", "path", "line", "lineType", "author", "createdAt");
    }
}
