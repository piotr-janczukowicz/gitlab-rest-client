package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedMigrationGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedMigrationGetFilterBuilder builder = GitLabBatchedMigrationGetFilterBuilder.builder(
                        GitLabBatchedMigrationGetFilterBuilder.builder()
                                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                                .build())
                .database(null);

        final GitLabBatchedMigrationGetFilter built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedMigrationGetFilter value = GitLabBatchedMigrationGetFilterBuilder.builder()
                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                .build();

        assertThat(value.database()).isEqualTo(GitLabBatchedMigrationGetDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedMigrationGetFilter original = GitLabBatchedMigrationGetFilterBuilder.builder()
                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                .build();

        final GitLabBatchedMigrationGetFilter rebuilt =
                GitLabBatchedMigrationGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedMigrationGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabBatchedMigrationGetFilter empty = GitLabBatchedMigrationGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabBatchedMigrationGetFilter filter = GitLabBatchedMigrationGetFilterBuilder.builder()
                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabBatchedMigrationGetFilter filter = GitLabBatchedMigrationGetFilterBuilder.builder()
                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabBatchedMigrationGetFilter filter = GitLabBatchedMigrationGetFilterBuilder.builder()
                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
