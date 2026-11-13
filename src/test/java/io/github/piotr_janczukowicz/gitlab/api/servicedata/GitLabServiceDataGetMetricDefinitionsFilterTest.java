package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataGetMetricDefinitionsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludePathsIsNullable() {
        final GitLabServiceDataGetMetricDefinitionsFilterBuilder builder =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder(
                                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                                        .includePaths(true)
                                        .build())
                        .includePaths(null);

        final GitLabServiceDataGetMetricDefinitionsFilter built = builder.build();

        assertThat(built.includePaths()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceDataGetMetricDefinitionsFilter value =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                        .includePaths(true)
                        .build();

        assertThat(value.includePaths()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceDataGetMetricDefinitionsFilter original =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                        .includePaths(true)
                        .build();

        final GitLabServiceDataGetMetricDefinitionsFilter rebuilt =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabServiceDataGetMetricDefinitionsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includePaths");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabServiceDataGetMetricDefinitionsFilter empty = GitLabServiceDataGetMetricDefinitionsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabServiceDataGetMetricDefinitionsFilter filter =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                        .includePaths(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_paths", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabServiceDataGetMetricDefinitionsFilter filter =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                        .includePaths(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_paths", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabServiceDataGetMetricDefinitionsFilter filter =
                GitLabServiceDataGetMetricDefinitionsFilterBuilder.builder()
                        .includePaths(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
