package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import java.time.Instant;

public final class FeatureflaguserlistsCatalogFixtures {

    private FeatureflaguserlistsCatalogFixtures() {}

    public static GitLabFeatureFlagUserList featureFlagUserList() {
        return GitLabFeatureFlagUserListBuilder.builder()
                .id(1L)
                .iid(1L)
                .name("user_list")
                .userXids("user1,user2")
                .projectId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .editPath("edit_path")
                .build();
    }

    public static GitLabProjectFeatureFlagUserListsCreatePayload projectFeatureFlagUserListsCreatePayload() {
        return GitLabProjectFeatureFlagUserListsCreatePayloadBuilder.builder()
                .name("name")
                .userXids("user_xids")
                .build();
    }

    public static GitLabProjectFeatureFlagUserListsUpdatePayload projectFeatureFlagUserListsUpdatePayload() {
        return GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder.builder()
                .name("name")
                .userXids("user_xids")
                .build();
    }
}
