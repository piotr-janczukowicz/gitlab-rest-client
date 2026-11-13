package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsCreateRepositoryStorageMovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabGroupGroupsCreateRepositoryStorageMovePayloadBuilder builder =
                GitLabGroupGroupsCreateRepositoryStorageMovePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload())
                        .destinationStorageName(null);

        final GitLabGroupGroupsCreateRepositoryStorageMovePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsCreateRepositoryStorageMovePayload value =
                GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload();

        assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsCreateRepositoryStorageMovePayload original =
                GroupsCatalogFixtures.groupGroupsCreateRepositoryStorageMovePayload();

        final GitLabGroupGroupsCreateRepositoryStorageMovePayload rebuilt =
                GitLabGroupGroupsCreateRepositoryStorageMovePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsCreateRepositoryStorageMovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("destinationStorageName");
    }
}
