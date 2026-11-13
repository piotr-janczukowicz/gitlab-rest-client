package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiffStatTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabDiffStatBuilder builder = GitLabDiffStatBuilder.builder(RepositoriesCatalogFixtures.diffStat())
                .path(null);

        final GitLabDiffStat built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabDiffStatBuilder builder = GitLabDiffStatBuilder.builder(RepositoriesCatalogFixtures.diffStat())
                .oldPath(null);

        final GitLabDiffStat built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionsIsNullable() {
        final GitLabDiffStatBuilder builder = GitLabDiffStatBuilder.builder(RepositoriesCatalogFixtures.diffStat())
                .additions(null);

        final GitLabDiffStat built = builder.build();

        assertThat(built.additions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletionsIsNullable() {
        final GitLabDiffStatBuilder builder = GitLabDiffStatBuilder.builder(RepositoriesCatalogFixtures.diffStat())
                .deletions(null);

        final GitLabDiffStat built = builder.build();

        assertThat(built.deletions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDiffStat value = RepositoriesCatalogFixtures.diffStat();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.oldPath()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.additions()).isEqualTo(1);
            softly.assertThat(value.deletions()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDiffStat original = RepositoriesCatalogFixtures.diffStat();

        final GitLabDiffStat rebuilt = GitLabDiffStatBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDiffStat.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "oldPath", "additions", "deletions");
    }
}
