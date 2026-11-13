package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiDuoWorkflowsWorkflowTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .id(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .webUrl(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .projectId(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .namespaceId(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentPrivilegesIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .agentPrivileges(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.agentPrivileges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentPrivilegesNamesIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .agentPrivilegesNames(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.agentPrivilegesNames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreApprovedAgentPrivilegesIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .preApprovedAgentPrivileges(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.preApprovedAgentPrivileges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreApprovedAgentPrivilegesNamesIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .preApprovedAgentPrivilegesNames(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.preApprovedAgentPrivilegesNames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .workflowDefinition(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .status(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSummaryIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .summary(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.summary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .title(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAgentToRequestUserIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .allowAgentToRequestUser(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.allowAgentToRequestUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .image(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.image()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .environment(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemVersionIdIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .aiCatalogItemVersionId(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.aiCatalogItemVersionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .workload(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.workload()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMcpEnabledIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .mcpEnabled(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.mcpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncrementalCheckpointsEnabledIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .incrementalCheckpointsEnabled(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.incrementalCheckpointsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabUrlIsNullable() {
        final GitLabAiDuoWorkflowsWorkflowBuilder builder = GitLabAiDuoWorkflowsWorkflowBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow())
                .gitlabUrl(null);

        final GitLabAiDuoWorkflowsWorkflow built = builder.build();

        assertThat(built.gitlabUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiDuoWorkflowsWorkflow value = GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/group/project/-/automate/agent-sessions/42");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.agentPrivileges()).isEqualTo(List.of(1));
            softly.assertThat(value.agentPrivilegesNames()).isEqualTo(List.of("agent_privileges_names"));
            softly.assertThat(value.preApprovedAgentPrivileges()).isEqualTo(List.of(1));
            softly.assertThat(value.preApprovedAgentPrivilegesNames())
                    .isEqualTo(List.of("pre_approved_agent_privileges_names"));
            softly.assertThat(value.workflowDefinition()).isEqualTo("workflow_definition");
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.summary()).isEqualTo("summary");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.allowAgentToRequestUser()).isEqualTo(true);
            softly.assertThat(value.image()).isEqualTo("image");
            softly.assertThat(value.environment()).isEqualTo("environment");
            softly.assertThat(value.aiCatalogItemVersionId()).isEqualTo(1L);
            softly.assertThat(value.workload()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.mcpEnabled()).isEqualTo(true);
            softly.assertThat(value.incrementalCheckpointsEnabled()).isEqualTo(true);
            softly.assertThat(value.gitlabUrl()).isEqualTo("gitlab_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiDuoWorkflowsWorkflow original =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsWorkflow();

        final GitLabAiDuoWorkflowsWorkflow rebuilt =
                GitLabAiDuoWorkflowsWorkflowBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiDuoWorkflowsWorkflow.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "webUrl",
                        "projectId",
                        "namespaceId",
                        "agentPrivileges",
                        "agentPrivilegesNames",
                        "preApprovedAgentPrivileges",
                        "preApprovedAgentPrivilegesNames",
                        "workflowDefinition",
                        "status",
                        "summary",
                        "title",
                        "allowAgentToRequestUser",
                        "image",
                        "environment",
                        "aiCatalogItemVersionId",
                        "workload",
                        "mcpEnabled",
                        "incrementalCheckpointsEnabled",
                        "gitlabUrl");
    }
}
