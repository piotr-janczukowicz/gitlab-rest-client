package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab sidekiq concurrency limit.
 *
 * @param workerClass the worker class
 * @param classLimit the class limit
 * @param effectiveLimit the effective limit
 * @param adaptiveLimit the adaptive limit
 * @param defaultLimitRequiresShardContext the default limit requires shard context
 * @param middlewareEnabled the middleware enabled
 * @param disabledForWorker the disabled for worker
 * @param overrideLimit the override limit
 * @param overrideTtl the override ttl
 * @param runningJobs the running jobs
 * @param deferredJobs the deferred jobs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSidekiqConcurrencyLimit")
public record GitLabSidekiqConcurrencyLimit(
        @Nullable String workerClass,
        @Nullable Integer classLimit,
        @Nullable Integer effectiveLimit,
        @Nullable Integer adaptiveLimit,
        @Nullable Boolean defaultLimitRequiresShardContext,
        @Nullable Boolean middlewareEnabled,
        @Nullable Boolean disabledForWorker,
        @Nullable Integer overrideLimit,
        @Nullable Integer overrideTtl,
        @Nullable Integer runningJobs,
        @Nullable Integer deferredJobs) {}
