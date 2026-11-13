package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSitesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .enabled(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .name(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .url(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .internalUrl(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .filesMaxCapacity(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFilesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .filesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFilesMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .filesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .reposMaxCapacity(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReposMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .reposMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReposMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .reposMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .verificationMaxCapacity(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenVerificationMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .verificationMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenVerificationMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .verificationMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .containerRepositoriesMaxCapacity(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContainerRepositoriesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .containerRepositoriesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContainerRepositoriesMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .containerRepositoriesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .syncObjectStorage(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncType(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncShards(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncNamespaceIds(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncOrganizationIds(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .minimumReverificationInterval(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .checksumMismatchReportThreshold(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobDownloadTimeoutIsNullable() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .blobDownloadTimeout(null);

        final GitLabGeoSitesUpdatePayload built = builder.build();

        assertThat(built.blobDownloadTimeout()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenBlobDownloadTimeoutIsBelowTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .blobDownloadTimeout(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenBlobDownloadTimeoutIsTheMinimum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .blobDownloadTimeout(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenBlobDownloadTimeoutIsAboveTheMaximum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .blobDownloadTimeout(86_401);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenBlobDownloadTimeoutIsTheMaximum() {
        final GitLabGeoSitesUpdatePayloadBuilder builder = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .blobDownloadTimeout(86_400);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSitesUpdatePayload value = GeositesCatalogFixtures.geoSitesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.internalUrl()).isEqualTo("internal_url");
            softly.assertThat(value.filesMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.reposMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.verificationMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.syncObjectStorage()).isEqualTo(true);
            softly.assertThat(value.selectiveSyncType()).isEqualTo("selective_sync_type");
            softly.assertThat(value.selectiveSyncShards()).isEqualTo(List.of("selective_sync_shards"));
            softly.assertThat(value.selectiveSyncNamespaceIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.selectiveSyncOrganizationIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.minimumReverificationInterval()).isEqualTo(1);
            softly.assertThat(value.checksumMismatchReportThreshold()).isEqualTo(1);
            softly.assertThat(value.checksumMismatchSelfHealCooldownMinutes()).isEqualTo(1);
            softly.assertThat(value.blobDownloadTimeout()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSitesUpdatePayload original = GeositesCatalogFixtures.geoSitesUpdatePayload();

        final GitLabGeoSitesUpdatePayload rebuilt =
                GitLabGeoSitesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncShardsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("selective_sync_shards"));
        final GitLabGeoSitesUpdatePayload built = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncShards(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncShards()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncShardsIsRead() {
        final GitLabGeoSitesUpdatePayload built = GeositesCatalogFixtures.geoSitesUpdatePayload();
        final List<String> values = built.selectiveSyncShards();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncNamespaceIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoSitesUpdatePayload built = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncNamespaceIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncNamespaceIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncNamespaceIdsIsRead() {
        final GitLabGeoSitesUpdatePayload built = GeositesCatalogFixtures.geoSitesUpdatePayload();
        final List<Long> values = built.selectiveSyncNamespaceIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncOrganizationIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoSitesUpdatePayload built = GitLabGeoSitesUpdatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesUpdatePayload())
                .selectiveSyncOrganizationIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncOrganizationIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncOrganizationIdsIsRead() {
        final GitLabGeoSitesUpdatePayload built = GeositesCatalogFixtures.geoSitesUpdatePayload();
        final List<Long> values = built.selectiveSyncOrganizationIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSitesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enabled",
                        "name",
                        "url",
                        "internalUrl",
                        "filesMaxCapacity",
                        "reposMaxCapacity",
                        "verificationMaxCapacity",
                        "containerRepositoriesMaxCapacity",
                        "syncObjectStorage",
                        "selectiveSyncType",
                        "selectiveSyncShards",
                        "selectiveSyncNamespaceIds",
                        "selectiveSyncOrganizationIds",
                        "minimumReverificationInterval",
                        "checksumMismatchReportThreshold",
                        "checksumMismatchSelfHealCooldownMinutes",
                        "blobDownloadTimeout");
    }
}
