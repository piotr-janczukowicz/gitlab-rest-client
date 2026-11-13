package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateRepositoryStorageMovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabProjectProjectsCreateRepositoryStorageMovePayloadBuilder builder =
                GitLabProjectProjectsCreateRepositoryStorageMovePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload())
                        .destinationStorageName(null);

        final GitLabProjectProjectsCreateRepositoryStorageMovePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateRepositoryStorageMovePayload value =
                ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload();

        assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateRepositoryStorageMovePayload original =
                ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload();

        final GitLabProjectProjectsCreateRepositoryStorageMovePayload rebuilt =
                GitLabProjectProjectsCreateRepositoryStorageMovePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateRepositoryStorageMovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("destinationStorageName");
    }
}
