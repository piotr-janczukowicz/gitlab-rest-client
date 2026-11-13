package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabChangelogTest {

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabChangelogBuilder builder = GitLabChangelogBuilder.builder(RepositoriesCatalogFixtures.changelog())
                .notes(null);

        final GitLabChangelog built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabChangelog value = RepositoriesCatalogFixtures.changelog();

        assertThat(value.notes()).isEqualTo("## 1.0.0 (2023-01-01)");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabChangelog original = RepositoriesCatalogFixtures.changelog();

        final GitLabChangelog rebuilt = GitLabChangelogBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabChangelog.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("notes");
    }
}
