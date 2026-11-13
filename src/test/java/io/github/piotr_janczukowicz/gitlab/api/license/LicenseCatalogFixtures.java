package io.github.piotr_janczukowicz.gitlab.api.license;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

public final class LicenseCatalogFixtures {

    private LicenseCatalogFixtures() {}

    public static GitLabGitlabLicense gitlabLicense() {
        return GitLabGitlabLicenseBuilder.builder()
                .id(1L)
                .plan("silver")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startsAt(LocalDate.parse("2026-01-01"))
                .expiresAt(LocalDate.parse("2026-01-01"))
                .historicalMax(1)
                .maximumUserCount(1)
                .licensee(Map.of("key", "value"))
                .addOns(Map.of("key", "value"))
                .expired(true)
                .overage(1)
                .userLimit(1)
                .build();
    }

    public static GitLabGitlabLicenseWithActiveUsers gitlabLicenseWithActiveUsers() {
        return GitLabGitlabLicenseWithActiveUsersBuilder.builder()
                .id(1L)
                .plan("silver")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startsAt(LocalDate.parse("2026-01-01"))
                .expiresAt(LocalDate.parse("2026-01-01"))
                .historicalMax(1)
                .maximumUserCount(1)
                .licensee(Map.of("key", "value"))
                .addOns(Map.of("key", "value"))
                .expired(true)
                .overage(1)
                .userLimit(1)
                .activeUsers(1)
                .build();
    }

    public static GitLabLicenseCreatePayload licenseCreatePayload() {
        return GitLabLicenseCreatePayloadBuilder.builder().license("license").build();
    }
}
