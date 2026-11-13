package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab diff stat.
 *
 * @param path the path
 * @param oldPath the old path
 * @param additions the additions
 * @param deletions the deletions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDiffStat")
public record GitLabDiffStat(
        @Nullable String path,
        @Nullable String oldPath,
        @Nullable Integer additions,
        @Nullable Integer deletions) {}
