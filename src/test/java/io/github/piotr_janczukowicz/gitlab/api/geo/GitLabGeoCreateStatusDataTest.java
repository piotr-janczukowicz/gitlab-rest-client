package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoCreateStatusDataTest {

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeIdIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .geoNodeId(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.geoNodeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDbReplicationLagSecondsIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .dbReplicationLagSeconds(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.dbReplicationLagSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventIdIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .lastEventId(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.lastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastEventDateIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .lastEventDate(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.lastEventDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventIdIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .cursorLastEventId(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.cursorLastEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorLastEventDateIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .cursorLastEventDate(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.cursorLastEventDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSuccessfulStatusCheckAtIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .lastSuccessfulStatusCheckAt(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.lastSuccessfulStatusCheckAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusMessageIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .statusMessage(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.statusMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsCountIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .replicationSlotsCount(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.replicationSlotsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsUsedCountIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .replicationSlotsUsedCount(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.replicationSlotsUsedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicationSlotsMaxRetainedWalBytesIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .replicationSlotsMaxRetainedWalBytes(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.replicationSlotsMaxRetainedWalBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .version(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .revision(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGeoCreateStatusDataBuilder builder = GitLabGeoCreateStatusDataBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusData())
                .status(null);

        final GitLabGeoCreateStatusData built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoCreateStatusData value = GeoCatalogFixtures.geoCreateStatusData();

        assertSoftly(softly -> {
            softly.assertThat(value.geoNodeId()).isEqualTo(1L);
            softly.assertThat(value.dbReplicationLagSeconds()).isEqualTo(1);
            softly.assertThat(value.lastEventId()).isEqualTo(1L);
            softly.assertThat(value.lastEventDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.cursorLastEventId()).isEqualTo(1L);
            softly.assertThat(value.cursorLastEventDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastSuccessfulStatusCheckAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.statusMessage()).isEqualTo("status_message");
            softly.assertThat(value.replicationSlotsCount()).isEqualTo(1);
            softly.assertThat(value.replicationSlotsUsedCount()).isEqualTo(1);
            softly.assertThat(value.replicationSlotsMaxRetainedWalBytes()).isEqualTo(1L);
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.revision()).isEqualTo("revision");
            softly.assertThat(value.status()).isEqualTo(GeoCatalogFixtures.geoCreateStatusDataStatus());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoCreateStatusData original = GeoCatalogFixtures.geoCreateStatusData();

        final GitLabGeoCreateStatusData rebuilt =
                GitLabGeoCreateStatusDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoCreateStatusData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "geoNodeId",
                        "dbReplicationLagSeconds",
                        "lastEventId",
                        "lastEventDate",
                        "cursorLastEventId",
                        "cursorLastEventDate",
                        "lastSuccessfulStatusCheckAt",
                        "statusMessage",
                        "replicationSlotsCount",
                        "replicationSlotsUsedCount",
                        "replicationSlotsMaxRetainedWalBytes",
                        "version",
                        "revision",
                        "status");
    }
}
