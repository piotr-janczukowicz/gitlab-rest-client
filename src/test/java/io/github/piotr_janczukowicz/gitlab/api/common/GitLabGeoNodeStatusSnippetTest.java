package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusSnippetTest {

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumTotalCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesChecksumTotalCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksumTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksummedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesChecksummedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksummedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesChecksumFailedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesChecksumFailedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesChecksumFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesSyncedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesSyncedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesSyncedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesFailedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesFailedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesRegistryCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesRegistryCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesRegistryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationTotalCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesVerificationTotalCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerificationTotalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerifiedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesVerifiedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerifiedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerificationFailedCountIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesVerificationFailedCount(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerificationFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesOldestUnsyncedTimeIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesOldestUnsyncedTime(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesOldestUnsyncedTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesSyncedInPercentageIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesSyncedInPercentage(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesSyncedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRepositoriesVerifiedInPercentageIsNullable() {
        final GitLabGeoNodeStatusSnippetBuilder builder = GitLabGeoNodeStatusSnippetBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusSnippet())
                .snippetRepositoriesVerifiedInPercentage(null);

        final GitLabGeoNodeStatusSnippet built = builder.build();

        assertThat(built.snippetRepositoriesVerifiedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusSnippet value = CommonCatalogFixtures.geoNodeStatusSnippet();

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
        final GitLabGeoNodeStatusSnippet original = CommonCatalogFixtures.geoNodeStatusSnippet();

        final GitLabGeoNodeStatusSnippet rebuilt =
                GitLabGeoNodeStatusSnippetBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusSnippet.class.getRecordComponents())
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
