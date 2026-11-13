package io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles;

import java.time.Instant;
import java.util.Map;

public final class ProjectlevelsecurefilesCatalogFixtures {

    private ProjectlevelsecurefilesCatalogFixtures() {}

    public static GitLabCiSecureFile ciSecureFile() {
        return GitLabCiSecureFileBuilder.builder()
                .id(1L)
                .name("upload-keystore.jks")
                .checksum("16630b189ab34b2e3504f4758e1054d2e478deda510b2b08cc0ef38d12e80aac")
                .checksumAlgorithm("sha256")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .metadata(Map.of("key", "value"))
                .fileExtension("jks")
                .build();
    }
}
