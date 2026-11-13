package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHumanApprovalIsNullable() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload())
                        .humanApproval(null);

        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload built = builder.build();

        assertThat(built.humanApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanMessageIsNullable() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload())
                        .humanMessage(null);

        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload built = builder.build();

        assertThat(built.humanMessage()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenHumanMessageIsTooLong() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload())
                        .humanMessage("x".repeat(2001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenHumanMessageHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload())
                        .humanMessage("x".repeat(2000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.humanApproval()).isEqualTo(true);
            softly.assertThat(value.humanMessage()).isEqualTo("Looks good, please proceed");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsResumeWorkflowPayload();

        final GitLabDuoAgentPlatformFlowsResumeWorkflowPayload rebuilt =
                GitLabDuoAgentPlatformFlowsResumeWorkflowPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsResumeWorkflowPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("humanApproval", "humanMessage");
    }
}
