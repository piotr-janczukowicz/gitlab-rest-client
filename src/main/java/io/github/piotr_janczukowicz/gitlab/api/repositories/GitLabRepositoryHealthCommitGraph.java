package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health commit graph.
 *
 * @param commitGraphChainLength the commit graph chain length
 * @param hasBloomFilters the has bloom filters
 * @param hasGenerationData the has generation data
 * @param hasGenerationDataOverflow the has generation data overflow
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthCommitGraph")
public record GitLabRepositoryHealthCommitGraph(
        @Nullable Integer commitGraphChainLength,
        @Nullable Boolean hasBloomFilters,
        @Nullable Boolean hasGenerationData,
        @Nullable Boolean hasGenerationDataOverflow) {}
