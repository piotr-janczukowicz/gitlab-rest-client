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
class GitLabNoteTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).id(null);

        final GitLabNote built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).type(null);

        final GitLabNote built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).body(null);

        final GitLabNote built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).author(null);

        final GitLabNote built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).createdAt(null);

        final GitLabNote built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).updatedAt(null);

        final GitLabNote built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).system(null);

        final GitLabNote built = builder.build();

        assertThat(built.system()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteableIdIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).noteableId(null);

        final GitLabNote built = builder.build();

        assertThat(built.noteableId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteableTypeIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).noteableType(null);

        final GitLabNote built = builder.build();

        assertThat(built.noteableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).projectId(null);

        final GitLabNote built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIdIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).commitId(null);

        final GitLabNote built = builder.build();

        assertThat(built.commitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).position(null);

        final GitLabNote built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvableIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).resolvable(null);

        final GitLabNote built = builder.build();

        assertThat(built.resolvable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).resolved(null);

        final GitLabNote built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedByIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).resolvedBy(null);

        final GitLabNote built = builder.build();

        assertThat(built.resolvedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedAtIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).resolvedAt(null);

        final GitLabNote built = builder.build();

        assertThat(built.resolvedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestionsIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).suggestions(null);

        final GitLabNote built = builder.build();

        assertThat(built.suggestions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).confidential(null);

        final GitLabNote built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).internal(null);

        final GitLabNote built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).imported(null);

        final GitLabNote built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).importedFrom(null);

        final GitLabNote built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteableIidIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).noteableIid(null);

        final GitLabNote built = builder.build();

        assertThat(built.noteableIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommandsChangesIsNullable() {
        final GitLabNoteBuilder builder =
                GitLabNoteBuilder.builder(CommonCatalogFixtures.note()).commandsChanges(null);

        final GitLabNote built = builder.build();

        assertThat(built.commandsChanges()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNote value = CommonCatalogFixtures.note();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.type()).isEqualTo("DiscussionNote");
            softly.assertThat(value.body()).isEqualTo("Note body.");
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.system()).isEqualTo(true);
            softly.assertThat(value.noteableId()).isEqualTo(1L);
            softly.assertThat(value.noteableType()).isEqualTo("Issue");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.commitId()).isEqualTo("7b09ce7e6f80347baf0316c8c94cdba9a0a7e91d");
            softly.assertThat(value.position()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.resolvable()).isEqualTo(true);
            softly.assertThat(value.resolved()).isEqualTo(true);
            softly.assertThat(value.resolvedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.resolvedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.suggestions()).isEqualTo(List.of(CommonCatalogFixtures.suggestion()));
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.internal()).isEqualTo(true);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("github");
            softly.assertThat(value.noteableIid()).isEqualTo(1L);
            softly.assertThat(value.commandsChanges()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNote original = CommonCatalogFixtures.note();

        final GitLabNote rebuilt = GitLabNoteBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNote.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "type",
                        "body",
                        "author",
                        "createdAt",
                        "updatedAt",
                        "system",
                        "noteableId",
                        "noteableType",
                        "projectId",
                        "commitId",
                        "position",
                        "resolvable",
                        "resolved",
                        "resolvedBy",
                        "resolvedAt",
                        "suggestions",
                        "confidential",
                        "internal",
                        "imported",
                        "importedFrom",
                        "noteableIid",
                        "commandsChanges");
    }
}
