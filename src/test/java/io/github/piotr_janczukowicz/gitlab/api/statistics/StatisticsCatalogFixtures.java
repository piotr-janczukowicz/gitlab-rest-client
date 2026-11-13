package io.github.piotr_janczukowicz.gitlab.api.statistics;

public final class StatisticsCatalogFixtures {

    private StatisticsCatalogFixtures() {}

    public static GitLabApplicationStatistics applicationStatistics() {
        return GitLabApplicationStatisticsBuilder.builder()
                .forks(1)
                .issues(1)
                .mergeRequests(1)
                .notes(1)
                .snippets(1)
                .sshKeys(1)
                .milestones(1)
                .users(1)
                .projects(1)
                .groups(1)
                .activeUsers(1)
                .build();
    }
}
