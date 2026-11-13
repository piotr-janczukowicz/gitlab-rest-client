package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import java.time.Instant;

public final class UsersshandgpgkeysCatalogFixtures {

    private UsersshandgpgkeysCatalogFixtures() {}

    public static GitLabUserSSHAndGPGKeysCreatePayload userSSHAndGPGKeysCreatePayload() {
        return GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder()
                .key("key")
                .title("title")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .usageType(GitLabUserSSHAndGPGKeysCreateUsageType.AUTH_AND_SIGNING)
                .build();
    }
}
