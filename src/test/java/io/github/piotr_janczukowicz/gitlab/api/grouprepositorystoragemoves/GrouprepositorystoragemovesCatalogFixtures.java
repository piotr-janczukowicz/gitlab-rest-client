package io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves;

public final class GrouprepositorystoragemovesCatalogFixtures {

    private GrouprepositorystoragemovesCatalogFixtures() {}

    public static GitLabGroupRepositoryStorageMovesCreatePayload groupRepositoryStorageMovesCreatePayload() {
        return GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder()
                .sourceStorageName("source_storage_name")
                .destinationStorageName("destination_storage_name")
                .build();
    }
}
