package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenProjectIdIsTooLong() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .projectId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenProjectIdHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .projectId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .namespaceId(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNamespaceIdIsTooLong() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .namespaceId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNamespaceIdHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .namespaceId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootNamespaceIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .rootNamespaceId(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.rootNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenRootNamespaceIdIsTooLong() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .rootNamespaceId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenRootNamespaceIdHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .rootNamespaceId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogItemVersionIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .aiCatalogItemVersionId(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.aiCatalogItemVersionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientTypeIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .clientType(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.clientType()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenClientTypeIsTooLong() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .clientType("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenClientTypeHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .clientType("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserSelectedModelIdentifierIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .userSelectedModelIdentifier(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.userSelectedModelIdentifier()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenUserSelectedModelIdentifierIsTooLong() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .userSelectedModelIdentifier("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenUserSelectedModelIdentifierHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .userSelectedModelIdentifier("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetachedIsNullable() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsExecuteWorkflowPayload())
                        .detached(null);

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload built = builder.build();

        assertThat(built.detached()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("1");
            softly.assertThat(value.namespaceId()).isEqualTo("1");
            softly.assertThat(value.rootNamespaceId()).isEqualTo("1");
            softly.assertThat(value.aiCatalogItemVersionId()).isEqualTo(1L);
            softly.assertThat(value.clientType()).isEqualTo("browser");
            softly.assertThat(value.userSelectedModelIdentifier()).isEqualTo("claude_sonnet_4_5");
            softly.assertThat(value.detached()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsExecuteWorkflowPayload();

        final GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload rebuilt =
                GitLabDuoAgentPlatformFlowsExecuteWorkflowPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsExecuteWorkflowPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectId",
                        "namespaceId",
                        "rootNamespaceId",
                        "aiCatalogItemVersionId",
                        "clientType",
                        "userSelectedModelIdentifier",
                        "detached");
    }
}
