package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;

public final class ProjectstatisticsCatalogFixtures {

    private ProjectstatisticsCatalogFixtures() {}

    public static GitLabProjectDailyStatistics projectDailyStatistics() {
        return GitLabProjectDailyStatisticsBuilder.builder()
                .fetches(ProjectstatisticsCatalogFixtures.projectDailyStatisticsFetches())
                .build();
    }

    public static GitLabProjectDailyStatisticsFetches projectDailyStatisticsFetches() {
        return GitLabProjectDailyStatisticsFetchesBuilder.builder()
                .total(1)
                .days(List.of(CommonCatalogFixtures.projectDailyFetches()))
                .build();
    }
}
