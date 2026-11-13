package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectLevelVariablesDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFilterEnvironmentScopeIsNullable() {
        final GitLabProjectProjectLevelVariablesDeleteFilterBuilder builder =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder(
                                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                                        .filterEnvironmentScope("filter[environment_scope]")
                                        .build())
                        .filterEnvironmentScope(null);

        final GitLabProjectProjectLevelVariablesDeleteFilter built = builder.build();

        assertThat(built.filterEnvironmentScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectLevelVariablesDeleteFilter value =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        assertThat(value.filterEnvironmentScope()).isEqualTo("filter[environment_scope]");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectLevelVariablesDeleteFilter original =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final GitLabProjectProjectLevelVariablesDeleteFilter rebuilt =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectLevelVariablesDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filterEnvironmentScope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectLevelVariablesDeleteFilter empty =
                GitLabProjectProjectLevelVariablesDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectLevelVariablesDeleteFilter filter =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("filter[environment_scope]", "filter[environment_scope]"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectLevelVariablesDeleteFilter filter =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("filter[environment_scope]", "filter[environment_scope]"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectLevelVariablesDeleteFilter filter =
                GitLabProjectProjectLevelVariablesDeleteFilterBuilder.builder()
                        .filterEnvironmentScope("filter[environment_scope]")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
