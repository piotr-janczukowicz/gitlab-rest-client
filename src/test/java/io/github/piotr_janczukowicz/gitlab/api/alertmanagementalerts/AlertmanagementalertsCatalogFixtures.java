package io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;

import java.time.Instant;

public final class AlertmanagementalertsCatalogFixtures {

    private AlertmanagementalertsCatalogFixtures() {}

    public static GitLabMetricImage metricImage() {
        return GitLabMetricImageBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .filename("file.png")
                .filePath("/uploads/-/system/alert_metric_image/file/23/file.png")
                .url("https://example.com/metric")
                .urlText("An example metric")
                .build();
    }
}
