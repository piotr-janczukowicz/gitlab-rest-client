package io.github.piotr_janczukowicz.gitlab.api.keys;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;

public final class KeysCatalogFixtures {

    private KeysCatalogFixtures() {}

    public static GitLabGpgKey gpgKey() {
        return GitLabGpgKeyBuilder.builder()
                .id(1L)
                .key("-----BEGIN PGP PUBLIC KEY BLOCK-----")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabKeysCreateUserGpgKeyPayload keysCreateUserGpgKeyPayload() {
        return GitLabKeysCreateUserGpgKeyPayloadBuilder.builder().key("key").build();
    }

    public static GitLabKeysCreateUsersGpgKeyPayload keysCreateUsersGpgKeyPayload() {
        return GitLabKeysCreateUsersGpgKeyPayloadBuilder.builder().key("key").build();
    }

    public static GitLabKeysCreateUsersKeyPayload keysCreateUsersKeyPayload() {
        return GitLabKeysCreateUsersKeyPayloadBuilder.builder()
                .key("key")
                .title("title")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .usageType(GitLabKeysCreateUsersKeyUsageType.AUTH_AND_SIGNING)
                .build();
    }

    public static GitLabSSHKeyWithUser sshkeyWithUser() {
        return GitLabSSHKeyWithUserBuilder.builder()
                .id(1L)
                .title("Sample key 25")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .key(
                        "ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAIEAiPWx6WM4lhHNedGfBpPJNPpZ7yKu+dnn1SJejgt1256k6Yjz\\\n      GGphH2TUxwKzxcKDKKezwkpfnxPkSMkuEspGRt/aZZ9wa++Oi7Qkr8prgHc4soW6NUlfDzpvZK2H5E7eQaSeP3SAwGmQKUFHCdd\\\n      NaP0L+hM7zhFNzjFvpaMgJw0=")
                .usageType("auth")
                .user(CommonCatalogFixtures.userPublic())
                .build();
    }
}
