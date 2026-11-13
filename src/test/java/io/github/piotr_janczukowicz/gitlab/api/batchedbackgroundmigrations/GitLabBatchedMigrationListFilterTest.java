package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedMigrationListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedMigrationListFilterBuilder builder = GitLabBatchedMigrationListFilterBuilder.builder(
                        GitLabBatchedMigrationListFilterBuilder.builder()
                                .database(GitLabBatchedMigrationListDatabase.MAIN)
                                .jobClassName("job_class_name")
                                .build())
                .database(null);

        final GitLabBatchedMigrationListFilter built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobClassNameIsNullable() {
        final GitLabBatchedMigrationListFilterBuilder builder = GitLabBatchedMigrationListFilterBuilder.builder(
                        GitLabBatchedMigrationListFilterBuilder.builder()
                                .database(GitLabBatchedMigrationListDatabase.MAIN)
                                .jobClassName("job_class_name")
                                .build())
                .jobClassName(null);

        final GitLabBatchedMigrationListFilter built = builder.build();

        assertThat(built.jobClassName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedMigrationListFilter value = GitLabBatchedMigrationListFilterBuilder.builder()
                .database(GitLabBatchedMigrationListDatabase.MAIN)
                .jobClassName("job_class_name")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.database()).isEqualTo(GitLabBatchedMigrationListDatabase.MAIN);
            softly.assertThat(value.jobClassName()).isEqualTo("job_class_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedMigrationListFilter original = GitLabBatchedMigrationListFilterBuilder.builder()
                .database(GitLabBatchedMigrationListDatabase.MAIN)
                .jobClassName("job_class_name")
                .build();

        final GitLabBatchedMigrationListFilter rebuilt =
                GitLabBatchedMigrationListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedMigrationListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database", "jobClassName");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabBatchedMigrationListFilter empty = GitLabBatchedMigrationListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabBatchedMigrationListFilter filter = GitLabBatchedMigrationListFilterBuilder.builder()
                .database(GitLabBatchedMigrationListDatabase.MAIN)
                .jobClassName("job_class_name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"), Map.entry("job_class_name", "job_class_name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabBatchedMigrationListFilter filter = GitLabBatchedMigrationListFilterBuilder.builder()
                .database(GitLabBatchedMigrationListDatabase.MAIN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabBatchedMigrationListFilter filter = GitLabBatchedMigrationListFilterBuilder.builder()
                .database(GitLabBatchedMigrationListDatabase.MAIN)
                .jobClassName("job_class_name")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
