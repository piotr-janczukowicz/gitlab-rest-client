package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenEventTypeIsNull() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsEventPayload())
                        .eventType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("eventType");
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsEventPayload())
                        .message(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCorrelationIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsEventPayload())
                        .correlationId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload built = builder.build();

        assertThat(built.correlationId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsEventPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.eventType()).isEqualTo(GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType.PAUSE);
            softly.assertThat(value.message()).isEqualTo("message");
            softly.assertThat(value.correlationId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsEventPayload();

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateWorkflowsEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("eventType", "message", "correlationId");
    }
}
