package io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves;

public final class SnippetrepositorystoragemovesCatalogFixtures {

    private SnippetrepositorystoragemovesCatalogFixtures() {}

    public static GitLabSnippetRepositoryStorageMovesCreatePayload snippetRepositoryStorageMovesCreatePayload() {
        return GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder()
                .sourceStorageName("source_storage_name")
                .destinationStorageName("destination_storage_name")
                .build();
    }
}
