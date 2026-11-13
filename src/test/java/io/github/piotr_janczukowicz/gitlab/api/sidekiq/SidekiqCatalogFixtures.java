package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

public final class SidekiqCatalogFixtures {

    private SidekiqCatalogFixtures() {}

    public static GitLabSidekiqConcurrencyLimit sidekiqConcurrencyLimit() {
        return GitLabSidekiqConcurrencyLimitBuilder.builder()
                .workerClass("AuthorizedProjectsWorker")
                .classLimit(1)
                .effectiveLimit(1)
                .adaptiveLimit(1)
                .defaultLimitRequiresShardContext(true)
                .middlewareEnabled(true)
                .disabledForWorker(true)
                .overrideLimit(1)
                .overrideTtl(1)
                .runningJobs(1)
                .deferredJobs(1)
                .build();
    }

    public static GitLabSidekiqUpdateConcurrencyLimitPayload sidekiqUpdateConcurrencyLimitPayload() {
        return GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder()
                .limit(1)
                .ttl(1)
                .build();
    }
}
