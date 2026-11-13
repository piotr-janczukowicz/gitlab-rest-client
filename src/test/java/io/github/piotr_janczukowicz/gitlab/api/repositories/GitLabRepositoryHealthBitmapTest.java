package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthBitmapTest {

    @Test
    void constructor_shouldAcceptNull_whenHasHashCacheIsNullable() {
        final GitLabRepositoryHealthBitmapBuilder builder = GitLabRepositoryHealthBitmapBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthBitmap())
                .hasHashCache(null);

        final GitLabRepositoryHealthBitmap built = builder.build();

        assertThat(built.hasHashCache()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasLookupTableIsNullable() {
        final GitLabRepositoryHealthBitmapBuilder builder = GitLabRepositoryHealthBitmapBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthBitmap())
                .hasLookupTable(null);

        final GitLabRepositoryHealthBitmap built = builder.build();

        assertThat(built.hasLookupTable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabRepositoryHealthBitmapBuilder builder = GitLabRepositoryHealthBitmapBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthBitmap())
                .version(null);

        final GitLabRepositoryHealthBitmap built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthBitmap value = RepositoriesCatalogFixtures.repositoryHealthBitmap();

        assertSoftly(softly -> {
            softly.assertThat(value.hasHashCache()).isEqualTo(true);
            softly.assertThat(value.hasLookupTable()).isEqualTo(true);
            softly.assertThat(value.version()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthBitmap original = RepositoriesCatalogFixtures.repositoryHealthBitmap();

        final GitLabRepositoryHealthBitmap rebuilt =
                GitLabRepositoryHealthBitmapBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthBitmap.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("hasHashCache", "hasLookupTable", "version");
    }
}
