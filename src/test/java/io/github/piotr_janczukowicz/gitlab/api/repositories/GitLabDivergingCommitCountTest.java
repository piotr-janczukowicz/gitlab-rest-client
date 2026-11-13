package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDivergingCommitCountTest {

    @Test
    void constructor_shouldAcceptNull_whenBehindIsNullable() {
        final GitLabDivergingCommitCountBuilder builder = GitLabDivergingCommitCountBuilder.builder(
                        RepositoriesCatalogFixtures.divergingCommitCount())
                .behind(null);

        final GitLabDivergingCommitCount built = builder.build();

        assertThat(built.behind()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAheadIsNullable() {
        final GitLabDivergingCommitCountBuilder builder = GitLabDivergingCommitCountBuilder.builder(
                        RepositoriesCatalogFixtures.divergingCommitCount())
                .ahead(null);

        final GitLabDivergingCommitCount built = builder.build();

        assertThat(built.ahead()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDivergingCommitCount value = RepositoriesCatalogFixtures.divergingCommitCount();

        assertSoftly(softly -> {
            softly.assertThat(value.behind()).isEqualTo(1);
            softly.assertThat(value.ahead()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDivergingCommitCount original = RepositoriesCatalogFixtures.divergingCommitCount();

        final GitLabDivergingCommitCount rebuilt =
                GitLabDivergingCommitCountBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDivergingCommitCount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("behind", "ahead");
    }
}
