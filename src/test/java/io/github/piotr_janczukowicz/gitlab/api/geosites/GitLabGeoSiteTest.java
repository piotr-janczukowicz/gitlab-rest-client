package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).id(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).name(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).url(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).internalUrl(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).primary(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.primary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).enabled(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).current(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.current()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).filesMaxCapacity(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).reposMaxCapacity(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).verificationMaxCapacity(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).containerRepositoriesMaxCapacity(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).selectiveSyncType(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).selectiveSyncShards(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).selectiveSyncNamespaceIds(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).selectiveSyncOrganizationIds(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).minimumReverificationInterval(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobDownloadTimeoutIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).blobDownloadTimeout(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.blobDownloadTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).checksumMismatchReportThreshold(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoSiteBuilder builder = GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).syncObjectStorage(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebEditUrlIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).webEditUrl(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.webEditUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebGeoReplicationDetailsUrlIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).webGeoReplicationDetailsUrl(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.webGeoReplicationDetailsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabGeoSiteBuilder builder =
                GitLabGeoSiteBuilder.builder(GeositesCatalogFixtures.geoSite()).links(null);

        final GitLabGeoSite built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSite value = GeositesCatalogFixtures.geoSite();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.internalUrl()).isEqualTo("internal_url");
            softly.assertThat(value.primary()).isEqualTo(true);
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.current()).isEqualTo(true);
            softly.assertThat(value.filesMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.reposMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.verificationMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.containerRepositoriesMaxCapacity()).isEqualTo(1);
            softly.assertThat(value.selectiveSyncType()).isEqualTo("selective_sync_type");
            softly.assertThat(value.selectiveSyncShards()).isEqualTo(List.of("selective_sync_shards"));
            softly.assertThat(value.selectiveSyncNamespaceIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.selectiveSyncOrganizationIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.minimumReverificationInterval()).isEqualTo(1);
            softly.assertThat(value.blobDownloadTimeout()).isEqualTo(1);
            softly.assertThat(value.checksumMismatchReportThreshold()).isEqualTo(1);
            softly.assertThat(value.checksumMismatchSelfHealCooldownMinutes()).isEqualTo(1);
            softly.assertThat(value.syncObjectStorage()).isEqualTo(true);
            softly.assertThat(value.webEditUrl()).isEqualTo("web_edit_url");
            softly.assertThat(value.webGeoReplicationDetailsUrl()).isEqualTo("web_geo_replication_details_url");
            softly.assertThat(value.links()).isEqualTo(GeositesCatalogFixtures.geoSiteLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSite original = GeositesCatalogFixtures.geoSite();

        final GitLabGeoSite rebuilt = GitLabGeoSiteBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSite.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "url",
                        "internalUrl",
                        "primary",
                        "enabled",
                        "current",
                        "filesMaxCapacity",
                        "reposMaxCapacity",
                        "verificationMaxCapacity",
                        "containerRepositoriesMaxCapacity",
                        "selectiveSyncType",
                        "selectiveSyncShards",
                        "selectiveSyncNamespaceIds",
                        "selectiveSyncOrganizationIds",
                        "minimumReverificationInterval",
                        "blobDownloadTimeout",
                        "checksumMismatchReportThreshold",
                        "checksumMismatchSelfHealCooldownMinutes",
                        "syncObjectStorage",
                        "webEditUrl",
                        "webGeoReplicationDetailsUrl",
                        "links");
    }
}
