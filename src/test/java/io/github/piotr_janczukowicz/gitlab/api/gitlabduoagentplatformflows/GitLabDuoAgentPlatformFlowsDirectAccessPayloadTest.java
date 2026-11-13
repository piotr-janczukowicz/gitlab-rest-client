package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsDirectAccessPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload())
                        .workflowDefinition(null);

        final GitLabDuoAgentPlatformFlowsDirectAccessPayload built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootNamespaceIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload())
                        .rootNamespaceId(null);

        final GitLabDuoAgentPlatformFlowsDirectAccessPayload built = builder.build();

        assertThat(built.rootNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsDirectAccessPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsDirectAccessPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.workflowDefinition()).isEqualTo("software_developer");
            softly.assertThat(value.rootNamespaceId()).isEqualTo("1");
            softly.assertThat(value.projectId()).isEqualTo("1");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsDirectAccessPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsDirectAccessPayload();

        final GitLabDuoAgentPlatformFlowsDirectAccessPayload rebuilt =
                GitLabDuoAgentPlatformFlowsDirectAccessPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoAgentPlatformFlowsDirectAccessPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workflowDefinition", "rootNamespaceId", "projectId");
    }
}
