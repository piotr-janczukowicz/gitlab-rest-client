package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

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
class GitLabResourceAccessTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .id(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .name(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .revoked(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .createdAt(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .description(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .scopes(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .userId(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .lastUsedAt(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .lastUsedIps(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .granularScopes(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .active(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .granular(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .expiresAt(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .accessLevel(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .resourceType(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceAccessTokenBuilder builder = GitLabResourceAccessTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessToken())
                .resourceId(null);

        final GitLabResourceAccessToken built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceAccessToken value = AccesstokensCatalogFixtures.resourceAccessToken();

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
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabResourceAccessTokenAccessLevel.GUEST);
            softly.assertThat(value.resourceType()).isEqualTo(GitLabResourceAccessTokenResourceType.PROJECT);
            softly.assertThat(value.resourceId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceAccessToken original = AccesstokensCatalogFixtures.resourceAccessToken();

        final GitLabResourceAccessToken rebuilt =
                GitLabResourceAccessTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceAccessToken.class.getRecordComponents())
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
                        "accessLevel",
                        "resourceType",
                        "resourceId");
    }
}
