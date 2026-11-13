package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

public final class DatabasemigrationsCatalogFixtures {

    private DatabasemigrationsCatalogFixtures() {}

    public static GitLabDatabaseMigrationsCreatePayload databaseMigrationsCreatePayload() {
        return GitLabDatabaseMigrationsCreatePayloadBuilder.builder()
                .database(GitLabDatabaseMigrationsCreateDatabase.MAIN)
                .build();
    }
}
