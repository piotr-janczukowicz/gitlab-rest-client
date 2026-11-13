package io.github.piotr_janczukowicz.gitlab.api.migrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMigrationsCallPendingFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabMigrationsCallPendingFilterBuilder builder = GitLabMigrationsCallPendingFilterBuilder.builder(
                        GitLabMigrationsCallPendingFilterBuilder.builder()
                                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                                .build())
                .database(null);

        final GitLabMigrationsCallPendingFilter built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMigrationsCallPendingFilter value = GitLabMigrationsCallPendingFilterBuilder.builder()
                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                .build();

        assertThat(value.database()).isEqualTo(GitLabMigrationsCallPendingDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMigrationsCallPendingFilter original = GitLabMigrationsCallPendingFilterBuilder.builder()
                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                .build();

        final GitLabMigrationsCallPendingFilter rebuilt =
                GitLabMigrationsCallPendingFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMigrationsCallPendingFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabMigrationsCallPendingFilter empty = GitLabMigrationsCallPendingFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabMigrationsCallPendingFilter filter = GitLabMigrationsCallPendingFilterBuilder.builder()
                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabMigrationsCallPendingFilter filter = GitLabMigrationsCallPendingFilterBuilder.builder()
                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("database", "main"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabMigrationsCallPendingFilter filter = GitLabMigrationsCallPendingFilterBuilder.builder()
                .database(GitLabMigrationsCallPendingDatabase.MAIN)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
