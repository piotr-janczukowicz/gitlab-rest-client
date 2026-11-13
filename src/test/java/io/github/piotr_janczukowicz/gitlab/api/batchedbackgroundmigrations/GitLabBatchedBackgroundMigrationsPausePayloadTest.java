package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedBackgroundMigrationsPausePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedBackgroundMigrationsPausePayloadBuilder builder =
                GitLabBatchedBackgroundMigrationsPausePayloadBuilder.builder(
                                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload())
                        .database(null);

        final GitLabBatchedBackgroundMigrationsPausePayload built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundMigrationsPausePayload value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload();

        assertThat(value.database()).isEqualTo(GitLabBatchedBackgroundMigrationsPauseDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundMigrationsPausePayload original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload();

        final GitLabBatchedBackgroundMigrationsPausePayload rebuilt =
                GitLabBatchedBackgroundMigrationsPausePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundMigrationsPausePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }
}
