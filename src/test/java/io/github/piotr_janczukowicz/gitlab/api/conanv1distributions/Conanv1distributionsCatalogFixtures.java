package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import java.util.Map;

public final class Conanv1distributionsCatalogFixtures {

    private Conanv1distributionsCatalogFixtures() {}

    public static GitLabPackageConanPackageManifest packageConanPackageManifest() {
        return GitLabPackageConanPackageManifestBuilder.builder()
                .packageUrls(Map.of("key", "value"))
                .build();
    }

    public static GitLabPackageConanPackageSnapshot packageConanPackageSnapshot() {
        return GitLabPackageConanPackageSnapshotBuilder.builder()
                .packageSnapshot(Map.of("key", "value"))
                .build();
    }

    public static GitLabPackageConanRecipeManifest packageConanRecipeManifest() {
        return GitLabPackageConanRecipeManifestBuilder.builder()
                .recipeUrls(Map.of("key", "value"))
                .build();
    }

    public static GitLabPackageConanRecipeSnapshot packageConanRecipeSnapshot() {
        return GitLabPackageConanRecipeSnapshotBuilder.builder()
                .recipeSnapshot(Map.of("key", "value"))
                .build();
    }

    public static GitLabPackageConanUploadUrls packageConanUploadUrls() {
        return GitLabPackageConanUploadUrlsBuilder.builder()
                .uploadUrls(Map.of("key", "value"))
                .build();
    }
}
