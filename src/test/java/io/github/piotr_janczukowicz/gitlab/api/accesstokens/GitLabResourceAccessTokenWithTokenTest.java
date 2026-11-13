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
class GitLabResourceAccessTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .id(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .name(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .revoked(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .createdAt(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .description(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .scopes(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .userId(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .lastUsedAt(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIpsIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .lastUsedIps(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.lastUsedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .granularScopes(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .active(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .granular(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.granular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .expiresAt(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .accessLevel(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .resourceType(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .resourceId(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabResourceAccessTokenWithTokenBuilder builder = GitLabResourceAccessTokenWithTokenBuilder.builder(
                        AccesstokensCatalogFixtures.resourceAccessTokenWithToken())
                .token(null);

        final GitLabResourceAccessTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceAccessTokenWithToken value = AccesstokensCatalogFixtures.resourceAccessTokenWithToken();

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
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabResourceAccessTokenWithTokenAccessLevel.GUEST);
            softly.assertThat(value.resourceType()).isEqualTo(GitLabResourceAccessTokenWithTokenResourceType.PROJECT);
            softly.assertThat(value.resourceId()).isEqualTo(1L);
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceAccessTokenWithToken original = AccesstokensCatalogFixtures.resourceAccessTokenWithToken();

        final GitLabResourceAccessTokenWithToken rebuilt =
                GitLabResourceAccessTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabResourceAccessTokenWithToken value = AccesstokensCatalogFixtures.resourceAccessTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceAccessTokenWithToken.class.getRecordComponents())
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
                        "resourceId",
                        "token");
    }
}
