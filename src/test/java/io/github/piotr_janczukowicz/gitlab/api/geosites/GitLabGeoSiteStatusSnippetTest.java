package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusSnippetTest {

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesChecksumTotalCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesChecksummedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesChecksumFailedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesSyncedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesSyncedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesFailedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesFailedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesRegistryCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesRegistryCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesVerificationTotalCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesVerifiedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesVerificationFailedCount(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesSyncedInPercentage(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoSiteStatusSnippetBuilder builder = GitLabGeoSiteStatusSnippetBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusSnippet())
                .snippetRepositoriesVerifiedInPercentage(null);

        final GitLabGeoSiteStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusSnippet value = GeositesCatalogFixtures.geoSiteStatusSnippet();

        assertSoftly(softly -> {
            softly.assertThat(value.snippetRepositoriesCount()).isEqualTo("snippet_repositories_count");
            softly.assertThat(value.snippetRepositoriesChecksumTotalCount())
                    .isEqualTo("snippet_repositories_checksum_total_count");
            softly.assertThat(value.snippetRepositoriesChecksummedCount())
                    .isEqualTo("snippet_repositories_checksummed_count");
            softly.assertThat(value.snippetRepositoriesChecksumFailedCount())
                    .isEqualTo("snippet_repositories_checksum_failed_count");
            softly.assertThat(value.snippetRepositoriesSyncedCount()).isEqualTo("snippet_repositories_synced_count");
            softly.assertThat(value.snippetRepositoriesFailedCount()).isEqualTo("snippet_repositories_failed_count");
            softly.assertThat(value.snippetRepositoriesRegistryCount())
                    .isEqualTo("snippet_repositories_registry_count");
            softly.assertThat(value.snippetRepositoriesVerificationTotalCount())
                    .isEqualTo("snippet_repositories_verification_total_count");
            softly.assertThat(value.snippetRepositoriesVerifiedCount())
                    .isEqualTo("snippet_repositories_verified_count");
            softly.assertThat(value.snippetRepositoriesVerificationFailedCount())
                    .isEqualTo("snippet_repositories_verification_failed_count");
            softly.assertThat(value.snippetRepositoriesOldestUnsyncedTime())
                    .isEqualTo("snippet_repositories_oldest_unsynced_time");
            softly.assertThat(value.snippetRepositoriesSyncedInPercentage())
                    .isEqualTo("snippet_repositories_synced_in_percentage");
            softly.assertThat(value.snippetRepositoriesVerifiedInPercentage())
                    .isEqualTo("snippet_repositories_verified_in_percentage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusSnippet original = GeositesCatalogFixtures.geoSiteStatusSnippet();

        final GitLabGeoSiteStatusSnippet rebuilt =
                GitLabGeoSiteStatusSnippetBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusSnippet.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "snippetRepositoriesCount",
                        "snippetRepositoriesChecksumTotalCount",
                        "snippetRepositoriesChecksummedCount",
                        "snippetRepositoriesChecksumFailedCount",
                        "snippetRepositoriesSyncedCount",
                        "snippetRepositoriesFailedCount",
                        "snippetRepositoriesRegistryCount",
                        "snippetRepositoriesVerificationTotalCount",
                        "snippetRepositoriesVerifiedCount",
                        "snippetRepositoriesVerificationFailedCount",
                        "snippetRepositoriesOldestUnsyncedTime",
                        "snippetRepositoriesSyncedInPercentage",
                        "snippetRepositoriesVerifiedInPercentage");
    }
}
