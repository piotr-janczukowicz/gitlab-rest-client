package io.github.piotr_janczukowicz.gitlab.api.geonodes;

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
class GitLabGeoNodesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .enabled(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .name(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .url(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .internalUrl(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .filesMaxCapacity(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFilesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .filesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFilesMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .filesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .reposMaxCapacity(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReposMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .reposMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReposMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .reposMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .verificationMaxCapacity(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenVerificationMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .verificationMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenVerificationMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .verificationMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .containerRepositoriesMaxCapacity(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContainerRepositoriesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .containerRepositoriesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContainerRepositoriesMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .containerRepositoriesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .syncObjectStorage(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncType(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncShards(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncNamespaceIds(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncOrganizationIds(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .minimumReverificationInterval(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .checksumMismatchReportThreshold(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoNodesUpdatePayloadBuilder builder = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoNodesUpdatePayload built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodesUpdatePayload value = GeonodesCatalogFixtures.geoNodesUpdatePayload();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodesUpdatePayload original = GeonodesCatalogFixtures.geoNodesUpdatePayload();

        final GitLabGeoNodesUpdatePayload rebuilt =
                GitLabGeoNodesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncShardsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("selective_sync_shards"));
        final GitLabGeoNodesUpdatePayload built = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncShards(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncShards()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncShardsIsRead() {
        final GitLabGeoNodesUpdatePayload built = GeonodesCatalogFixtures.geoNodesUpdatePayload();
        final List<String> values = built.selectiveSyncShards();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncNamespaceIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoNodesUpdatePayload built = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncNamespaceIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncNamespaceIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncNamespaceIdsIsRead() {
        final GitLabGeoNodesUpdatePayload built = GeonodesCatalogFixtures.geoNodesUpdatePayload();
        final List<Long> values = built.selectiveSyncNamespaceIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncOrganizationIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoNodesUpdatePayload built = GitLabGeoNodesUpdatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesUpdatePayload())
                .selectiveSyncOrganizationIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncOrganizationIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncOrganizationIdsIsRead() {
        final GitLabGeoNodesUpdatePayload built = GeonodesCatalogFixtures.geoNodesUpdatePayload();
        final List<Long> values = built.selectiveSyncOrganizationIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodesUpdatePayload.class.getRecordComponents())
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
                        "checksumMismatchSelfHealCooldownMinutes");
    }
}
