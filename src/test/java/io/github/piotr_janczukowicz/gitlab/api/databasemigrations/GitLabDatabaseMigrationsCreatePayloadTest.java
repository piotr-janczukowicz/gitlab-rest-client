package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDatabaseMigrationsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabDatabaseMigrationsCreatePayloadBuilder builder =
                GitLabDatabaseMigrationsCreatePayloadBuilder.builder(
                                DatabasemigrationsCatalogFixtures.databaseMigrationsCreatePayload())
                        .database(null);

        final GitLabDatabaseMigrationsCreatePayload built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDatabaseMigrationsCreatePayload value =
                DatabasemigrationsCatalogFixtures.databaseMigrationsCreatePayload();

        assertThat(value.database()).isEqualTo(GitLabDatabaseMigrationsCreateDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDatabaseMigrationsCreatePayload original =
                DatabasemigrationsCatalogFixtures.databaseMigrationsCreatePayload();

        final GitLabDatabaseMigrationsCreatePayload rebuilt =
                GitLabDatabaseMigrationsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDatabaseMigrationsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }
}
