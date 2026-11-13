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
class GitLabImpersonationTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .id(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .name(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .revoked(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .createdAt(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .description(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .scopes(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .userId(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .lastUsedAt(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .lastUsedIps(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .granularScopes(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .active(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .granular(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .expiresAt(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImpersonationIsNullable() {
        final GitLabImpersonationTokenBuilder builder = GitLabImpersonationTokenBuilder.builder(
                        UsersCatalogFixtures.impersonationToken())
                .impersonation(null);

        final GitLabImpersonationToken built = builder.build();

        assertThat(built.impersonation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImpersonationToken value = UsersCatalogFixtures.impersonationToken();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImpersonationToken original = UsersCatalogFixtures.impersonationToken();

        final GitLabImpersonationToken rebuilt =
                GitLabImpersonationTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabImpersonationToken.class.getRecordComponents())
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
                        "impersonation");
    }
}
