package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthObjectsTest {

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .size(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecentSizeIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .recentSize(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.recentSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaleSizeIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .staleSize(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.staleSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepSizeIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .keepSize(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.keepSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackfileCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .packfileCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.packfileCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReverseIndexCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .reverseIndexCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.reverseIndexCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCruftCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .cruftCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.cruftCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .keepCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.keepCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLooseObjectsCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .looseObjectsCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.looseObjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaleLooseObjectsCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .staleLooseObjectsCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.staleLooseObjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLooseObjectsGarbageCountIsNullable() {
        final GitLabRepositoryHealthObjectsBuilder builder = GitLabRepositoryHealthObjectsBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthObjects())
                .looseObjectsGarbageCount(null);

        final GitLabRepositoryHealthObjects built = builder.build();

        assertThat(built.looseObjectsGarbageCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthObjects value = RepositoriesCatalogFixtures.repositoryHealthObjects();

        assertSoftly(softly -> {
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.recentSize()).isEqualTo(1L);
            softly.assertThat(value.staleSize()).isEqualTo(1L);
            softly.assertThat(value.keepSize()).isEqualTo(1L);
            softly.assertThat(value.packfileCount()).isEqualTo(1);
            softly.assertThat(value.reverseIndexCount()).isEqualTo(1);
            softly.assertThat(value.cruftCount()).isEqualTo(1);
            softly.assertThat(value.keepCount()).isEqualTo(1);
            softly.assertThat(value.looseObjectsCount()).isEqualTo(1);
            softly.assertThat(value.staleLooseObjectsCount()).isEqualTo(1);
            softly.assertThat(value.looseObjectsGarbageCount()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthObjects original = RepositoriesCatalogFixtures.repositoryHealthObjects();

        final GitLabRepositoryHealthObjects rebuilt =
                GitLabRepositoryHealthObjectsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthObjects.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "size",
                        "recentSize",
                        "staleSize",
                        "keepSize",
                        "packfileCount",
                        "reverseIndexCount",
                        "cruftCount",
                        "keepCount",
                        "looseObjectsCount",
                        "staleLooseObjectsCount",
                        "looseObjectsGarbageCount");
    }
}
