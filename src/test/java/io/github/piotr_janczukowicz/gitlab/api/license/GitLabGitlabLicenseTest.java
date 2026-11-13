package io.github.piotr_janczukowicz.gitlab.api.license;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGitlabLicenseTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .id(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlanIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .plan(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.plan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .createdAt(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartsAtIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .startsAt(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.startsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .expiresAt(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHistoricalMaxIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .historicalMax(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.historicalMax()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumUserCountIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .maximumUserCount(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.maximumUserCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseeIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .licensee(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.licensee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddOnsIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .addOns(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.addOns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .expired(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverageIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .overage(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.overage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserLimitIsNullable() {
        final GitLabGitlabLicenseBuilder builder = GitLabGitlabLicenseBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicense())
                .userLimit(null);

        final GitLabGitlabLicense built = builder.build();

        assertThat(built.userLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabLicense value = LicenseCatalogFixtures.gitlabLicense();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.plan()).isEqualTo("silver");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startsAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.historicalMax()).isEqualTo(1);
            softly.assertThat(value.maximumUserCount()).isEqualTo(1);
            softly.assertThat(value.licensee()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.addOns()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.expired()).isEqualTo(true);
            softly.assertThat(value.overage()).isEqualTo(1);
            softly.assertThat(value.userLimit()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabLicense original = LicenseCatalogFixtures.gitlabLicense();

        final GitLabGitlabLicense rebuilt =
                GitLabGitlabLicenseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabLicense.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "plan",
                        "createdAt",
                        "startsAt",
                        "expiresAt",
                        "historicalMax",
                        "maximumUserCount",
                        "licensee",
                        "addOns",
                        "expired",
                        "overage",
                        "userLimit");
    }
}
