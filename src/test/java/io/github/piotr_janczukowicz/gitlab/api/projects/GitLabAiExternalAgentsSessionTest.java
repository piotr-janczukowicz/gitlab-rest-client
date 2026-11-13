package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiExternalAgentsSessionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .id(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentTypeIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .agentType(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.agentType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .userId(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .status(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFlowTypeIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .flowType(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.flowType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlabVersionIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .glabVersion(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.glabVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentVersionIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .agentVersion(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.agentVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncTypeIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .syncType(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.syncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalXidIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .externalXid(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.externalXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionStartedAtIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .sessionStartedAt(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.sessionStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionFinishedAtIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .sessionFinishedAt(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.sessionFinishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .createdAt(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .updatedAt(null);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiExternalAgentsSession value = ProjectsCatalogFixtures.aiExternalAgentsSession();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.agentType()).isEqualTo("claude-code");
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("running");
            softly.assertThat(value.flowType()).isEqualTo("external_agent");
            softly.assertThat(value.glabVersion()).isEqualTo("glab 1.121.0 (abc1234)");
            softly.assertThat(value.agentVersion()).isEqualTo("2.1.295");
            softly.assertThat(value.syncType()).isEqualTo("hook");
            softly.assertThat(value.externalXid()).isEqualTo("uuid");
            softly.assertThat(value.sessionStartedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.sessionFinishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiExternalAgentsSession original = ProjectsCatalogFixtures.aiExternalAgentsSession();

        final GitLabAiExternalAgentsSession rebuilt =
                GitLabAiExternalAgentsSessionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenSessionStartedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .sessionStartedAt(instant);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.sessionStartedAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenSessionFinishedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .sessionFinishedAt(instant);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.sessionFinishedAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .createdAt(instant);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiExternalAgentsSessionBuilder builder = GitLabAiExternalAgentsSessionBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsSession())
                .updatedAt(instant);

        final GitLabAiExternalAgentsSession built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiExternalAgentsSession.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "agentType",
                        "userId",
                        "status",
                        "flowType",
                        "glabVersion",
                        "agentVersion",
                        "syncType",
                        "externalXid",
                        "sessionStartedAt",
                        "sessionFinishedAt",
                        "createdAt",
                        "updatedAt");
    }
}
