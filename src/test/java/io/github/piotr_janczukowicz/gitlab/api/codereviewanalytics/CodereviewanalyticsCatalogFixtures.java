package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.Map;

public final class CodereviewanalyticsCatalogFixtures {

    private CodereviewanalyticsCatalogFixtures() {}

    public static GitLabAnalyticsCodeReviewMergeRequest analyticsCodeReviewMergeRequest() {
        return GitLabAnalyticsCodeReviewMergeRequestBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Test MR 1580978354")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("http://local.gitlab.test:8181/root/merge-train-race-condition/-/merge_requests/59")
                .milestone(CommonCatalogFixtures.milestone())
                .author(CommonCatalogFixtures.userBasic())
                .approvedBy(CommonCatalogFixtures.userBasic())
                .notesCount(1)
                .reviewTime(1)
                .diffStats(Map.of("key", "value"))
                .build();
    }
}
