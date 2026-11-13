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
class GitLabExperimentsGetAssignmentsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabExperimentsGetAssignmentsFilterBuilder builder =
                GitLabExperimentsGetAssignmentsFilterBuilder.builder(
                                GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                                        .context(Map.of("key", "value"))
                                        .build())
                        .context(null);

        final GitLabExperimentsGetAssignmentsFilter built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperimentsGetAssignmentsFilter value = GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        assertThat(value.context()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperimentsGetAssignmentsFilter original = GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        final GitLabExperimentsGetAssignmentsFilter rebuilt =
                GitLabExperimentsGetAssignmentsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenContextSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabExperimentsGetAssignmentsFilter built = GitLabExperimentsGetAssignmentsFilterBuilder.builder(
                        GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                                .context(Map.of("key", "value"))
                                .build())
                .context(source)
                .build();
        source.clear();

        assertThat(built.context()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperimentsGetAssignmentsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("context");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabExperimentsGetAssignmentsFilter empty = GitLabExperimentsGetAssignmentsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabExperimentsGetAssignmentsFilter filter = GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("context[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabExperimentsGetAssignmentsFilter filter = GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("context[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabExperimentsGetAssignmentsFilter filter = GitLabExperimentsGetAssignmentsFilterBuilder.builder()
                .context(Map.of("key", "value"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
