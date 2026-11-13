package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterAgentTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .id(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .name(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .description(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentIdIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .agentId(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.agentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .status(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .createdAt(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByUserIdIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .createdByUserId(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.createdByUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabClusterAgentTokenBuilder builder = GitLabClusterAgentTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentToken())
                .lastUsedAt(null);

        final GitLabClusterAgentToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterAgentToken value = AgentsCatalogFixtures.clusterAgentToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.agentId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdByUserId()).isEqualTo(1L);
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterAgentToken original = AgentsCatalogFixtures.clusterAgentToken();

        final GitLabClusterAgentToken rebuilt =
                GitLabClusterAgentTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterAgentToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "name", "description", "agentId", "status", "createdAt", "createdByUserId", "lastUsedAt");
    }
}
