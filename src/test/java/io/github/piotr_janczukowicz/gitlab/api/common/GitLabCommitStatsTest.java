package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCommitStatsTest {

    @Test
    void constructor_shouldAcceptNull_whenAdditionsIsNullable() {
        final GitLabCommitStatsBuilder builder = GitLabCommitStatsBuilder.builder(CommonCatalogFixtures.commitStats())
                .additions(null);

        final GitLabCommitStats built = builder.build();

        assertThat(built.additions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletionsIsNullable() {
        final GitLabCommitStatsBuilder builder = GitLabCommitStatsBuilder.builder(CommonCatalogFixtures.commitStats())
                .deletions(null);

        final GitLabCommitStats built = builder.build();

        assertThat(built.deletions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalIsNullable() {
        final GitLabCommitStatsBuilder builder = GitLabCommitStatsBuilder.builder(CommonCatalogFixtures.commitStats())
                .total(null);

        final GitLabCommitStats built = builder.build();

        assertThat(built.total()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitStats value = CommonCatalogFixtures.commitStats();

        assertSoftly(softly -> {
            softly.assertThat(value.additions()).isEqualTo(1);
            softly.assertThat(value.deletions()).isEqualTo(1);
            softly.assertThat(value.total()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitStats original = CommonCatalogFixtures.commitStats();

        final GitLabCommitStats rebuilt =
                GitLabCommitStatsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitStats.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("additions", "deletions", "total");
    }
}
