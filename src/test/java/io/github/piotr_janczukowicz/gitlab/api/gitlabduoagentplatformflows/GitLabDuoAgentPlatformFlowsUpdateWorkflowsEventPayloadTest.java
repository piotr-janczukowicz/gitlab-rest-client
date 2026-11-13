package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenEventStatusIsNull() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsUpdateWorkflowsEventPayload())
                        .eventStatus(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("eventStatus");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowsEventPayload();

        assertThat(value.eventStatus()).isEqualTo(GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.QUEUED);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowsEventPayload();

        final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload rebuilt =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("eventStatus");
    }
}
