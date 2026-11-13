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
class GitLabGitlabLicenseWithActiveUsersTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .id(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlanIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .plan(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.plan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .createdAt(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartsAtIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .startsAt(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.startsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .expiresAt(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHistoricalMaxIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .historicalMax(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.historicalMax()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumUserCountIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .maximumUserCount(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.maximumUserCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseeIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .licensee(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.licensee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddOnsIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .addOns(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.addOns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .expired(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverageIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .overage(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.overage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserLimitIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .userLimit(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.userLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveUsersIsNullable() {
        final GitLabGitlabLicenseWithActiveUsersBuilder builder = GitLabGitlabLicenseWithActiveUsersBuilder.builder(
                        LicenseCatalogFixtures.gitlabLicenseWithActiveUsers())
                .activeUsers(null);

        final GitLabGitlabLicenseWithActiveUsers built = builder.build();

        assertThat(built.activeUsers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabLicenseWithActiveUsers value = LicenseCatalogFixtures.gitlabLicenseWithActiveUsers();

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
            softly.assertThat(value.activeUsers()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabLicenseWithActiveUsers original = LicenseCatalogFixtures.gitlabLicenseWithActiveUsers();

        final GitLabGitlabLicenseWithActiveUsers rebuilt =
                GitLabGitlabLicenseWithActiveUsersBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabLicenseWithActiveUsers.class.getRecordComponents())
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
                        "userLimit",
                        "activeUsers");
    }
}
