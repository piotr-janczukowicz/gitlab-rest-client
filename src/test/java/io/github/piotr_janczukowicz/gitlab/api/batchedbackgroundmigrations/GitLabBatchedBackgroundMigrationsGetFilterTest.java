package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedBackgroundMigrationsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedBackgroundMigrationsGetFilterBuilder builder =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder(
                                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                                        .build())
                        .database(null);

        final GitLabBatchedBackgroundMigrationsGetFilter built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundMigrationsGetFilter value =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                        .build();

        assertThat(value.database()).isEqualTo(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundMigrationsGetFilter original =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                        .build();

        final GitLabBatchedBackgroundMigrationsGetFilter rebuilt =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundMigrationsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabBatchedBackgroundMigrationsGetFilter empty = GitLabBatchedBackgroundMigrationsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabBatchedBackgroundMigrationsGetFilter filter =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabBatchedBackgroundMigrationsGetFilter filter =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabBatchedBackgroundMigrationsGetFilter filter =
                GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                        .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
