package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusOtherTest {

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeIdIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .geoNodeId(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.geoNodeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .projectsCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.projectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitFetchEventCountWeeklyIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .gitFetchEventCountWeekly(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.gitFetchEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitPushEventCountWeeklyIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .gitPushEventCountWeekly(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.gitPushEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyRemoteRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .proxyRemoteRequestsEventCountWeekly(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.proxyRemoteRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProxyLocalRequestsEventCountWeeklyIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .proxyLocalRequestsEventCountWeekly(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.proxyLocalRequestsEventCountWeekly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedInPercentageIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .repositoriesCheckedInPercentage(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .repositoriesCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.repositoriesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .repositoriesCheckedCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoriesCheckedFailedCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .repositoriesCheckedFailedCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.repositoriesCheckedFailedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsUsedInPercentageIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .replicationSlotsUsedInPercentage(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.replicationSlotsUsedInPercentage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .replicationSlotsCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.replicationSlotsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsUsedCountIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .replicationSlotsUsedCount(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.replicationSlotsUsedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsMaxRetainedWalBytesIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .replicationSlotsMaxRetainedWalBytes(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.replicationSlotsMaxRetainedWalBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthyIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .healthy(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.healthy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .health(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.health()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .healthStatus(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMissingOauthApplicationIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .missingOauthApplication(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.missingOauthApplication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDbReplicationLagSecondsIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .dbReplicationLagSeconds(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.dbReplicationLagSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventIdIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .lastEventId(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.lastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventTimestampIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .lastEventTimestamp(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.lastEventTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSuccessfulStatusCheckTimestampIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .lastSuccessfulStatusCheckTimestamp(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.lastSuccessfulStatusCheckTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventIdIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .cursorLastEventId(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.cursorLastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventTimestampIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .cursorLastEventTimestamp(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.cursorLastEventTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .version(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .revision(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveSyncTypeIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .selectiveSyncType(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.selectiveSyncType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacesIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .namespaces(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.namespaces()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .updatedAt(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageShardsIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .storageShards(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.storageShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageShardsMatchIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .storageShardsMatch(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.storageShardsMatch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .links(null);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusOther value = CommonCatalogFixtures.geoNodeStatusOther();

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
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.geoNodeStatusLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusOther original = CommonCatalogFixtures.geoNodeStatusOther();

        final GitLabGeoNodeStatusOther rebuilt =
                GitLabGeoNodeStatusOtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGeoNodeStatusOtherBuilder builder = GitLabGeoNodeStatusOtherBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusOther())
                .updatedAt(instant);

        final GitLabGeoNodeStatusOther built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusOther.class.getRecordComponents())
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
