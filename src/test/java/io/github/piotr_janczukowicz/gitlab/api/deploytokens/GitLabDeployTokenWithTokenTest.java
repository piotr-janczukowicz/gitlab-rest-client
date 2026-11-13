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
class GitLabDeployTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .id(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .name(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .username(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .expiresAt(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .scopes(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .revoked(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .expired(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabDeployTokenWithTokenBuilder builder = GitLabDeployTokenWithTokenBuilder.builder(
                        DeploytokensCatalogFixtures.deployTokenWithToken())
                .token(null);

        final GitLabDeployTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeployTokenWithToken value = DeploytokensCatalogFixtures.deployTokenWithToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("MyToken");
            softly.assertThat(value.username()).isEqualTo("gitlab+deploy-token-1");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.scopes()).isEqualTo(List.of("read_repository"));
            softly.assertThat(value.revoked()).isEqualTo(true);
            softly.assertThat(value.expired()).isEqualTo(true);
            softly.assertThat(value.token()).isEqualTo("jMRvtPNxrn3crTAGukpZ");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeployTokenWithToken original = DeploytokensCatalogFixtures.deployTokenWithToken();

        final GitLabDeployTokenWithToken rebuilt =
                GitLabDeployTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabDeployTokenWithToken value = DeploytokensCatalogFixtures.deployTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeployTokenWithToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "name", "username", "expiresAt", "scopes", "revoked", "expired", "token");
    }
}
