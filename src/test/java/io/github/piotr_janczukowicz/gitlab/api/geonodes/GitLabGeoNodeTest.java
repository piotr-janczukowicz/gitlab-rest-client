package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).id(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).name(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).url(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).internalUrl(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).primary(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.primary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).enabled(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).current(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.current()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).filesMaxCapacity(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).reposMaxCapacity(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).verificationMaxCapacity(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).containerRepositoriesMaxCapacity(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).selectiveSyncType(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).selectiveSyncShards(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).selectiveSyncNamespaceIds(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).selectiveSyncOrganizationIds(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).minimumReverificationInterval(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).checksumMismatchReportThreshold(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoNodeBuilder builder = GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).syncObjectStorage(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloneProtocolIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).cloneProtocol(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.cloneProtocol()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebEditUrlIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).webEditUrl(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.webEditUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebGeoReplicationDetailsUrlIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).webGeoReplicationDetailsUrl(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.webGeoReplicationDetailsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabGeoNodeBuilder builder =
                GitLabGeoNodeBuilder.builder(GeonodesCatalogFixtures.geoNode()).links(null);

        final GitLabGeoNode built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNode value = GeonodesCatalogFixtures.geoNode();

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
            softly.assertThat(value.checksumMismatchReportThreshold()).isEqualTo(1);
            softly.assertThat(value.checksumMismatchSelfHealCooldownMinutes()).isEqualTo(1);
            softly.assertThat(value.syncObjectStorage()).isEqualTo(true);
            softly.assertThat(value.cloneProtocol()).isEqualTo("clone_protocol");
            softly.assertThat(value.webEditUrl()).isEqualTo("web_edit_url");
            softly.assertThat(value.webGeoReplicationDetailsUrl()).isEqualTo("web_geo_replication_details_url");
            softly.assertThat(value.links()).isEqualTo(GeonodesCatalogFixtures.geoNodeLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNode original = GeonodesCatalogFixtures.geoNode();

        final GitLabGeoNode rebuilt = GitLabGeoNodeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNode.class.getRecordComponents())
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
                        "checksumMismatchReportThreshold",
                        "checksumMismatchSelfHealCooldownMinutes",
                        "syncObjectStorage",
                        "cloneProtocol",
                        "webEditUrl",
                        "webGeoReplicationDetailsUrl",
                        "links");
    }
}
