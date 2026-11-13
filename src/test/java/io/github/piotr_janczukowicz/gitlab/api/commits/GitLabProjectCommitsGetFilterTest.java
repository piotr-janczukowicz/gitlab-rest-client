package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatsIsNullable() {
        final GitLabProjectCommitsGetFilterBuilder builder = GitLabProjectCommitsGetFilterBuilder.builder(
                        GitLabProjectCommitsGetFilterBuilder.builder()
                                .stats(true)
                                .build())
                .stats(null);

        final GitLabProjectCommitsGetFilter built = builder.build();

        assertThat(built.stats()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsGetFilter value =
                GitLabProjectCommitsGetFilterBuilder.builder().stats(true).build();

        assertThat(value.stats()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsGetFilter original =
                GitLabProjectCommitsGetFilterBuilder.builder().stats(true).build();

        final GitLabProjectCommitsGetFilter rebuilt =
                GitLabProjectCommitsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("stats");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsGetFilter empty = GitLabProjectCommitsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsGetFilter filter =
                GitLabProjectCommitsGetFilterBuilder.builder().stats(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("stats", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsGetFilter filter =
                GitLabProjectCommitsGetFilterBuilder.builder().stats(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("stats", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsGetFilter filter =
                GitLabProjectCommitsGetFilterBuilder.builder().stats(true).build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
