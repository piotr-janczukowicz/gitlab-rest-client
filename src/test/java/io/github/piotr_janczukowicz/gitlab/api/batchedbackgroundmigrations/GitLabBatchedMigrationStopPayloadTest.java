package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedMigrationStopPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedMigrationStopPayloadBuilder builder = GitLabBatchedMigrationStopPayloadBuilder.builder(
                        BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload())
                .database(null);

        final GitLabBatchedMigrationStopPayload built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedMigrationStopPayload value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload();

        assertThat(value.database()).isEqualTo(GitLabBatchedMigrationStopDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedMigrationStopPayload original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload();

        final GitLabBatchedMigrationStopPayload rebuilt =
                GitLabBatchedMigrationStopPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedMigrationStopPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }
}
