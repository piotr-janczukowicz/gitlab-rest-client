package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterAgentTokenBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .id(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .name(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .description(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentIdIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .agentId(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.agentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .status(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .createdAt(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByUserIdIsNullable() {
        final GitLabClusterAgentTokenBasicBuilder builder = GitLabClusterAgentTokenBasicBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentTokenBasic())
                .createdByUserId(null);

        final GitLabClusterAgentTokenBasic built = builder.build();

        assertThat(built.createdByUserId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterAgentTokenBasic value = AgentsCatalogFixtures.clusterAgentTokenBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.agentId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdByUserId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterAgentTokenBasic original = AgentsCatalogFixtures.clusterAgentTokenBasic();

        final GitLabClusterAgentTokenBasic rebuilt =
                GitLabClusterAgentTokenBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterAgentTokenBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "name", "description", "agentId", "status", "createdAt", "createdByUserId");
    }
}
