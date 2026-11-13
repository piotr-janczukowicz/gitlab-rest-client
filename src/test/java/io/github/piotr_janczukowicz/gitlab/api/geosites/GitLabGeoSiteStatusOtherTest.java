package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusOtherTest {

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeIdIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .geoNodeId(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.geoNodeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .projectsCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.projectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitFetchEventCountWeeklyIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .gitFetchEventCountWeekly(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.gitFetchEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitPushEventCountWeeklyIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .gitPushEventCountWeekly(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.gitPushEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyRemoteRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .proxyRemoteRequestsEventCountWeekly(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.proxyRemoteRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyLocalRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .proxyLocalRequestsEventCountWeekly(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.proxyLocalRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedInPercentageIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .repositoriesCheckedInPercentage(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .repositoriesCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.repositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .repositoriesCheckedCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedFailedCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .repositoriesCheckedFailedCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsUsedInPercentageIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .replicationSlotsUsedInPercentage(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.replicationSlotsUsedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .replicationSlotsCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.replicationSlotsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsUsedCountIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .replicationSlotsUsedCount(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.replicationSlotsUsedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsMaxRetainedWalBytesIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .replicationSlotsMaxRetainedWalBytes(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.replicationSlotsMaxRetainedWalBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthyIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .healthy(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.healthy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .health(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.health()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .healthStatus(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMissingOauthApplicationIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .missingOauthApplication(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.missingOauthApplication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDbReplicationLagSecondsIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .dbReplicationLagSeconds(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.dbReplicationLagSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventIdIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .lastEventId(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.lastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventTimestampIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .lastEventTimestamp(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.lastEventTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSuccessfulStatusCheckTimestampIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .lastSuccessfulStatusCheckTimestamp(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.lastSuccessfulStatusCheckTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventIdIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .cursorLastEventId(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.cursorLastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventTimestampIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .cursorLastEventTimestamp(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.cursorLastEventTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .version(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .revision(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .selectiveSyncType(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacesIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .namespaces(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.namespaces()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .updatedAt(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageShardsIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .storageShards(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.storageShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageShardsMatchIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .storageShardsMatch(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.storageShardsMatch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .links(null);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusOther value = GeositesCatalogFixtures.geoSiteStatusOther();

        assertSoftly(softly -> {
            softly.assertThat(value.geoNodeId()).isEqualTo("geo_node_id");
            softly.assertThat(value.projectsCount()).isEqualTo("projects_count");
            softly.assertThat(value.gitFetchEventCountWeekly()).isEqualTo("git_fetch_event_count_weekly");
            softly.assertThat(value.gitPushEventCountWeekly()).isEqualTo("git_push_event_count_weekly");
            softly.assertThat(value.proxyRemoteRequestsEventCountWeekly())
                    .isEqualTo("proxy_remote_requests_event_count_weekly");
            softly.assertThat(value.proxyLocalRequestsEventCountWeekly())
                    .isEqualTo("proxy_local_requests_event_count_weekly");
            softly.assertThat(value.repositoriesCheckedInPercentage()).isEqualTo("repositories_checked_in_percentage");
            softly.assertThat(value.repositoriesCount()).isEqualTo("repositories_count");
            softly.assertThat(value.repositoriesCheckedCount()).isEqualTo("repositories_checked_count");
            softly.assertThat(value.repositoriesCheckedFailedCount()).isEqualTo("repositories_checked_failed_count");
            softly.assertThat(value.replicationSlotsUsedInPercentage())
                    .isEqualTo("replication_slots_used_in_percentage");
            softly.assertThat(value.replicationSlotsCount()).isEqualTo("replication_slots_count");
            softly.assertThat(value.replicationSlotsUsedCount()).isEqualTo("replication_slots_used_count");
            softly.assertThat(value.replicationSlotsMaxRetainedWalBytes())
                    .isEqualTo("replication_slots_max_retained_wal_bytes");
            softly.assertThat(value.healthy()).isEqualTo("healthy");
            softly.assertThat(value.health()).isEqualTo("health");
            softly.assertThat(value.healthStatus()).isEqualTo("health_status");
            softly.assertThat(value.missingOauthApplication()).isEqualTo("missing_oauth_application");
            softly.assertThat(value.dbReplicationLagSeconds()).isEqualTo("db_replication_lag_seconds");
            softly.assertThat(value.lastEventId()).isEqualTo("last_event_id");
            softly.assertThat(value.lastEventTimestamp()).isEqualTo("last_event_timestamp");
            softly.assertThat(value.lastSuccessfulStatusCheckTimestamp())
                    .isEqualTo("last_successful_status_check_timestamp");
            softly.assertThat(value.cursorLastEventId()).isEqualTo("cursor_last_event_id");
            softly.assertThat(value.cursorLastEventTimestamp()).isEqualTo("cursor_last_event_timestamp");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.revision()).isEqualTo("revision");
            softly.assertThat(value.selectiveSyncType()).isEqualTo("selective_sync_type");
            softly.assertThat(value.namespaces()).isEqualTo(CommonCatalogFixtures.namespaceBasic());
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.storageShards()).isEqualTo(CommonCatalogFixtures.storageShardEntity());
            softly.assertThat(value.storageShardsMatch()).isEqualTo("storage_shards_match");
            softly.assertThat(value.links()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusOther original = GeositesCatalogFixtures.geoSiteStatusOther();

        final GitLabGeoSiteStatusOther rebuilt =
                GitLabGeoSiteStatusOtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGeoSiteStatusOtherBuilder builder = GitLabGeoSiteStatusOtherBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusOther())
                .updatedAt(instant);

        final GitLabGeoSiteStatusOther built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusOther.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "geoNodeId",
                        "projectsCount",
                        "gitFetchEventCountWeekly",
                        "gitPushEventCountWeekly",
                        "proxyRemoteRequestsEventCountWeekly",
                        "proxyLocalRequestsEventCountWeekly",
                        "repositoriesCheckedInPercentage",
                        "repositoriesCount",
                        "repositoriesCheckedCount",
                        "repositoriesCheckedFailedCount",
                        "replicationSlotsUsedInPercentage",
                        "replicationSlotsCount",
                        "replicationSlotsUsedCount",
                        "replicationSlotsMaxRetainedWalBytes",
                        "healthy",
                        "health",
                        "healthStatus",
                        "missingOauthApplication",
                        "dbReplicationLagSeconds",
                        "lastEventId",
                        "lastEventTimestamp",
                        "lastSuccessfulStatusCheckTimestamp",
                        "cursorLastEventId",
                        "cursorLastEventTimestamp",
                        "version",
                        "revision",
                        "selectiveSyncType",
                        "namespaces",
                        "updatedAt",
                        "storageShards",
                        "storageShardsMatch",
                        "links");
    }
}
