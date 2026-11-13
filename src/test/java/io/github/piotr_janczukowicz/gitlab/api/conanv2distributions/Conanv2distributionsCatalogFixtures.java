package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import java.util.List;
import java.util.Map;

public final class Conanv2distributionsCatalogFixtures {

    private Conanv2distributionsCatalogFixtures() {}

    public static GitLabPackageConanFilesList packageConanFilesList() {
        return GitLabPackageConanFilesListBuilder.builder()
                .files(Map.of("key", "value"))
                .build();
    }

    public static GitLabPackageConanPackageRevisions packageConanPackageRevisions() {
        return GitLabPackageConanPackageRevisionsBuilder.builder()
                .packageReference(
                        "packageTest/1.2.3@gitlab-org+conan/stable#1883c9f810f2d6e5b59d5285c7141970:133a1f2158ff2cf69739f316ec21143785be54c7")
                .revisions(List.of(Conanv2distributionsCatalogFixtures.packageConanRevision()))
                .build();
    }

    public static GitLabPackageConanRecipeRevisions packageConanRecipeRevisions() {
        return GitLabPackageConanRecipeRevisionsBuilder.builder()
                .reference("packageTest/1.2.3@gitlab-org+conan/stable")
                .revisions(List.of(Conanv2distributionsCatalogFixtures.packageConanRevision()))
                .build();
    }

    public static GitLabPackageConanRevision packageConanRevision() {
        return GitLabPackageConanRevisionBuilder.builder()
                .revision("75151329520e7685dcf5da49ded2fec0")
                .time("2024-12-17T09:16:40.334Z")
                .build();
    }
}
