package io.github.piotr_janczukowicz.gitlab.api.projectbadges;

public final class ProjectbadgesCatalogFixtures {

    private ProjectbadgesCatalogFixtures() {}

    public static GitLabProjectProjectBadgesCreatePayload projectProjectBadgesCreatePayload() {
        return GitLabProjectProjectBadgesCreatePayloadBuilder.builder()
                .linkUrl("link_url")
                .imageUrl("image_url")
                .name("name")
                .build();
    }

    public static GitLabProjectProjectBadgesUpdatePayload projectProjectBadgesUpdatePayload() {
        return GitLabProjectProjectBadgesUpdatePayloadBuilder.builder()
                .linkUrl("link_url")
                .imageUrl("image_url")
                .name("name")
                .build();
    }
}
