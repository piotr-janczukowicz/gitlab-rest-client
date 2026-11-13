package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContributorTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabContributorBuilder builder = GitLabContributorBuilder.builder(
                        RepositoriesCatalogFixtures.contributor())
                .name(null);

        final GitLabContributor built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabContributorBuilder builder = GitLabContributorBuilder.builder(
                        RepositoriesCatalogFixtures.contributor())
                .email(null);

        final GitLabContributor built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitsIsNullable() {
        final GitLabContributorBuilder builder = GitLabContributorBuilder.builder(
                        RepositoriesCatalogFixtures.contributor())
                .commits(null);

        final GitLabContributor built = builder.build();

        assertThat(built.commits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionsIsNullable() {
        final GitLabContributorBuilder builder = GitLabContributorBuilder.builder(
                        RepositoriesCatalogFixtures.contributor())
                .additions(null);

        final GitLabContributor built = builder.build();

        assertThat(built.additions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletionsIsNullable() {
        final GitLabContributorBuilder builder = GitLabContributorBuilder.builder(
                        RepositoriesCatalogFixtures.contributor())
                .deletions(null);

        final GitLabContributor built = builder.build();

        assertThat(built.deletions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContributor value = RepositoriesCatalogFixtures.contributor();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("John Doe");
            softly.assertThat(value.email()).isEqualTo("johndoe@example.com");
            softly.assertThat(value.commits()).isEqualTo(1);
            softly.assertThat(value.additions()).isEqualTo(1);
            softly.assertThat(value.deletions()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContributor original = RepositoriesCatalogFixtures.contributor();

        final GitLabContributor rebuilt =
                GitLabContributorBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContributor.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "email", "commits", "additions", "deletions");
    }
}
