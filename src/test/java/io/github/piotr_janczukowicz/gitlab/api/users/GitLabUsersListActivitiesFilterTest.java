package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersListActivitiesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFromValueIsNullable() {
        final GitLabUsersListActivitiesFilterBuilder builder = GitLabUsersListActivitiesFilterBuilder.builder(
                        GitLabUsersListActivitiesFilterBuilder.builder()
                                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .fromValue(null);

        final GitLabUsersListActivitiesFilter built = builder.build();

        assertThat(built.fromValue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersListActivitiesFilter value = GitLabUsersListActivitiesFilterBuilder.builder()
                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        assertThat(value.fromValue()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersListActivitiesFilter original = GitLabUsersListActivitiesFilterBuilder.builder()
                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final GitLabUsersListActivitiesFilter rebuilt =
                GitLabUsersListActivitiesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersListActivitiesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fromValue");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabUsersListActivitiesFilter empty = GitLabUsersListActivitiesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabUsersListActivitiesFilter filter = GitLabUsersListActivitiesFilterBuilder.builder()
                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("from", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabUsersListActivitiesFilter filter = GitLabUsersListActivitiesFilterBuilder.builder()
                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("from", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabUsersListActivitiesFilter filter = GitLabUsersListActivitiesFilterBuilder.builder()
                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
