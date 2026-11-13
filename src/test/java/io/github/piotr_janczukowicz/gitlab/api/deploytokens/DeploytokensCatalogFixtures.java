package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import java.time.Instant;
import java.util.List;

public final class DeploytokensCatalogFixtures {

    private DeploytokensCatalogFixtures() {}

    public static GitLabDeployToken deployToken() {
        return GitLabDeployTokenBuilder.builder()
                .id(1L)
                .name("MyToken")
                .username("gitlab+deploy-token-1")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .scopes(List.of("read_repository"))
                .revoked(true)
                .expired(true)
                .build();
    }

    public static GitLabDeployTokenWithToken deployTokenWithToken() {
        return GitLabDeployTokenWithTokenBuilder.builder()
                .id(1L)
                .name("MyToken")
                .username("gitlab+deploy-token-1")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .scopes(List.of("read_repository"))
                .revoked(true)
                .expired(true)
                .token("jMRvtPNxrn3crTAGukpZ")
                .build();
    }

    public static GitLabGroupDeployTokensCreatePayload groupDeployTokensCreatePayload() {
        return GitLabGroupDeployTokensCreatePayloadBuilder.builder()
                .name("name")
                .scopes(List.of(GitLabGroupDeployTokensCreateScopes.READ_REPOSITORY))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .username("username")
                .build();
    }

    public static GitLabProjectDeployTokensCreatePayload projectDeployTokensCreatePayload() {
        return GitLabProjectDeployTokensCreatePayloadBuilder.builder()
                .name("name")
                .scopes(List.of(GitLabProjectDeployTokensCreateScopes.READ_REPOSITORY))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .username("username")
                .build();
    }
}
