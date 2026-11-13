package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthCommitGraphTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitGraphChainLengthIsNullable() {
        final GitLabRepositoryHealthCommitGraphBuilder builder = GitLabRepositoryHealthCommitGraphBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthCommitGraph())
                .commitGraphChainLength(null);

        final GitLabRepositoryHealthCommitGraph built = builder.build();

        assertThat(built.commitGraphChainLength()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasBloomFiltersIsNullable() {
        final GitLabRepositoryHealthCommitGraphBuilder builder = GitLabRepositoryHealthCommitGraphBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthCommitGraph())
                .hasBloomFilters(null);

        final GitLabRepositoryHealthCommitGraph built = builder.build();

        assertThat(built.hasBloomFilters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasGenerationDataIsNullable() {
        final GitLabRepositoryHealthCommitGraphBuilder builder = GitLabRepositoryHealthCommitGraphBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthCommitGraph())
                .hasGenerationData(null);

        final GitLabRepositoryHealthCommitGraph built = builder.build();

        assertThat(built.hasGenerationData()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasGenerationDataOverflowIsNullable() {
        final GitLabRepositoryHealthCommitGraphBuilder builder = GitLabRepositoryHealthCommitGraphBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthCommitGraph())
                .hasGenerationDataOverflow(null);

        final GitLabRepositoryHealthCommitGraph built = builder.build();

        assertThat(built.hasGenerationDataOverflow()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthCommitGraph value = RepositoriesCatalogFixtures.repositoryHealthCommitGraph();

        assertSoftly(softly -> {
            softly.assertThat(value.commitGraphChainLength()).isEqualTo(1);
            softly.assertThat(value.hasBloomFilters()).isEqualTo(true);
            softly.assertThat(value.hasGenerationData()).isEqualTo(true);
            softly.assertThat(value.hasGenerationDataOverflow()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthCommitGraph original = RepositoriesCatalogFixtures.repositoryHealthCommitGraph();

        final GitLabRepositoryHealthCommitGraph rebuilt =
                GitLabRepositoryHealthCommitGraphBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthCommitGraph.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "commitGraphChainLength", "hasBloomFilters", "hasGenerationData", "hasGenerationDataOverflow");
    }
}
