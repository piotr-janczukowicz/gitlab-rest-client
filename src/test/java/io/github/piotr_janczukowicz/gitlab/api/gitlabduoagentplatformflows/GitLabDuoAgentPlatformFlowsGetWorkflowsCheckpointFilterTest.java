package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAcceptCompressedIsNullable() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .build())
                        .acceptCompressed(null);

        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter built = builder.build();

        assertThat(built.acceptCompressed()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter value =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();

        assertThat(value.acceptCompressed()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter original =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();

        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter rebuilt =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("acceptCompressed");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter empty =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter filter =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("accept_compressed", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter filter =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("accept_compressed", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilter filter =
                GitLabDuoAgentPlatformFlowsGetWorkflowsCheckpointFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
