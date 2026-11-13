package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsListPipelinesJobsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludeRetriedIsNullable() {
        final GitLabProjectJobsListPipelinesJobsFilterBuilder builder =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder(
                                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                                        .includeRetried(true)
                                        .scope(List.of("text"))
                                        .build())
                        .includeRetried(null);

        final GitLabProjectJobsListPipelinesJobsFilter built = builder.build();

        assertThat(built.includeRetried()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectJobsListPipelinesJobsFilterBuilder builder =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder(
                                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                                        .includeRetried(true)
                                        .scope(List.of("text"))
                                        .build())
                        .scope(null);

        final GitLabProjectJobsListPipelinesJobsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsListPipelinesJobsFilter value = GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                .includeRetried(true)
                .scope(List.of("text"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.includeRetried()).isEqualTo(true);
            softly.assertThat(value.scope()).isEqualTo(List.of("text"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsListPipelinesJobsFilter original =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                        .includeRetried(true)
                        .scope(List.of("text"))
                        .build();

        final GitLabProjectJobsListPipelinesJobsFilter rebuilt =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectJobsListPipelinesJobsFilter built = GitLabProjectJobsListPipelinesJobsFilterBuilder.builder(
                        GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                                .includeRetried(true)
                                .scope(List.of("text"))
                                .build())
                .scope(source)
                .build();
        source.clear();

        assertThat(built.scope()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopeIsRead() {
        final GitLabProjectJobsListPipelinesJobsFilter built = GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                .includeRetried(true)
                .scope(List.of("text"))
                .build();
        final List<String> values = built.scope();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsListPipelinesJobsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includeRetried", "scope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsListPipelinesJobsFilter empty = GitLabProjectJobsListPipelinesJobsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsListPipelinesJobsFilter filter =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                        .includeRetried(true)
                        .scope(List.of("text"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_retried", "true"), Map.entry("scope", "text"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsListPipelinesJobsFilter filter =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                        .includeRetried(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_retried", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsListPipelinesJobsFilter filter =
                GitLabProjectJobsListPipelinesJobsFilterBuilder.builder()
                        .includeRetried(true)
                        .scope(List.of("text"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
