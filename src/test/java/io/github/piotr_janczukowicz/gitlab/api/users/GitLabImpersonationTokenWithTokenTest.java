package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImpersonationTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .id(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .name(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .revoked(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .createdAt(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .description(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .scopes(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .userId(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .lastUsedAt(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .lastUsedIps(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .granularScopes(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .active(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .granular(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .expiresAt(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImpersonationIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .impersonation(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.impersonation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabImpersonationTokenWithTokenBuilder builder = GitLabImpersonationTokenWithTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationTokenWithToken())
                .token(null);

        final GitLabImpersonationTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImpersonationTokenWithToken value = UsersCatalogFixtures.impersonationTokenWithToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("John Doe");
            softly.assertThat(value.revoked()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.description()).isEqualTo("Token to manage api");
            softly.assertThat(value.scopes()).isEqualTo(List.of("api"));
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedIps()).isEqualTo(List.of("127.0.0.1"));
            softly.assertThat(value.granularScopes()).isEqualTo(List.of(CommonCatalogFixtures.granularScope()));
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.granular()).isEqualTo(true);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.impersonation()).isEqualTo("impersonation");
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImpersonationTokenWithToken original = UsersCatalogFixtures.impersonationTokenWithToken();

        final GitLabImpersonationTokenWithToken rebuilt =
                GitLabImpersonationTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabImpersonationTokenWithToken value = UsersCatalogFixtures.impersonationTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabImpersonationTokenWithToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "revoked",
                        "createdAt",
                        "description",
                        "scopes",
                        "userId",
                        "lastUsedAt",
                        "lastUsedIps",
                        "granularScopes",
                        "active",
                        "granular",
                        "expiresAt",
                        "impersonation",
                        "token");
    }
}
