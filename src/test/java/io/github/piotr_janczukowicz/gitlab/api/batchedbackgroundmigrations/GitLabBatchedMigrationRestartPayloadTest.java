package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedMigrationRestartPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedMigrationRestartPayloadBuilder builder = GitLabBatchedMigrationRestartPayloadBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload())
                .database(null);

        final GitLabBatchedMigrationRestartPayload built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedMigrationRestartPayload value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload();

        assertThat(value.database()).isEqualTo(GitLabBatchedMigrationRestartDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedMigrationRestartPayload original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload();

        final GitLabBatchedMigrationRestartPayload rebuilt =
                GitLabBatchedMigrationRestartPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedMigrationRestartPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }
}
