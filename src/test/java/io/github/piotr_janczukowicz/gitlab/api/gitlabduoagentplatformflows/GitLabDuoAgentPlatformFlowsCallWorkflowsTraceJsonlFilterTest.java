package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFullIsNullable() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                                        .full(true)
                                        .thread("thread")
                                        .build())
                        .full(null);

        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter built = builder.build();

        assertThat(built.full()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadIsNullable() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                                        .full(true)
                                        .thread("thread")
                                        .build())
                        .thread(null);

        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter built = builder.build();

        assertThat(built.thread()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter value =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                        .full(true)
                        .thread("thread")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.full()).isEqualTo(true);
            softly.assertThat(value.thread()).isEqualTo("thread");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter original =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                        .full(true)
                        .thread("thread")
                        .build();

        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter rebuilt =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("full", "thread");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter empty =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter filter =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                        .full(true)
                        .thread("thread")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("full", "true"), Map.entry("thread", "thread"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter filter =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                        .full(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("full", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilter filter =
                GitLabDuoAgentPlatformFlowsCallWorkflowsTraceJsonlFilterBuilder.builder()
                        .full(true)
                        .thread("thread")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
