package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupRepositoryStorageMoveTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .id(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .createdAt(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .state(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceStorageNameIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .sourceStorageName(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.sourceStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .destinationStorageName(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorMessageIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .errorMessage(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.errorMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabGroupRepositoryStorageMoveBuilder builder = GitLabGroupRepositoryStorageMoveBuilder.builder(
                        CommonCatalogFixtures.groupRepositoryStorageMove())
                .group(null);

        final GitLabGroupRepositoryStorageMove built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupRepositoryStorageMove value = CommonCatalogFixtures.groupRepositoryStorageMove();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.state()).isEqualTo("scheduled");
            softly.assertThat(value.sourceStorageName()).isEqualTo("default");
            softly.assertThat(value.destinationStorageName()).isEqualTo("storage1");
            softly.assertThat(value.errorMessage()).isEqualTo("Failed to move repository");
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.basicGroupDetails());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupRepositoryStorageMove original = CommonCatalogFixtures.groupRepositoryStorageMove();

        final GitLabGroupRepositoryStorageMove rebuilt =
                GitLabGroupRepositoryStorageMoveBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupRepositoryStorageMove.class.getRecordComponents())
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
                        "group");
    }
}
