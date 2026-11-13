package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExperimentsDeleteAssignmentFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabExperimentsDeleteAssignmentFilterBuilder builder =
                GitLabExperimentsDeleteAssignmentFilterBuilder.builder(
                                GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                                        .context(Map.of("key", "value"))
                                        .build())
                        .context(null);

        final GitLabExperimentsDeleteAssignmentFilter built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperimentsDeleteAssignmentFilter value = GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        assertThat(value.context()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperimentsDeleteAssignmentFilter original =
                GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                        .context(Map.of("key", "value"))
                        .build();

        final GitLabExperimentsDeleteAssignmentFilter rebuilt =
                GitLabExperimentsDeleteAssignmentFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenContextSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabExperimentsDeleteAssignmentFilter built = GitLabExperimentsDeleteAssignmentFilterBuilder.builder(
                        GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                                .context(Map.of("key", "value"))
                                .build())
                .context(source)
                .build();
        source.clear();

        assertThat(built.context()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperimentsDeleteAssignmentFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("context");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabExperimentsDeleteAssignmentFilter empty = GitLabExperimentsDeleteAssignmentFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabExperimentsDeleteAssignmentFilter filter = GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("context[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabExperimentsDeleteAssignmentFilter filter = GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("context[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabExperimentsDeleteAssignmentFilter filter = GitLabExperimentsDeleteAssignmentFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
