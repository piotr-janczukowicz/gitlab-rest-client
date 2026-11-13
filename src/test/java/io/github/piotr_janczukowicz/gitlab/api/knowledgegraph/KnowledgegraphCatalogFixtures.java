package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import java.time.Instant;

public final class KnowledgegraphCatalogFixtures {

    private KnowledgegraphCatalogFixtures() {}

    public static GitLabAnalyticsKnowledgeGraphEnabledNamespace analyticsKnowledgeGraphEnabledNamespace() {
        return GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder.builder()
                .id(1L)
                .rootNamespaceId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
