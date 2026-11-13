package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusCiTest {

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesChecksumTotalCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesChecksummedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesChecksumFailedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesSyncedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesFailedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesFailedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesRegistryCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesVerificationTotalCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesVerifiedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesVerificationFailedCount(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesSyncedInPercentage(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSecureFilesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusCiBuilder builder = GitLabGeoSiteStatusCiBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusCi())
                .ciSecureFilesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusCi built = builder.build();

        assertThat(built.ciSecureFilesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusCi value = GeositesCatalogFixtures.geoSiteStatusCi();

        assertSoftly(softly -> {
            softly.assertThat(value.ciSecureFilesCount()).isEqualTo("ci_secure_files_count");
            softly.assertThat(value.ciSecureFilesChecksumTotalCount())
                    .isEqualTo("ci_secure_files_checksum_total_count");
            softly.assertThat(value.ciSecureFilesChecksummedCount()).isEqualTo("ci_secure_files_checksummed_count");
            softly.assertThat(value.ciSecureFilesChecksumFailedCount())
                    .isEqualTo("ci_secure_files_checksum_failed_count");
            softly.assertThat(value.ciSecureFilesSyncedCount()).isEqualTo("ci_secure_files_synced_count");
            softly.assertThat(value.ciSecureFilesFailedCount()).isEqualTo("ci_secure_files_failed_count");
            softly.assertThat(value.ciSecureFilesRegistryCount()).isEqualTo("ci_secure_files_registry_count");
            softly.assertThat(value.ciSecureFilesVerificationTotalCount())
                    .isEqualTo("ci_secure_files_verification_total_count");
            softly.assertThat(value.ciSecureFilesVerifiedCount()).isEqualTo("ci_secure_files_verified_count");
            softly.assertThat(value.ciSecureFilesVerificationFailedCount())
                    .isEqualTo("ci_secure_files_verification_failed_count");
            softly.assertThat(value.ciSecureFilesOldestUnsyncedTime())
                    .isEqualTo("ci_secure_files_oldest_unsynced_time");
            softly.assertThat(value.ciSecureFilesSyncedInPercentage())
                    .isEqualTo("ci_secure_files_synced_in_percentage");
            softly.assertThat(value.ciSecureFilesVerifiedInPercentage())
                    .isEqualTo("ci_secure_files_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusCi original = GeositesCatalogFixtures.geoSiteStatusCi();

        final GitLabGeoSiteStatusCi rebuilt =
                GitLabGeoSiteStatusCiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusCi.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "ciSecureFilesCount",
                        "ciSecureFilesChecksumTotalCount",
                        "ciSecureFilesChecksummedCount",
                        "ciSecureFilesChecksumFailedCount",
                        "ciSecureFilesSyncedCount",
                        "ciSecureFilesFailedCount",
                        "ciSecureFilesRegistryCount",
                        "ciSecureFilesVerificationTotalCount",
                        "ciSecureFilesVerifiedCount",
                        "ciSecureFilesVerificationFailedCount",
                        "ciSecureFilesOldestUnsyncedTime",
                        "ciSecureFilesSyncedInPercentage",
                        "ciSecureFilesVerifiedInPercentage");
    }
}
