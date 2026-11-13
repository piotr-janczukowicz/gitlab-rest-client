package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentNameIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                                        .experimentName("experiment_name")
                                        .build())
                        .experimentName(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter built = builder.build();

        assertThat(built.experimentName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                        .experimentName("experiment_name")
                        .build();

        assertThat(value.experimentName()).isEqualTo("experiment_name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter original =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                        .experimentName("experiment_name")
                        .build();

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter rebuilt =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentName");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter empty =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                        .experimentName("experiment_name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("experiment_name", "experiment_name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                        .experimentName("experiment_name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("experiment_name", "experiment_name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                        .experimentName("experiment_name")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
