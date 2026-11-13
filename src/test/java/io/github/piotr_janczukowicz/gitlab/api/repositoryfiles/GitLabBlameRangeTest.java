package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBlameRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabBlameRangeBuilder builder = GitLabBlameRangeBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRange())
                .commit(null);

        final GitLabBlameRange built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinesIsNullable() {
        final GitLabBlameRangeBuilder builder = GitLabBlameRangeBuilder.builder(
                        RepositoryfilesCatalogFixtures.blameRange())
                .lines(null);

        final GitLabBlameRange built = builder.build();

        assertThat(built.lines()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBlameRange value = RepositoryfilesCatalogFixtures.blameRange();

        assertSoftly(softly -> {
            softly.assertThat(value.commit()).isEqualTo(RepositoryfilesCatalogFixtures.blameRangeCommit());
            softly.assertThat(value.lines()).isEqualTo(List.of("lorem ipsum"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBlameRange original = RepositoryfilesCatalogFixtures.blameRange();

        final GitLabBlameRange rebuilt =
                GitLabBlameRangeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBlameRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("commit", "lines");
    }
}
