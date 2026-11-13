package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRunUuidIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                                        .runUuid("run_uuid")
                                        .build())
                        .runUuid(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter built = builder.build();

        assertThat(built.runUuid()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                        .runUuid("run_uuid")
                        .build();

        assertThat(value.runUuid()).isEqualTo("run_uuid");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter original =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                        .runUuid("run_uuid")
                        .build();

        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter rebuilt =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runUuid");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter empty =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                        .runUuid("run_uuid")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("run_uuid", "run_uuid"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                        .runUuid("run_uuid")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("run_uuid", "run_uuid"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                        .runUuid("run_uuid")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
