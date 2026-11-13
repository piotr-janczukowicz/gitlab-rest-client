package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import java.time.Instant;
import java.util.List;

public final class DatamanagementCatalogFixtures {

    private DatamanagementCatalogFixtures() {}

    public static GitLabAdminModel adminModel() {
        return GitLabAdminModelBuilder.builder()
                .recordIdentifier("text")
                .modelClass("Project")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .fileSize(1L)
                .checksumInformation(DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .build();
    }

    public static GitLabAdminModelChecksumInformation adminModelChecksumInformation() {
        return GitLabAdminModelChecksumInformationBuilder.builder()
                .checksum("checksum")
                .lastChecksum(Instant.parse("2026-01-01T00:00:00Z"))
                .checksumState("checksum_state")
                .checksumRetryCount(1)
                .checksumRetryAt(Instant.parse("2026-01-01T00:00:00Z"))
                .checksumFailure("checksum_failure")
                .build();
    }

    public static GitLabDataManagementChecksumPayload dataManagementChecksumPayload() {
        return GitLabDataManagementChecksumPayloadBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementChecksumState.STARTED)
                .build();
    }
}
