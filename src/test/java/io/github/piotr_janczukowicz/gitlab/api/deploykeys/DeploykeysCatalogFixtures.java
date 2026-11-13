package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class DeploykeysCatalogFixtures {

    private DeploykeysCatalogFixtures() {}

    public static GitLabDeployKeysProject deployKeysProject() {
        return GitLabDeployKeysProjectBuilder.builder()
                .id(1L)
                .title("Sample key 25")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .key(
                        "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQDNJAkI3Wdf0r13c8a5pEExB2YowPWCSVzfZV22pNBc1CuEbyYLHpUyaD0GwpGvFdx2aP7lMEk35k6Rz3ccBF6jRaVJyhsn5VNnW92PMpBJ/P1UebhXwsFHdQf5rTt082cSxWuk61kGWRQtk4ozt/J2DF/dIUVaLvc+z4HomT41fQ==")
                .usageType("auth")
                .fingerprint("4a:9d:64:15:ed:3a:e6:07:6e:89:36:b3:3b:03:05:d9")
                .fingerprintSha256("Jrs3LD1Ji30xNLtTVf9NDCj7kkBgPBb2pjvTZ3HfIgU")
                .projectsWithWriteAccess(List.of(CommonCatalogFixtures.projectIdentity()))
                .projectsWithReadonlyAccess(List.of(CommonCatalogFixtures.projectIdentity()))
                .canPush(true)
                .build();
    }

    public static GitLabInstanceDeployKeysCreatePayload instanceDeployKeysCreatePayload() {
        return GitLabInstanceDeployKeysCreatePayloadBuilder.builder()
                .key("key")
                .title("title")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectDeployKeysCreatePayload projectDeployKeysCreatePayload() {
        return GitLabProjectDeployKeysCreatePayloadBuilder.builder()
                .key("key")
                .title("title")
                .canPush(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectDeployKeysUpdatePayload projectDeployKeysUpdatePayload() {
        return GitLabProjectDeployKeysUpdatePayloadBuilder.builder()
                .title("title")
                .canPush(true)
                .build();
    }
}
