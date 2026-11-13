package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;

public final class AccessrequestsCatalogFixtures {

    private AccessrequestsCatalogFixtures() {}

    public static GitLabAccessRequester accessRequester() {
        return GitLabAccessRequesterBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .requestedAt("requested_at")
                .build();
    }

    public static GitLabGroupAccessRequestsApprovePayload groupAccessRequestsApprovePayload() {
        return GitLabGroupAccessRequestsApprovePayloadBuilder.builder()
                .accessLevel(1)
                .build();
    }

    public static GitLabProjectAccessRequestsApprovePayload projectAccessRequestsApprovePayload() {
        return GitLabProjectAccessRequestsApprovePayloadBuilder.builder()
                .accessLevel(1)
                .build();
    }
}
