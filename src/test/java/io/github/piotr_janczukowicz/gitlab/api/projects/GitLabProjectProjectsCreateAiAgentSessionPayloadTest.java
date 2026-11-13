package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateAiAgentSessionPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAgentTypeIsNull() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .agentType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("agentType");
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentIdentityIdIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .agentIdentityId(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.agentIdentityId()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenSyncTypeIsNull() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .syncType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("syncType");
    }

    @Test
    void constructor_shouldAcceptNull_whenGoalIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .goal(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.goal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .startedAt(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdempotencyKeyIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .idempotencyKey(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.idempotencyKey()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenIdempotencyKeyIsTooLong() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .idempotencyKey("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenIdempotencyKeyHasTheMaximumLength() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .idempotencyKey("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowDefinitionIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .workflowDefinition(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.workflowDefinition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlabVersionIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .glabVersion(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.glabVersion()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenGlabVersionIsTooLong() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .glabVersion("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenGlabVersionHasTheMaximumLength() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .glabVersion("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentVersionIsNullable() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .agentVersion(null);

        final GitLabProjectProjectsCreateAiAgentSessionPayload built = builder.build();

        assertThat(built.agentVersion()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenAgentVersionIsTooLong() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .agentVersion("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenAgentVersionHasTheMaximumLength() {
        final GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload())
                        .agentVersion("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateAiAgentSessionPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.agentType())
                    .isEqualTo(GitLabProjectProjectsCreateAiAgentSessionAgentType.CLAUDE_CODE);
            softly.assertThat(value.agentIdentityId()).isEqualTo(1L);
            softly.assertThat(value.syncType()).isEqualTo(GitLabProjectProjectsCreateAiAgentSessionSyncType.HOOK);
            softly.assertThat(value.goal()).isEqualTo("goal");
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.idempotencyKey()).isEqualTo("idempotency_key");
            softly.assertThat(value.workflowDefinition()).isEqualTo("workflow_definition");
            softly.assertThat(value.glabVersion()).isEqualTo("glab_version");
            softly.assertThat(value.agentVersion()).isEqualTo("agent_version");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateAiAgentSessionPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload();

        final GitLabProjectProjectsCreateAiAgentSessionPayload rebuilt =
                GitLabProjectProjectsCreateAiAgentSessionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateAiAgentSessionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "agentType",
                        "agentIdentityId",
                        "syncType",
                        "goal",
                        "startedAt",
                        "idempotencyKey",
                        "workflowDefinition",
                        "glabVersion",
                        "agentVersion");
    }
}
