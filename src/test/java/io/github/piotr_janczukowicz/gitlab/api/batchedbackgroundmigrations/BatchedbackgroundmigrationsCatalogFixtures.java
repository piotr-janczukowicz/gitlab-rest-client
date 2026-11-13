package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import java.time.Instant;

public final class BatchedbackgroundmigrationsCatalogFixtures {

    private BatchedbackgroundmigrationsCatalogFixtures() {}

    public static GitLabBatchedBackgroundMigration batchedBackgroundMigration() {
        return GitLabBatchedBackgroundMigrationBuilder.builder()
                .id("1234")
                .jobClassName("CopyColumnUsingBackgroundMigrationJob")
                .tableName("events")
                .columnName("id")
                .status("active")
                .progress(1.5)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .estimatedTimeRemaining("1 day")
                .build();
    }

    public static GitLabBatchedBackgroundMigrationsPausePayload batchedBackgroundMigrationsPausePayload() {
        return GitLabBatchedBackgroundMigrationsPausePayloadBuilder.builder()
                .database(GitLabBatchedBackgroundMigrationsPauseDatabase.MAIN)
                .build();
    }

    public static GitLabBatchedBackgroundMigrationsResumePayload batchedBackgroundMigrationsResumePayload() {
        return GitLabBatchedBackgroundMigrationsResumePayloadBuilder.builder()
                .database(GitLabBatchedBackgroundMigrationsResumeDatabase.MAIN)
                .build();
    }

    public static GitLabBatchedBackgroundOperation batchedBackgroundOperation() {
        return GitLabBatchedBackgroundOperationBuilder.builder()
                .id("<cluster>:<partition_id>:<id/uuid>")
                .partition(1)
                .jobClassName("UsersDeleteUnconfirmedSecondaryEmails")
                .tableName("users")
                .columnName("id")
                .status("active")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .onHoldUntil(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabBatchedMigrationRestartPayload batchedMigrationRestartPayload() {
        return GitLabBatchedMigrationRestartPayloadBuilder.builder()
                .database(GitLabBatchedMigrationRestartDatabase.MAIN)
                .build();
    }

    public static GitLabBatchedMigrationStopPayload batchedMigrationStopPayload() {
        return GitLabBatchedMigrationStopPayloadBuilder.builder()
                .database(GitLabBatchedMigrationStopDatabase.MAIN)
                .build();
    }
}
