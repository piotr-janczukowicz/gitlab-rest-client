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
class GitLabGeoNodesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPrimaryIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .primary(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.primary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .enabled(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .name(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .url(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalUrlIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .internalUrl(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.internalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesMaxCapacityIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .filesMaxCapacity(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.filesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFilesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .filesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFilesMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .filesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReposMaxCapacityIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .reposMaxCapacity(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.reposMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReposMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .reposMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReposMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .reposMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationMaxCapacityIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .verificationMaxCapacity(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.verificationMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenVerificationMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .verificationMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenVerificationMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .verificationMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRepositoriesMaxCapacityIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .containerRepositoriesMaxCapacity(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.containerRepositoriesMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContainerRepositoriesMaxCapacityIsBelowTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .containerRepositoriesMaxCapacity(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContainerRepositoriesMaxCapacityIsTheMinimum() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .containerRepositoriesMaxCapacity(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSyncObjectStorageIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .syncObjectStorage(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.syncObjectStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncType(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncShardsIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncShards(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncNamespaceIdsIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncNamespaceIds(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncOrganizationIdsIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncOrganizationIds(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.selectiveSyncOrganizationIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumReverificationIntervalIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .minimumReverificationInterval(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.minimumReverificationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchReportThresholdIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .checksumMismatchReportThreshold(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.checksumMismatchReportThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumMismatchSelfHealCooldownMinutesIsNullable() {
        final GitLabGeoNodesCreatePayloadBuilder builder = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .checksumMismatchSelfHealCooldownMinutes(null);

        final GitLabGeoNodesCreatePayload built = builder.build();

        assertThat(built.checksumMismatchSelfHealCooldownMinutes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodesCreatePayload value = GeonodesCatalogFixtures.geoNodesCreatePayload();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodesCreatePayload original = GeonodesCatalogFixtures.geoNodesCreatePayload();

        final GitLabGeoNodesCreatePayload rebuilt =
                GitLabGeoNodesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncShardsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("selective_sync_shards"));
        final GitLabGeoNodesCreatePayload built = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncShards(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncShards()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncShardsIsRead() {
        final GitLabGeoNodesCreatePayload built = GeonodesCatalogFixtures.geoNodesCreatePayload();
        final List<String> values = built.selectiveSyncShards();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncNamespaceIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoNodesCreatePayload built = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncNamespaceIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncNamespaceIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncNamespaceIdsIsRead() {
        final GitLabGeoNodesCreatePayload built = GeonodesCatalogFixtures.geoNodesCreatePayload();
        final List<Long> values = built.selectiveSyncNamespaceIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSelectiveSyncOrganizationIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGeoNodesCreatePayload built = GitLabGeoNodesCreatePayloadBuilder.builder(
                        GeonodesCatalogFixtures.geoNodesCreatePayload())
                .selectiveSyncOrganizationIds(source)
                .build();
        source.clear();

        assertThat(built.selectiveSyncOrganizationIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSelectiveSyncOrganizationIdsIsRead() {
        final GitLabGeoNodesCreatePayload built = GeonodesCatalogFixtures.geoNodesCreatePayload();
        final List<Long> values = built.selectiveSyncOrganizationIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodesCreatePayload.class.getRecordComponents())
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
                        "checksumMismatchSelfHealCooldownMinutes");
    }
}
