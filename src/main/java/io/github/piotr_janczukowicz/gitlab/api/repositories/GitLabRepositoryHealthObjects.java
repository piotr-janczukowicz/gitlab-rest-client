package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health objects.
 *
 * @param size the size
 * @param recentSize the recent size
 * @param staleSize the stale size
 * @param keepSize the keep size
 * @param packfileCount the packfile count
 * @param reverseIndexCount the reverse index count
 * @param cruftCount the cruft count
 * @param keepCount the keep count
 * @param looseObjectsCount the loose objects count
 * @param staleLooseObjectsCount the stale loose objects count
 * @param looseObjectsGarbageCount the loose objects garbage count
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthObjects")
public record GitLabRepositoryHealthObjects(
        @Nullable Long size,
        @Nullable Long recentSize,
        @Nullable Long staleSize,
        @Nullable Long keepSize,
        @Nullable Integer packfileCount,
        @Nullable Integer reverseIndexCount,
        @Nullable Integer cruftCount,
        @Nullable Integer keepCount,
        @Nullable Integer looseObjectsCount,
        @Nullable Integer staleLooseObjectsCount,
        @Nullable Integer looseObjectsGarbageCount) {}
