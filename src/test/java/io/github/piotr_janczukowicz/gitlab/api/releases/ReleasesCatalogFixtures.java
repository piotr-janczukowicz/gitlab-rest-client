package io.github.piotr_janczukowicz.gitlab.api.releases;

import java.time.Instant;
import java.util.List;

public final class ReleasesCatalogFixtures {

    private ReleasesCatalogFixtures() {}

    public static GitLabProjectReleasesCreateAssets projectReleasesCreateAssets() {
        return GitLabProjectReleasesCreateAssetsBuilder.builder()
                .links(List.of(ReleasesCatalogFixtures.projectReleasesCreateAssetsLink()))
                .build();
    }

    public static GitLabProjectReleasesCreateAssetsLink projectReleasesCreateAssetsLink() {
        return GitLabProjectReleasesCreateAssetsLinkBuilder.builder()
                .name("name")
                .url("url")
                .directAssetPath("direct_asset_path")
                .filepath("filepath")
                .linkType(GitLabProjectReleasesCreateAssetsLinkType.OTHER)
                .build();
    }

    public static GitLabProjectReleasesCreatePayload projectReleasesCreatePayload() {
        return GitLabProjectReleasesCreatePayloadBuilder.builder()
                .tagName("tag_name")
                .tagMessage("tag_message")
                .name("name")
                .description("description")
                .ref("ref")
                .assets(ReleasesCatalogFixtures.projectReleasesCreateAssets())
                .milestones(List.of("milestones"))
                .milestoneIds("text")
                .releasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .legacyCatalogPublish(true)
                .build();
    }

    public static GitLabProjectReleasesUpdatePayload projectReleasesUpdatePayload() {
        return GitLabProjectReleasesUpdatePayloadBuilder.builder()
                .name("name")
                .description("description")
                .releasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .milestones(List.of("milestones"))
                .milestoneIds("text")
                .build();
    }
}
