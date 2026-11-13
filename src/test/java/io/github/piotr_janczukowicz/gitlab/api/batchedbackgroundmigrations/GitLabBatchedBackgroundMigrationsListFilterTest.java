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
class GitLabBatchedBackgroundMigrationsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedBackgroundMigrationsListFilterBuilder builder =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder(
                                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                                        .jobClassName("job_class_name")
                                        .build())
                        .database(null);

        final GitLabBatchedBackgroundMigrationsListFilter built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobClassNameIsNullable() {
        final GitLabBatchedBackgroundMigrationsListFilterBuilder builder =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder(
                                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                                        .jobClassName("job_class_name")
                                        .build())
                        .jobClassName(null);

        final GitLabBatchedBackgroundMigrationsListFilter built = builder.build();

        assertThat(built.jobClassName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundMigrationsListFilter value =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                        .jobClassName("job_class_name")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.database()).isEqualTo(GitLabBatchedBackgroundMigrationsListDatabase.MAIN);
            softly.assertThat(value.jobClassName()).isEqualTo("job_class_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundMigrationsListFilter original =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                        .jobClassName("job_class_name")
                        .build();

        final GitLabBatchedBackgroundMigrationsListFilter rebuilt =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundMigrationsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database", "jobClassName");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabBatchedBackgroundMigrationsListFilter empty = GitLabBatchedBackgroundMigrationsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabBatchedBackgroundMigrationsListFilter filter =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                        .jobClassName("job_class_name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"), Map.entry("job_class_name", "job_class_name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabBatchedBackgroundMigrationsListFilter filter =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabBatchedBackgroundMigrationsListFilter filter =
                GitLabBatchedBackgroundMigrationsListFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsListDatabase.MAIN)
                        .jobClassName("job_class_name")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
