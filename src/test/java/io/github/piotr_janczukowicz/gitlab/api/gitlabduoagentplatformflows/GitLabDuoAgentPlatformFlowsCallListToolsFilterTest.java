package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCallListToolsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                                        .workflowDefinition("workflow_definition")
                                        .build())
                        .workflowDefinition(null);

        final GitLabDuoAgentPlatformFlowsCallListToolsFilter built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter value =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                        .workflowDefinition("workflow_definition")
                        .build();

        assertThat(value.workflowDefinition()).isEqualTo("workflow_definition");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter original =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                        .workflowDefinition("workflow_definition")
                        .build();

        final GitLabDuoAgentPlatformFlowsCallListToolsFilter rebuilt =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoAgentPlatformFlowsCallListToolsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workflowDefinition");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter empty =
                GitLabDuoAgentPlatformFlowsCallListToolsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter filter =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                        .workflowDefinition("workflow_definition")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("workflow_definition", "workflow_definition"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter filter =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                        .workflowDefinition("workflow_definition")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("workflow_definition", "workflow_definition"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDuoAgentPlatformFlowsCallListToolsFilter filter =
                GitLabDuoAgentPlatformFlowsCallListToolsFilterBuilder.builder()
                        .workflowDefinition("workflow_definition")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
