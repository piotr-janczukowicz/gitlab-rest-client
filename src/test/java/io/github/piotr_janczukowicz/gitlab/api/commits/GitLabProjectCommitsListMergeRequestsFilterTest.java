package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsListMergeRequestsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectCommitsListMergeRequestsFilterBuilder builder =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                                        .state("state")
                                        .build())
                        .state(null);

        final GitLabProjectCommitsListMergeRequestsFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsListMergeRequestsFilter value =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                        .state("state")
                        .build();

        assertThat(value.state()).isEqualTo("state");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsListMergeRequestsFilter original =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                        .state("state")
                        .build();

        final GitLabProjectCommitsListMergeRequestsFilter rebuilt =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsListMergeRequestsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("state");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsListMergeRequestsFilter empty = GitLabProjectCommitsListMergeRequestsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsListMergeRequestsFilter filter =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                        .state("state")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "state"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsListMergeRequestsFilter filter =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                        .state("state")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "state"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsListMergeRequestsFilter filter =
                GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                        .state("state")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
