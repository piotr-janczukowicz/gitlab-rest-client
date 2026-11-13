package io.github.piotr_janczukowicz.gitlab.api.searchadmin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSearchMigrationTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .version(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .name(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .startedAt(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompletedAtIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .completedAt(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.completedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompletedIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .completed(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.completed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenObsoleteIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .obsolete(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.obsolete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMigrationStateIsNullable() {
        final GitLabSearchMigrationBuilder builder = GitLabSearchMigrationBuilder.builder(
                        SearchadminCatalogFixtures.searchMigration())
                .migrationState(null);

        final GitLabSearchMigration built = builder.build();

        assertThat(built.migrationState()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSearchMigration value = SearchadminCatalogFixtures.searchMigration();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo(1);
            softly.assertThat(value.name()).isEqualTo("BackfillHiddenOnMergeRequests");
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.completedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.completed()).isEqualTo(true);
            softly.assertThat(value.obsolete()).isEqualTo(true);
            softly.assertThat(value.migrationState()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSearchMigration original = SearchadminCatalogFixtures.searchMigration();

        final GitLabSearchMigration rebuilt =
                GitLabSearchMigrationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSearchMigration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "version", "name", "startedAt", "completedAt", "completed", "obsolete", "migrationState");
    }
}
