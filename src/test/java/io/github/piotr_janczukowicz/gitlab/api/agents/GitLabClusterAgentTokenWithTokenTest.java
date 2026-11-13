package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterAgentTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .id(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .name(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .description(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentIdIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .agentId(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.agentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .status(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .createdAt(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByUserIdIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .createdByUserId(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.createdByUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .lastUsedAt(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabClusterAgentTokenWithTokenBuilder builder = GitLabClusterAgentTokenWithTokenBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenWithToken())
                .token(null);

        final GitLabClusterAgentTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterAgentTokenWithToken value = AgentsCatalogFixtures.clusterAgentTokenWithToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.agentId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdByUserId()).isEqualTo(1L);
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterAgentTokenWithToken original = AgentsCatalogFixtures.clusterAgentTokenWithToken();

        final GitLabClusterAgentTokenWithToken rebuilt =
                GitLabClusterAgentTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabClusterAgentTokenWithToken value = AgentsCatalogFixtures.clusterAgentTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterAgentTokenWithToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "description",
                        "agentId",
                        "status",
                        "createdAt",
                        "createdByUserId",
                        "lastUsedAt",
                        "token");
    }
}
