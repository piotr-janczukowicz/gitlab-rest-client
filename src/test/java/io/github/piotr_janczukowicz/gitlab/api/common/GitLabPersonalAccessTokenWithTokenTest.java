package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .id(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .name(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .revoked(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .createdAt(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .description(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .scopes(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .userId(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .lastUsedAt(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .lastUsedIps(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .granularScopes(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .active(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .granular(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .expiresAt(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabPersonalAccessTokenWithTokenBuilder builder = GitLabPersonalAccessTokenWithTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessTokenWithToken())
                .token(null);

        final GitLabPersonalAccessTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokenWithToken value = CommonCatalogFixtures.personalAccessTokenWithToken();

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
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokenWithToken original = CommonCatalogFixtures.personalAccessTokenWithToken();

        final GitLabPersonalAccessTokenWithToken rebuilt =
                GitLabPersonalAccessTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabPersonalAccessTokenWithToken value = CommonCatalogFixtures.personalAccessTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessTokenWithToken.class.getRecordComponents())
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
                        "token");
    }
}
