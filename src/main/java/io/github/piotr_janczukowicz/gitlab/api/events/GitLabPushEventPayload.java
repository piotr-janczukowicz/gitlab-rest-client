package io.github.piotr_janczukowicz.gitlab.api.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab push event payload.
 *
 * @param commitCount the commit count
 * @param action the action
 * @param refType the ref type
 * @param commitFrom the commit from
 * @param commitTo the commit to
 * @param ref the ref
 * @param commitTitle the commit title
 * @param refCount the ref count
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPushEventPayload")
public record GitLabPushEventPayload(
        @Nullable Integer commitCount,
        @Nullable String action,
        @Nullable String refType,
        @Nullable String commitFrom,
        @Nullable String commitTo,
        @Nullable String ref,
        @Nullable String commitTitle,
        @Nullable Integer refCount) {}
