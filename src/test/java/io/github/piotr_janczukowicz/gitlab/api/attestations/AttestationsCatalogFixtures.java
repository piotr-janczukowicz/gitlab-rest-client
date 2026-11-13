package io.github.piotr_janczukowicz.gitlab.api.attestations;

import java.time.Instant;

public final class AttestationsCatalogFixtures {

    private AttestationsCatalogFixtures() {}

    public static GitLabSupplyChainAttestation supplyChainAttestation() {
        return GitLabSupplyChainAttestationBuilder.builder()
                .id(1L)
                .iid(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expireAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .buildId(1L)
                .status("success")
                .predicateKind("provenance")
                .predicateType("https://slsa.dev/provenance/v1")
                .subjectDigest("5db1fee4b5703808c48078a76768b155b421b210c0761cd6a5d223f4d99f1eaa")
                .signingMethod(GitLabSupplyChainAttestationSigningMethod.SIGSTORE)
                .downloadUrl("download_url")
                .build();
    }
}
