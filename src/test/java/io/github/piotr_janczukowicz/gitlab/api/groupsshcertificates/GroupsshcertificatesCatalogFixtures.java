package io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates;

import java.time.Instant;

public final class GroupsshcertificatesCatalogFixtures {

    private GroupsshcertificatesCatalogFixtures() {}

    public static GitLabGroupGroupSSHCertificatesCreatePayload groupGroupSSHCertificatesCreatePayload() {
        return GitLabGroupGroupSSHCertificatesCreatePayloadBuilder.builder()
                .title("title")
                .key("key")
                .build();
    }

    public static GitLabSshCertificate sshCertificate() {
        return GitLabSshCertificateBuilder.builder()
                .id(1L)
                .title("new ssh cert")
                .key("key")
                .fingerprint("SHA256:1CrrRznEotAVn+wfXVzYlDCaVcGoTvHIup4eNWBPK2k")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
