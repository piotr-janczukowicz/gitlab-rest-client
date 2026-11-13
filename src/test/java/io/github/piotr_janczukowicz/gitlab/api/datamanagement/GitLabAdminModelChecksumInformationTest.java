package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdminModelChecksumInformationTest {

    @Test
    void constructor_shouldAcceptNull_whenChecksumIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .checksum(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.checksum()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastChecksumIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .lastChecksum(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.lastChecksum()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumStateIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .checksumState(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.checksumState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumRetryCountIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .checksumRetryCount(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.checksumRetryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumRetryAtIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .checksumRetryAt(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.checksumRetryAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumFailureIsNullable() {
        final GitLabAdminModelChecksumInformationBuilder builder = GitLabAdminModelChecksumInformationBuilder.builder(
                        DatamanagementCatalogFixtures.adminModelChecksumInformation())
                .checksumFailure(null);

        final GitLabAdminModelChecksumInformation built = builder.build();

        assertThat(built.checksumFailure()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAdminModelChecksumInformation value = DatamanagementCatalogFixtures.adminModelChecksumInformation();

        assertSoftly(softly -> {
            softly.assertThat(value.checksum()).isEqualTo("checksum");
            softly.assertThat(value.lastChecksum()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.checksumState()).isEqualTo("checksum_state");
            softly.assertThat(value.checksumRetryCount()).isEqualTo(1);
            softly.assertThat(value.checksumRetryAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.checksumFailure()).isEqualTo("checksum_failure");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAdminModelChecksumInformation original =
                DatamanagementCatalogFixtures.adminModelChecksumInformation();

        final GitLabAdminModelChecksumInformation rebuilt =
                GitLabAdminModelChecksumInformationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAdminModelChecksumInformation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "checksum",
                        "lastChecksum",
                        "checksumState",
                        "checksumRetryCount",
                        "checksumRetryAt",
                        "checksumFailure");
    }
}
