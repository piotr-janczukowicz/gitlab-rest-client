package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthTest {

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .size(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .references(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenObjectsIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .objects(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.objects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitGraphIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .commitGraph(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.commitGraph()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBitmapIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .bitmap(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.bitmap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMultiPackIndexIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .multiPackIndex(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.multiPackIndex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMultiPackIndexBitmapIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .multiPackIndexBitmap(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.multiPackIndexBitmap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlternatesIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .alternates(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.alternates()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsObjectPoolIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .isObjectPool(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.isObjectPool()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastFullRepackIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .lastFullRepack(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.lastFullRepack()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabRepositoryHealthBuilder builder = GitLabRepositoryHealthBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealth())
                .updatedAt(null);

        final GitLabRepositoryHealth built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealth value = RepositoriesCatalogFixtures.repositoryHealth();

        assertSoftly(softly -> {
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.references()).isEqualTo(RepositoriesCatalogFixtures.repositoryHealthReferences());
            softly.assertThat(value.objects()).isEqualTo(RepositoriesCatalogFixtures.repositoryHealthObjects());
            softly.assertThat(value.commitGraph()).isEqualTo(RepositoriesCatalogFixtures.repositoryHealthCommitGraph());
            softly.assertThat(value.bitmap()).isEqualTo(RepositoriesCatalogFixtures.repositoryHealthBitmap());
            softly.assertThat(value.multiPackIndex())
                    .isEqualTo(RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex());
            softly.assertThat(value.multiPackIndexBitmap())
                    .isEqualTo(RepositoriesCatalogFixtures.repositoryHealthBitmap());
            softly.assertThat(value.alternates()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.isObjectPool()).isEqualTo(true);
            softly.assertThat(value.lastFullRepack())
                    .isEqualTo(RepositoriesCatalogFixtures.repositoryHealthLastFullRepack());
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealth original = RepositoriesCatalogFixtures.repositoryHealth();

        final GitLabRepositoryHealth rebuilt =
                GitLabRepositoryHealthBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealth.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "size",
                        "references",
                        "objects",
                        "commitGraph",
                        "bitmap",
                        "multiPackIndex",
                        "multiPackIndexBitmap",
                        "alternates",
                        "isObjectPool",
                        "lastFullRepack",
                        "updatedAt");
    }
}
