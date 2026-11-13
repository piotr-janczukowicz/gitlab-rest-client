package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsGetVersionFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUnidiffIsNullable() {
        final GitLabProjectMergeRequestsGetVersionFilterBuilder builder =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder(
                                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                                        .unidiff(true)
                                        .build())
                        .unidiff(null);

        final GitLabProjectMergeRequestsGetVersionFilter built = builder.build();

        assertThat(built.unidiff()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsGetVersionFilter value =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        assertThat(value.unidiff()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsGetVersionFilter original =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final GitLabProjectMergeRequestsGetVersionFilter rebuilt =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsGetVersionFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("unidiff");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeRequestsGetVersionFilter empty = GitLabProjectMergeRequestsGetVersionFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeRequestsGetVersionFilter filter =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeRequestsGetVersionFilter filter =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeRequestsGetVersionFilter filter =
                GitLabProjectMergeRequestsGetVersionFilterBuilder.builder()
                        .unidiff(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
