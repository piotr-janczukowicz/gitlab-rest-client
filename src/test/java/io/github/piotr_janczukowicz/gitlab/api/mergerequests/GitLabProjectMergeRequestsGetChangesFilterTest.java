package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsGetChangesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUnidiffIsNullable() {
        final GitLabProjectMergeRequestsGetChangesFilterBuilder builder =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder(
                                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                                        .unidiff(true)
                                        .build())
                        .unidiff(null);

        final GitLabProjectMergeRequestsGetChangesFilter built = builder.build();

        assertThat(built.unidiff()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsGetChangesFilter value =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        assertThat(value.unidiff()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsGetChangesFilter original =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final GitLabProjectMergeRequestsGetChangesFilter rebuilt =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsGetChangesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("unidiff");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeRequestsGetChangesFilter empty = GitLabProjectMergeRequestsGetChangesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeRequestsGetChangesFilter filter =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeRequestsGetChangesFilter filter =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeRequestsGetChangesFilter filter =
                GitLabProjectMergeRequestsGetChangesFilterBuilder.builder()
                        .unidiff(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
