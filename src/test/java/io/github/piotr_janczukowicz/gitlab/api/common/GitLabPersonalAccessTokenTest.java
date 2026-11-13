package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .id(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .name(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .revoked(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .createdAt(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .description(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .scopes(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .userId(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .lastUsedAt(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .lastUsedIps(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .granularScopes(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .active(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .granular(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabPersonalAccessTokenBuilder builder = GitLabPersonalAccessTokenBuilder.builder(
                        CommonCatalogFixtures.personalAccessToken())
                .expiresAt(null);

        final GitLabPersonalAccessToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessToken value = CommonCatalogFixtures.personalAccessToken();

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
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessToken original = CommonCatalogFixtures.personalAccessToken();

        final GitLabPersonalAccessToken rebuilt =
                GitLabPersonalAccessTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessToken.class.getRecordComponents())
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
                        "expiresAt");
    }
}
