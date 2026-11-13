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
class GitLabDuoAgentPlatformFlowsCallWsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkflowIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCallWsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                                        .workflowId("workflow_id")
                                        .environment("environment")
                                        .build())
                        .workflowId(null);

        final GitLabDuoAgentPlatformFlowsCallWsFilter built = builder.build();

        assertThat(built.workflowId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabDuoAgentPlatformFlowsCallWsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                                        .workflowId("workflow_id")
                                        .environment("environment")
                                        .build())
                        .environment(null);

        final GitLabDuoAgentPlatformFlowsCallWsFilter built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenEnvironmentIsTooLong() {
        final GitLabDuoAgentPlatformFlowsCallWsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                                        .workflowId("workflow_id")
                                        .environment("environment")
                                        .build())
                        .environment("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenEnvironmentHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsCallWsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                                        .workflowId("workflow_id")
                                        .environment("environment")
                                        .build())
                        .environment("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter value = GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                .workflowId("workflow_id")
                .environment("environment")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.workflowId()).isEqualTo("workflow_id");
            softly.assertThat(value.environment()).isEqualTo("environment");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter original =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                        .workflowId("workflow_id")
                        .environment("environment")
                        .build();

        final GitLabDuoAgentPlatformFlowsCallWsFilter rebuilt =
                GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoAgentPlatformFlowsCallWsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workflowId", "environment");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter empty = GitLabDuoAgentPlatformFlowsCallWsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter filter = GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                .workflowId("workflow_id")
                .environment("environment")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("workflow_id", "workflow_id"), Map.entry("environment", "environment"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter filter = GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                .workflowId("workflow_id")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("workflow_id", "workflow_id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDuoAgentPlatformFlowsCallWsFilter filter = GitLabDuoAgentPlatformFlowsCallWsFilterBuilder.builder()
                .workflowId("workflow_id")
                .environment("environment")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
