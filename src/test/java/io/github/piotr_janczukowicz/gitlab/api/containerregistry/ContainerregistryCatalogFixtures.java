package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import java.time.Instant;

public final class ContainerregistryCatalogFixtures {

    private ContainerregistryCatalogFixtures() {}

    public static GitLabContainerRegistryTagDetails containerRegistryTagDetails() {
        return GitLabContainerRegistryTagDetailsBuilder.builder()
                .name("latest")
                .path("namespace1/project1/test_image_1:latest")
                .location("registry.dev/namespace1/project1/test_image_1:latest")
                .revision("tagrevision")
                .shortRevision("shortrevison")
                .digest("shadigest")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .totalSize(1L)
                .build();
    }
}
