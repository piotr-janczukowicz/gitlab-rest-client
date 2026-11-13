package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectPipelineSchedulesListFilterBuilder builder =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                                        .build())
                        .scope(null);

        final GitLabProjectPipelineSchedulesListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesListFilter value = GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                .build();

        assertThat(value.scope()).isEqualTo(GitLabProjectPipelineSchedulesListScope.ACTIVE);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesListFilter original =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                        .build();

        final GitLabProjectPipelineSchedulesListFilter rebuilt =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineSchedulesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelineSchedulesListFilter empty = GitLabProjectPipelineSchedulesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelineSchedulesListFilter filter =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelineSchedulesListFilter filter =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelineSchedulesListFilter filter =
                GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
