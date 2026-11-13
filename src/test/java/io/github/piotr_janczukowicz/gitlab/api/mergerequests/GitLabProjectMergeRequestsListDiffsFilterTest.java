package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsListDiffsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUnidiffIsNullable() {
        final GitLabProjectMergeRequestsListDiffsFilterBuilder builder =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder(
                                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                                        .unidiff(true)
                                        .build())
                        .unidiff(null);

        final GitLabProjectMergeRequestsListDiffsFilter built = builder.build();

        assertThat(built.unidiff()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsListDiffsFilter value =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        assertThat(value.unidiff()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsListDiffsFilter original =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final GitLabProjectMergeRequestsListDiffsFilter rebuilt =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsListDiffsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("unidiff");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeRequestsListDiffsFilter empty = GitLabProjectMergeRequestsListDiffsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeRequestsListDiffsFilter filter =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeRequestsListDiffsFilter filter =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeRequestsListDiffsFilter filter =
                GitLabProjectMergeRequestsListDiffsFilterBuilder.builder()
                        .unidiff(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
