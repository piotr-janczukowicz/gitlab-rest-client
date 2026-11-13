package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCommitSequenceTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabCommitSequenceBuilder builder = GitLabCommitSequenceBuilder.builder(
                        CommitsCatalogFixtures.commitSequence())
                .count(null);

        final GitLabCommitSequence built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitSequence value = CommitsCatalogFixtures.commitSequence();

        assertThat(value.count()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitSequence original = CommitsCatalogFixtures.commitSequence();

        final GitLabCommitSequence rebuilt =
                GitLabCommitSequenceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitSequence.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count");
    }
}
