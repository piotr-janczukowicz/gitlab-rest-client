package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .namespaceId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemConsumerIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .aiCatalogItemConsumerId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.aiCatalogItemConsumerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartWorkflowIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .startWorkflow(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.startWorkflow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoalIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .goal(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.goal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .workflowDefinition(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAgentToRequestUserIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .allowAgentToRequestUser(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.allowAgentToRequestUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .image(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.image()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .sourceBranch(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .environment(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemVersionIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .aiCatalogItemVersionId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.aiCatalogItemVersionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalContextIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .additionalContext(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.additionalContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .issueId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.issueId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .mergeRequestId(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built = builder.build();

        assertThat(built.mergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("1");
            softly.assertThat(value.namespaceId()).isEqualTo("1");
            softly.assertThat(value.aiCatalogItemConsumerId()).isEqualTo(1L);
            softly.assertThat(value.startWorkflow()).isEqualTo(true);
            softly.assertThat(value.goal()).isEqualTo("Fix pipeline for merge request 1 in project 1");
            softly.assertThat(value.workflowDefinition()).isEqualTo("software_developer");
            softly.assertThat(value.allowAgentToRequestUser()).isEqualTo(true);
            softly.assertThat(value.image())
                    .isEqualTo("registry.gitlab.com/gitlab-org/duo-workflow/custom-image:latest");
            softly.assertThat(value.sourceBranch()).isEqualTo("main");
            softly.assertThat(value.environment())
                    .isEqualTo(GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment.IDE);
            softly.assertThat(value.aiCatalogItemVersionId()).isEqualTo(1L);
            softly.assertThat(value.additionalContext())
                    .isEqualTo(List.of(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext()));
            softly.assertThat(value.issueId()).isEqualTo(1L);
            softly.assertThat(value.mergeRequestId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload();

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAdditionalContextSourceChangesLater() {
        final List<GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext> source = new ArrayList<>(List.of(
                GitlabduoagentplatformflowsCatalogFixtures
                        .duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext()));
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowPayload())
                        .additionalContext(source)
                        .build();
        source.clear();

        assertThat(built.additionalContext()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAdditionalContextIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowPayload();
        final List<GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext> values = built.additionalContext();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateAgentWorkflowPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectId",
                        "namespaceId",
                        "aiCatalogItemConsumerId",
                        "startWorkflow",
                        "goal",
                        "workflowDefinition",
                        "allowAgentToRequestUser",
                        "image",
                        "sourceBranch",
                        "environment",
                        "aiCatalogItemVersionId",
                        "additionalContext",
                        "issueId",
                        "mergeRequestId");
    }
}
