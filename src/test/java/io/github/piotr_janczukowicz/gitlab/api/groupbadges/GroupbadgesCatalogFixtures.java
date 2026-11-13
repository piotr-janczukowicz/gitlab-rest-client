package io.github.piotr_janczukowicz.gitlab.api.groupbadges;

public final class GroupbadgesCatalogFixtures {

    private GroupbadgesCatalogFixtures() {}

    public static GitLabGroupGroupBadgesCreatePayload groupGroupBadgesCreatePayload() {
        return GitLabGroupGroupBadgesCreatePayloadBuilder.builder()
                .linkUrl("link_url")
                .imageUrl("image_url")
                .name("name")
                .build();
    }

    public static GitLabGroupGroupBadgesUpdatePayload groupGroupBadgesUpdatePayload() {
        return GitLabGroupGroupBadgesUpdatePayloadBuilder.builder()
                .linkUrl("link_url")
                .imageUrl("image_url")
                .name("name")
                .build();
    }
}
