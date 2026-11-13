package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthMultiPackIndexTest {

    @Test
    void constructor_shouldAcceptNull_whenPackfileCountIsNullable() {
        final GitLabRepositoryHealthMultiPackIndexBuilder builder = GitLabRepositoryHealthMultiPackIndexBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex())
                .packfileCount(null);

        final GitLabRepositoryHealthMultiPackIndex built = builder.build();

        assertThat(built.packfileCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabRepositoryHealthMultiPackIndexBuilder builder = GitLabRepositoryHealthMultiPackIndexBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex())
                .version(null);

        final GitLabRepositoryHealthMultiPackIndex built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthMultiPackIndex value = RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex();

        assertSoftly(softly -> {
            softly.assertThat(value.packfileCount()).isEqualTo(1);
            softly.assertThat(value.version()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthMultiPackIndex original =
                RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex();

        final GitLabRepositoryHealthMultiPackIndex rebuilt =
                GitLabRepositoryHealthMultiPackIndexBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthMultiPackIndex.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("packfileCount", "version");
    }
}
