package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerRegistryRepositoryTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .id(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .name(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .path(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .projectId(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .location(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .createdAt(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCleanupPolicyStartedAtIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .cleanupPolicyStartedAt(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.cleanupPolicyStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsCountIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .tagsCount(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.tagsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .tags(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteApiPathIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .deleteApiPath(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.deleteApiPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .size(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabContainerRegistryRepositoryBuilder builder = GitLabContainerRegistryRepositoryBuilder.builder(
                        CommonCatalogFixtures.containerRegistryRepository())
                .status(null);

        final GitLabContainerRegistryRepository built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerRegistryRepository value = CommonCatalogFixtures.containerRegistryRepository();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("releases");
            softly.assertThat(value.path()).isEqualTo("group/project/releases");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.location()).isEqualTo("gitlab.example.com/group/project/releases");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.cleanupPolicyStartedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.tagsCount()).isEqualTo(1);
            softly.assertThat(value.tags()).isEqualTo(List.of(CommonCatalogFixtures.containerRegistryTag()));
            softly.assertThat(value.deleteApiPath()).isEqualTo("delete/api/path");
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("delete_scheduled");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerRegistryRepository original = CommonCatalogFixtures.containerRegistryRepository();

        final GitLabContainerRegistryRepository rebuilt =
                GitLabContainerRegistryRepositoryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerRegistryRepository.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "path",
                        "projectId",
                        "location",
                        "createdAt",
                        "cleanupPolicyStartedAt",
                        "tagsCount",
                        "tags",
                        "deleteApiPath",
                        "size",
                        "status");
    }
}
