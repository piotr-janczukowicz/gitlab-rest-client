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
class GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .namespaceId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemConsumerIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .aiCatalogItemConsumerId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.aiCatalogItemConsumerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartWorkflowIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .startWorkflow(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.startWorkflow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoalIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .goal(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.goal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentPrivilegesIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .agentPrivileges(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.agentPrivileges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreApprovedAgentPrivilegesIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .preApprovedAgentPrivileges(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.preApprovedAgentPrivileges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .workflowDefinition(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAgentToRequestUserIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .allowAgentToRequestUser(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.allowAgentToRequestUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .image(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.image()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .sourceBranch(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .environment(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemVersionIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .aiCatalogItemVersionId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.aiCatalogItemVersionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalContextIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .additionalContext(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.additionalContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .issueId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.issueId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .mergeRequestId(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.mergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .source(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("1");
            softly.assertThat(value.namespaceId()).isEqualTo("1");
            softly.assertThat(value.aiCatalogItemConsumerId()).isEqualTo(1L);
            softly.assertThat(value.startWorkflow()).isEqualTo(true);
            softly.assertThat(value.goal()).isEqualTo("Fix pipeline for merge request 1 in project 1");
            softly.assertThat(value.agentPrivileges()).isEqualTo(List.of(1));
            softly.assertThat(value.preApprovedAgentPrivileges()).isEqualTo(List.of(1));
            softly.assertThat(value.workflowDefinition()).isEqualTo("software_developer");
            softly.assertThat(value.allowAgentToRequestUser()).isEqualTo(true);
            softly.assertThat(value.image())
                    .isEqualTo("registry.gitlab.com/gitlab-org/duo-workflow/custom-image:latest");
            softly.assertThat(value.sourceBranch()).isEqualTo("main");
            softly.assertThat(value.environment()).isEqualTo(GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.IDE);
            softly.assertThat(value.aiCatalogItemVersionId()).isEqualTo(1L);
            softly.assertThat(value.additionalContext())
                    .isEqualTo(List.of(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateWorkflowAdditionalContext()));
            softly.assertThat(value.issueId()).isEqualTo(1L);
            softly.assertThat(value.mergeRequestId()).isEqualTo(1L);
            softly.assertThat(value.source())
                    .isEqualTo(GitLabDuoAgentPlatformFlowsCreateWorkflowSource.MERGE_REQUEST_CODE_CONFLICT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload();

        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAgentPrivilegesSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .agentPrivileges(source)
                        .build();
        source.clear();

        assertThat(built.agentPrivileges()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAgentPrivilegesIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload();
        final List<Integer> values = built.agentPrivileges();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenPreApprovedAgentPrivilegesSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .preApprovedAgentPrivileges(source)
                        .build();
        source.clear();

        assertThat(built.preApprovedAgentPrivileges()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenPreApprovedAgentPrivilegesIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload();
        final List<Integer> values = built.preApprovedAgentPrivileges();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAdditionalContextSourceChangesLater() {
        final List<GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext> source = new ArrayList<>(List.of(
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowAdditionalContext()));
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitLabDuoAgentPlatformFlowsCreateWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload())
                        .additionalContext(source)
                        .build();
        source.clear();

        assertThat(built.additionalContext()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAdditionalContextIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowPayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowPayload();
        final List<GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext> values = built.additionalContext();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateWorkflowPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectId",
                        "namespaceId",
                        "aiCatalogItemConsumerId",
                        "startWorkflow",
                        "goal",
                        "agentPrivileges",
                        "preApprovedAgentPrivileges",
                        "workflowDefinition",
                        "allowAgentToRequestUser",
                        "image",
                        "sourceBranch",
                        "environment",
                        "aiCatalogItemVersionId",
                        "additionalContext",
                        "issueId",
                        "mergeRequestId",
                        "source");
    }
}
