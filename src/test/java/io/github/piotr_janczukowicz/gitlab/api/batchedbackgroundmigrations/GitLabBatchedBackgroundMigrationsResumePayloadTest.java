package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchedBackgroundMigrationsResumePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatabaseIsNullable() {
        final GitLabBatchedBackgroundMigrationsResumePayloadBuilder builder =
                GitLabBatchedBackgroundMigrationsResumePayloadBuilder.builder(
                                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload())
                        .database(null);

        final GitLabBatchedBackgroundMigrationsResumePayload built = builder.build();

        assertThat(built.database()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchedBackgroundMigrationsResumePayload value =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload();

        assertThat(value.database()).isEqualTo(GitLabBatchedBackgroundMigrationsResumeDatabase.MAIN);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchedBackgroundMigrationsResumePayload original =
                BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload();

        final GitLabBatchedBackgroundMigrationsResumePayload rebuilt =
                GitLabBatchedBackgroundMigrationsResumePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchedBackgroundMigrationsResumePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("database");
    }
}
