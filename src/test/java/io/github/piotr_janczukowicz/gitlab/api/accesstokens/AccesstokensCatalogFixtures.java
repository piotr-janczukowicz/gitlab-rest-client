package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public final class AccesstokensCatalogFixtures {

    private AccesstokensCatalogFixtures() {}

    public static GitLabGroupAccessTokensCreatePayload groupAccessTokensCreatePayload() {
        return GitLabGroupAccessTokensCreatePayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of(GitLabGroupAccessTokensCreateScopes.API))
                .accessLevel(GitLabGroupAccessTokensCreateAccessLevel.GUEST)
                .build();
    }

    public static GitLabGroupAccessTokensRotatePayload groupAccessTokensRotatePayload() {
        return GitLabGroupAccessTokensRotatePayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabGroupAccessTokensRotateSelfPayload groupAccessTokensRotateSelfPayload() {
        return GitLabGroupAccessTokensRotateSelfPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabProjectAccessTokensCreatePayload projectAccessTokensCreatePayload() {
        return GitLabProjectAccessTokensCreatePayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of(GitLabProjectAccessTokensCreateScopes.API))
                .accessLevel(GitLabProjectAccessTokensCreateAccessLevel.GUEST)
                .build();
    }

    public static GitLabProjectAccessTokensRotatePayload projectAccessTokensRotatePayload() {
        return GitLabProjectAccessTokensRotatePayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabProjectAccessTokensRotateSelfPayload projectAccessTokensRotateSelfPayload() {
        return GitLabProjectAccessTokensRotateSelfPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabResourceAccessToken resourceAccessToken() {
        return GitLabResourceAccessTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .accessLevel(GitLabResourceAccessTokenAccessLevel.GUEST)
                .resourceType(GitLabResourceAccessTokenResourceType.PROJECT)
                .resourceId(1L)
                .build();
    }

    public static GitLabResourceAccessTokenWithToken resourceAccessTokenWithToken() {
        return GitLabResourceAccessTokenWithTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .accessLevel(GitLabResourceAccessTokenWithTokenAccessLevel.GUEST)
                .resourceType(GitLabResourceAccessTokenWithTokenResourceType.PROJECT)
                .resourceId(1L)
                .token("token")
                .build();
    }
}
