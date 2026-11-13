package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                                        .experimentId("experiment_id")
                                        .build())
                        .experimentId(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                        .experimentId("experiment_id")
                        .build();

        assertThat(value.experimentId()).isEqualTo("experiment_id");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter original =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                        .experimentId("experiment_id")
                        .build();

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter rebuilt =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter empty =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                        .experimentId("experiment_id")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("experiment_id", "experiment_id"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                        .experimentId("experiment_id")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("experiment_id", "experiment_id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                        .experimentId("experiment_id")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
