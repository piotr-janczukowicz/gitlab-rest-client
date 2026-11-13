package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusEventIsNullable() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload())
                        .statusEvent(null);

        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload built = builder.build();

        assertThat(built.statusEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDropReasonIsNullable() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload())
                        .dropReason(null);

        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload built = builder.build();

        assertThat(built.dropReason()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenDropReasonIsTooLong() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload())
                        .dropReason("x".repeat(65));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenDropReasonHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload())
                        .dropReason("x".repeat(64));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.statusEvent()).isEqualTo("finish");
            softly.assertThat(value.dropReason()).isEqualTo("token_rejected");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsUpdateWorkflowPayload();

        final GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload rebuilt =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsUpdateWorkflowPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("statusEvent", "dropReason");
    }
}
