package io.github.piotr_janczukowicz.gitlab.api.analytics;

public final class AnalyticsCatalogFixtures {

    private AnalyticsCatalogFixtures() {}

    public static GitLabAnalyticsGroupActivityIssuesCount analyticsGroupActivityIssuesCount() {
        return GitLabAnalyticsGroupActivityIssuesCountBuilder.builder()
                .issuesCount(1)
                .tooLarge(true)
                .build();
    }

    public static GitLabAnalyticsGroupActivityMergeRequestsCount analyticsGroupActivityMergeRequestsCount() {
        return GitLabAnalyticsGroupActivityMergeRequestsCountBuilder.builder()
                .mergeRequestsCount(1)
                .tooLarge(true)
                .build();
    }

    public static GitLabAnalyticsGroupActivityNewMembersCount analyticsGroupActivityNewMembersCount() {
        return GitLabAnalyticsGroupActivityNewMembersCountBuilder.builder()
                .newMembersCount(1)
                .tooLarge(true)
                .build();
    }
}
