package io.github.piotr_janczukowicz.gitlab.api.projectrepositorystoragemoves;

public final class ProjectrepositorystoragemovesCatalogFixtures {

    private ProjectrepositorystoragemovesCatalogFixtures() {}

    public static GitLabProjectRepositoryStorageMovesCreatePayload projectRepositoryStorageMovesCreatePayload() {
        return GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder()
                .sourceStorageName("source_storage_name")
                .destinationStorageName("destination_storage_name")
                .build();
    }
}
