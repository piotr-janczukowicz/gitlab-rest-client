package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCompareTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .commit(null);

        final GitLabCompare built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitsIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .commits(null);

        final GitLabCompare built = builder.build();

        assertThat(built.commits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffsIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .diffs(null);

        final GitLabCompare built = builder.build();

        assertThat(built.diffs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompareTimeoutIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .compareTimeout(null);

        final GitLabCompare built = builder.build();

        assertThat(built.compareTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompareSameRefIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .compareSameRef(null);

        final GitLabCompare built = builder.build();

        assertThat(built.compareSameRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCompareBuilder builder = GitLabCompareBuilder.builder(RepositoriesCatalogFixtures.compare())
                .webUrl(null);

        final GitLabCompare built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCompare value = RepositoriesCatalogFixtures.compare();

        assertSoftly(softly -> {
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.commits()).isEqualTo(List.of(CommonCatalogFixtures.commit()));
            softly.assertThat(value.diffs()).isEqualTo(List.of(CommonCatalogFixtures.diff()));
            softly.assertThat(value.compareTimeout()).isEqualTo(true);
            softly.assertThat(value.compareSameRef()).isEqualTo(true);
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab/gitlab-foss/-/compare/main...feature");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCompare original = RepositoriesCatalogFixtures.compare();

        final GitLabCompare rebuilt = GitLabCompareBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCompare.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("commit", "commits", "diffs", "compareTimeout", "compareSameRef", "webUrl");
    }
}
