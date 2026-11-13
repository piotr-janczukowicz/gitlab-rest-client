package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusPersonalTest {

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsChecksumTotalCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsChecksummedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsChecksumFailedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsSyncedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsSyncedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsFailedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsFailedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsRegistryCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsRegistryCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsVerificationTotalCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsVerifiedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsVerificationFailedCount(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsSyncedInPercentage(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalSnippetUploadsVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusPersonalBuilder builder = GitLabGeoSiteStatusPersonalBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusPersonal())
                .personalSnippetUploadsVerifiedInPercentage(null);

        final GitLabGeoSiteStatusPersonal built = builder.build();

        assertThat(built.personalSnippetUploadsVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusPersonal value = GeositesCatalogFixtures.geoSiteStatusPersonal();

        assertSoftly(softly -> {
            softly.assertThat(value.personalSnippetUploadsCount()).isEqualTo("personal_snippet_uploads_count");
            softly.assertThat(value.personalSnippetUploadsChecksumTotalCount())
                    .isEqualTo("personal_snippet_uploads_checksum_total_count");
            softly.assertThat(value.personalSnippetUploadsChecksummedCount())
                    .isEqualTo("personal_snippet_uploads_checksummed_count");
            softly.assertThat(value.personalSnippetUploadsChecksumFailedCount())
                    .isEqualTo("personal_snippet_uploads_checksum_failed_count");
            softly.assertThat(value.personalSnippetUploadsSyncedCount())
                    .isEqualTo("personal_snippet_uploads_synced_count");
            softly.assertThat(value.personalSnippetUploadsFailedCount())
                    .isEqualTo("personal_snippet_uploads_failed_count");
            softly.assertThat(value.personalSnippetUploadsRegistryCount())
                    .isEqualTo("personal_snippet_uploads_registry_count");
            softly.assertThat(value.personalSnippetUploadsVerificationTotalCount())
                    .isEqualTo("personal_snippet_uploads_verification_total_count");
            softly.assertThat(value.personalSnippetUploadsVerifiedCount())
                    .isEqualTo("personal_snippet_uploads_verified_count");
            softly.assertThat(value.personalSnippetUploadsVerificationFailedCount())
                    .isEqualTo("personal_snippet_uploads_verification_failed_count");
            softly.assertThat(value.personalSnippetUploadsOldestUnsyncedTime())
                    .isEqualTo("personal_snippet_uploads_oldest_unsynced_time");
            softly.assertThat(value.personalSnippetUploadsSyncedInPercentage())
                    .isEqualTo("personal_snippet_uploads_synced_in_percentage");
            softly.assertThat(value.personalSnippetUploadsVerifiedInPercentage())
                    .isEqualTo("personal_snippet_uploads_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusPersonal original = GeositesCatalogFixtures.geoSiteStatusPersonal();

        final GitLabGeoSiteStatusPersonal rebuilt =
                GitLabGeoSiteStatusPersonalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusPersonal.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "personalSnippetUploadsCount",
                        "personalSnippetUploadsChecksumTotalCount",
                        "personalSnippetUploadsChecksummedCount",
                        "personalSnippetUploadsChecksumFailedCount",
                        "personalSnippetUploadsSyncedCount",
                        "personalSnippetUploadsFailedCount",
                        "personalSnippetUploadsRegistryCount",
                        "personalSnippetUploadsVerificationTotalCount",
                        "personalSnippetUploadsVerifiedCount",
                        "personalSnippetUploadsVerificationFailedCount",
                        "personalSnippetUploadsOldestUnsyncedTime",
                        "personalSnippetUploadsSyncedInPercentage",
                        "personalSnippetUploadsVerifiedInPercentage");
    }
}
