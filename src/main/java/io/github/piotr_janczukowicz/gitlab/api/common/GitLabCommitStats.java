package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab commit stats.
 *
 * @param additions the additions
 * @param deletions the deletions
 * @param total the total
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCommitStats")
public record GitLabCommitStats(
        @Nullable Integer additions,
        @Nullable Integer deletions,
        @Nullable Integer total) {}
