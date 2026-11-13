package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import java.time.Instant;

public final class FreezeperiodsCatalogFixtures {

    private FreezeperiodsCatalogFixtures() {}

    public static GitLabFreezePeriod freezePeriod() {
        return GitLabFreezePeriodBuilder.builder()
                .id(1L)
                .freezeStart("0 23 * * 5")
                .freezeEnd("0 8 * * 1")
                .cronTimezone("UTC")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectFreezePeriodsCreatePayload projectFreezePeriodsCreatePayload() {
        return GitLabProjectFreezePeriodsCreatePayloadBuilder.builder()
                .freezeStart("freeze_start")
                .freezeEnd("freeze_end")
                .cronTimezone("cron_timezone")
                .build();
    }

    public static GitLabProjectFreezePeriodsUpdatePayload projectFreezePeriodsUpdatePayload() {
        return GitLabProjectFreezePeriodsUpdatePayloadBuilder.builder()
                .freezeStart("freeze_start")
                .freezeEnd("freeze_end")
                .cronTimezone("cron_timezone")
                .build();
    }
}
