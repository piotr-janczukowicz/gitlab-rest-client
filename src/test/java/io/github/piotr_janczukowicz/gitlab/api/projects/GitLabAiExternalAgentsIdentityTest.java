package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiExternalAgentsIdentityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiExternalAgentsIdentityBuilder builder = GitLabAiExternalAgentsIdentityBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsIdentity())
                .id(null);

        final GitLabAiExternalAgentsIdentity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentTypeIsNullable() {
        final GitLabAiExternalAgentsIdentityBuilder builder = GitLabAiExternalAgentsIdentityBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsIdentity())
                .agentType(null);

        final GitLabAiExternalAgentsIdentity built = builder.build();

        assertThat(built.agentType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedAtIsNullable() {
        final GitLabAiExternalAgentsIdentityBuilder builder = GitLabAiExternalAgentsIdentityBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsIdentity())
                .revokedAt(null);

        final GitLabAiExternalAgentsIdentity built = builder.build();

        assertThat(built.revokedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiExternalAgentsIdentityBuilder builder = GitLabAiExternalAgentsIdentityBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsIdentity())
                .createdAt(null);

        final GitLabAiExternalAgentsIdentity built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiExternalAgentsIdentity value = ProjectsCatalogFixtures.aiExternalAgentsIdentity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.agentType()).isEqualTo("claude-code");
            softly.assertThat(value.revokedAt()).isEqualTo("revoked_at");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiExternalAgentsIdentity original = ProjectsCatalogFixtures.aiExternalAgentsIdentity();

        final GitLabAiExternalAgentsIdentity rebuilt =
                GitLabAiExternalAgentsIdentityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiExternalAgentsIdentityBuilder builder = GitLabAiExternalAgentsIdentityBuilder.builder(
                        ProjectsCatalogFixtures.aiExternalAgentsIdentity())
                .createdAt(instant);

        final GitLabAiExternalAgentsIdentity built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiExternalAgentsIdentity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "agentType", "revokedAt", "createdAt");
    }
}
