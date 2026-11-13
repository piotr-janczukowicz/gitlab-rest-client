package io.github.piotr_janczukowicz.gitlab.api.searchadmin;

import java.time.Instant;
import java.util.Map;

public final class SearchadminCatalogFixtures {

    private SearchadminCatalogFixtures() {}

    public static GitLabSearchMigration searchMigration() {
        return GitLabSearchMigrationBuilder.builder()
                .version(1)
                .name("BackfillHiddenOnMergeRequests")
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .completedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .completed(true)
                .obsolete(true)
                .migrationState(Map.of("key", "value"))
                .build();
    }
}
