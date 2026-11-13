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
class GitLabGeoSitesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPrimaryIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .primary(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.primary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .enabled(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .name(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .url(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .internalUrl(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .filesMaxCapacity(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFilesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .filesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFilesMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .filesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .reposMaxCapacity(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReposMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .reposMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReposMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .reposMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .verificationMaxCapacity(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenVerificationMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .verificationMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenVerificationMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .verificationMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .containerRepositoriesMaxCapacity(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContainerRepositoriesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .containerRepositoriesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContainerRepositoriesMaxCapacityIsTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .containerRepositoriesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .syncObjectStorage(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncType(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncShards(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncNamespaceIds(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncOrganizationIds(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .minimumReverificationInterval(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .checksumMismatchReportThreshold(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobDownloadTimeoutIsNullable() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .blobDownloadTimeout(null);

        final GitLabGeoSitesCreatePayload built = builder.build();

        assertThat(built.blobDownloadTimeout()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenBlobDownloadTimeoutIsBelowTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .blobDownloadTimeout(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenBlobDownloadTimeoutIsTheMinimum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .blobDownloadTimeout(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenBlobDownloadTimeoutIsAboveTheMaximum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .blobDownloadTimeout(86_401);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenBlobDownloadTimeoutIsTheMaximum() {
        final GitLabGeoSitesCreatePayloadBuilder builder = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .blobDownloadTimeout(86_400);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSitesCreatePayload value = GeositesCatalogFixtures.geoSitesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.primary()).isEqualTo(true);
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
        final GitLabGeoSitesCreatePayload original = GeositesCatalogFixtures.geoSitesCreatePayload();

        final GitLabGeoSitesCreatePayload rebuilt =
                GitLabGeoSitesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncShardsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("selective_sync_shards"));
        final GitLabGeoSitesCreatePayload built = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncShards(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncShards()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncShardsIsRead() {
        final GitLabGeoSitesCreatePayload built = GeositesCatalogFixtures.geoSitesCreatePayload();
        final List<String> values = built.selectiveSyncShards();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncNamespaceIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoSitesCreatePayload built = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncNamespaceIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncNamespaceIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncNamespaceIdsIsRead() {
        final GitLabGeoSitesCreatePayload built = GeositesCatalogFixtures.geoSitesCreatePayload();
        final List<Long> values = built.selectiveSyncNamespaceIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncOrganizationIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoSitesCreatePayload built = GitLabGeoSitesCreatePayloadBuilder.builder(
                        GeositesCatalogFixtures.geoSitesCreatePayload())
                .selectiveSyncOrganizationIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncOrganizationIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncOrganizationIdsIsRead() {
        final GitLabGeoSitesCreatePayload built = GeositesCatalogFixtures.geoSitesCreatePayload();
        final List<Long> values = built.selectiveSyncOrganizationIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSitesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "primary",
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
