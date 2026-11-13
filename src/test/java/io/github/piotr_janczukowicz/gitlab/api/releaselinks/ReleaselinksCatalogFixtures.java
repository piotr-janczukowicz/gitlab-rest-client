package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

public final class ReleaselinksCatalogFixtures {

    private ReleaselinksCatalogFixtures() {}

    public static GitLabProjectReleaseLinksCreatePayload projectReleaseLinksCreatePayload() {
        return GitLabProjectReleaseLinksCreatePayloadBuilder.builder()
                .name("name")
                .url("url")
                .directAssetPath("direct_asset_path")
                .filepath("filepath")
                .linkType(GitLabProjectReleaseLinksCreateLinkType.OTHER)
                .build();
    }

    public static GitLabProjectReleaseLinksUpdatePayload projectReleaseLinksUpdatePayload() {
        return GitLabProjectReleaseLinksUpdatePayloadBuilder.builder()
                .name("name")
                .url("url")
                .directAssetPath("direct_asset_path")
                .filepath("filepath")
                .linkType(GitLabProjectReleaseLinksUpdateLinkType.OTHER)
                .build();
    }

    public static GitLabReleaseLink releaseLink() {
        return GitLabReleaseLinkBuilder.builder()
                .id(1L)
                .name("app-v1.0.dmg")
                .url("https://gitlab.example.com/root/app/-/jobs/688/artifacts/raw/bin/app-v1.0.dmg")
                .directAssetUrl("https://gitlab.example.com/root/app/-/releases/v1.0/downloads/app-v1.0.dmg")
                .linkType("other")
                .build();
    }
}
