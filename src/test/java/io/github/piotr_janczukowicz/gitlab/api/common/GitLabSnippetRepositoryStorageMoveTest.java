package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSnippetRepositoryStorageMoveTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .id(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .createdAt(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .state(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceStorageNameIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .sourceStorageName(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.sourceStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .destinationStorageName(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorMessageIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .errorMessage(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.errorMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetIsNullable() {
        final GitLabSnippetRepositoryStorageMoveBuilder builder = GitLabSnippetRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.snippetRepositoryStorageMove())
                .snippet(null);

        final GitLabSnippetRepositoryStorageMove built = builder.build();

        assertThat(built.snippet()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSnippetRepositoryStorageMove value = CommonCatalogFixtures.snippetRepositoryStorageMove();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.state()).isEqualTo("scheduled");
            softly.assertThat(value.sourceStorageName()).isEqualTo("default");
            softly.assertThat(value.destinationStorageName()).isEqualTo("storage1");
            softly.assertThat(value.errorMessage()).isEqualTo("Failed to move repository");
            softly.assertThat(value.snippet()).isEqualTo(CommonCatalogFixtures.basicSnippet());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSnippetRepositoryStorageMove original = CommonCatalogFixtures.snippetRepositoryStorageMove();

        final GitLabSnippetRepositoryStorageMove rebuilt =
                GitLabSnippetRepositoryStorageMoveBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSnippetRepositoryStorageMove.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "createdAt",
                        "state",
                        "sourceStorageName",
                        "destinationStorageName",
                        "errorMessage",
                        "snippet");
    }
}
