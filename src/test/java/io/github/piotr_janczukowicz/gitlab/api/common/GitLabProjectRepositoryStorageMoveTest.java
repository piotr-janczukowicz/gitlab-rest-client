package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryStorageMoveTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .id(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .createdAt(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .state(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceStorageNameIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .sourceStorageName(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.sourceStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .destinationStorageName(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorMessageIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .errorMessage(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.errorMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabProjectRepositoryStorageMoveBuilder builder = GitLabProjectRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.projectRepositoryStorageMove())
                .project(null);

        final GitLabProjectRepositoryStorageMove built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryStorageMove value = CommonCatalogFixtures.projectRepositoryStorageMove();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.state()).isEqualTo("scheduled");
            softly.assertThat(value.sourceStorageName()).isEqualTo("default");
            softly.assertThat(value.destinationStorageName()).isEqualTo("storage1");
            softly.assertThat(value.errorMessage()).isEqualTo("Failed to move repository");
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.projectIdentity());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryStorageMove original = CommonCatalogFixtures.projectRepositoryStorageMove();

        final GitLabProjectRepositoryStorageMove rebuilt =
                GitLabProjectRepositoryStorageMoveBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryStorageMove.class.getRecordComponents())
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
                        "project");
    }
}
