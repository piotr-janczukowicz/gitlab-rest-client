package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

public final class TokenexchangeCatalogFixtures {

    private TokenexchangeCatalogFixtures() {}

    public static GitLabAuthnTokenExchange authnTokenExchange() {
        return GitLabAuthnTokenExchangeBuilder.builder()
                .accessToken("eyJhbGciOiJSUzI1NiJ9...")
                .issuedTokenType("urn:ietf:params:oauth:token-type:jwt")
                .tokenType("Bearer")
                .expiresIn(1)
                .token("eyJhbGciOiJSUzI1NiJ9...")
                .build();
    }

    public static GitLabTokenExchangeCreatePayload tokenExchangeCreatePayload() {
        return GitLabTokenExchangeCreatePayloadBuilder.builder()
                .audience(GitLabTokenExchangeCreateAudience.GITLAB_ARTIFACT_REGISTRY)
                .expiresIn(1)
                .build();
    }
}
