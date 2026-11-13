package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectLevelVariablesGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFilterEnvironmentScopeIsNullable() {
        final GitLabProjectProjectLevelVariablesGetFilterBuilder builder =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder(
                                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                                        .filterEnvironmentScope("filter[environment_scope]")
                                        .build())
                        .filterEnvironmentScope(null);

        final GitLabProjectProjectLevelVariablesGetFilter built = builder.build();

        assertThat(built.filterEnvironmentScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectLevelVariablesGetFilter value =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        assertThat(value.filterEnvironmentScope()).isEqualTo("filter[environment_scope]");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectLevelVariablesGetFilter original =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final GitLabProjectProjectLevelVariablesGetFilter rebuilt =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectLevelVariablesGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filterEnvironmentScope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectLevelVariablesGetFilter empty = GitLabProjectProjectLevelVariablesGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectLevelVariablesGetFilter filter =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("filter[environment_scope]", "filter[environment_scope]"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectLevelVariablesGetFilter filter =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("filter[environment_scope]", "filter[environment_scope]"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectLevelVariablesGetFilter filter =
                GitLabProjectProjectLevelVariablesGetFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
