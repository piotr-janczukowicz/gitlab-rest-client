package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesListTriggerJobsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectPipelinesListTriggerJobsFilterBuilder builder =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder(
                                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                                        .scope(List.of("text"))
                                        .build())
                        .scope(null);

        final GitLabProjectPipelinesListTriggerJobsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesListTriggerJobsFilter value =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();

        assertThat(value.scope()).isEqualTo(List.of("text"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesListTriggerJobsFilter original =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();

        final GitLabProjectPipelinesListTriggerJobsFilter rebuilt =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectPipelinesListTriggerJobsFilter built =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder(
                                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                                        .scope(List.of("text"))
                                        .build())
                        .scope(source)
                        .build();
        source.clear();

        assertThat(built.scope()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopeIsRead() {
        final GitLabProjectPipelinesListTriggerJobsFilter built =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();
        final List<String> values = built.scope();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesListTriggerJobsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelinesListTriggerJobsFilter empty = GitLabProjectPipelinesListTriggerJobsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelinesListTriggerJobsFilter filter =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "text"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelinesListTriggerJobsFilter filter =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "text"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelinesListTriggerJobsFilter filter =
                GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
