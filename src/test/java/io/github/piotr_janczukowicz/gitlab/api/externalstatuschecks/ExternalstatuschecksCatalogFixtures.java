package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;

public final class ExternalstatuschecksCatalogFixtures {

    private ExternalstatuschecksCatalogFixtures() {}

    public static GitLabExternalStatusCheck externalStatusCheck() {
        return GitLabExternalStatusCheckBuilder.builder()
                .id(1L)
                .name("QA")
                .projectId(1L)
                .externalUrl("https://www.example.com")
                .protectedBranches(List.of(CommonCatalogFixtures.protectedBranch()))
                .hmac(true)
                .build();
    }

    public static GitLabMergeRequestsStatusCheck mergeRequestsStatusCheck() {
        return GitLabMergeRequestsStatusCheckBuilder.builder()
                .id(1L)
                .name("QA")
                .externalUrl("https://www.example.com")
                .status("passed")
                .build();
    }

    public static GitLabProjectExternalStatusChecksCreatePayload projectExternalStatusChecksCreatePayload() {
        return GitLabProjectExternalStatusChecksCreatePayloadBuilder.builder()
                .name("QA")
                .sharedSecret("hmac-sha256")
                .externalUrl("https://www.example.com")
                .protectedBranchIds(List.of(1L))
                .build();
    }

    public static GitLabProjectExternalStatusChecksUpdatePayload projectExternalStatusChecksUpdatePayload() {
        return GitLabProjectExternalStatusChecksUpdatePayloadBuilder.builder()
                .name("QA")
                .sharedSecret("hmac-sha256")
                .externalUrl("https://www.example.com")
                .protectedBranchIds(List.of(1L))
                .build();
    }
}
