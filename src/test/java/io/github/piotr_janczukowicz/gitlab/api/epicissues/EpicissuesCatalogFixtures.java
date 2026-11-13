package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.Map;

public final class EpicissuesCatalogFixtures {

    private EpicissuesCatalogFixtures() {}

    public static GitLabEpicIssueLink epicIssueLink() {
        return GitLabEpicIssueLinkBuilder.builder()
                .id(1L)
                .relativePosition(1)
                .epic(Map.of("key", "value"))
                .issue(CommonCatalogFixtures.issueBasic())
                .build();
    }

    public static GitLabGroupEpicIssuesUpdatePayload groupEpicIssuesUpdatePayload() {
        return GitLabGroupEpicIssuesUpdatePayloadBuilder.builder()
                .moveBeforeId("text")
                .moveAfterId("text")
                .page(1)
                .perPage(1)
                .build();
    }
}
