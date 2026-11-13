package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeployTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .id(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .name(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .username(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .expiresAt(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .scopes(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .revoked(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabDeployTokenBuilder builder = GitLabDeployTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployToken())
                .expired(null);

        final GitLabDeployToken built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeployToken value = DeploytokensCatalogFixtures.deployToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("MyToken");
            softly.assertThat(value.username()).isEqualTo("gitlab+deploy-token-1");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.scopes()).isEqualTo(List.of("read_repository"));
            softly.assertThat(value.revoked()).isEqualTo(true);
            softly.assertThat(value.expired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeployToken original = DeploytokensCatalogFixtures.deployToken();

        final GitLabDeployToken rebuilt =
                GitLabDeployTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeployToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "username", "expiresAt", "scopes", "revoked", "expired");
    }
}
