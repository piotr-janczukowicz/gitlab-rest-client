package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health bitmap.
 *
 * @param hasHashCache the has hash cache
 * @param hasLookupTable the has lookup table
 * @param version the version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthBitmap")
public record GitLabRepositoryHealthBitmap(
        @Nullable Boolean hasHashCache,
        @Nullable Boolean hasLookupTable,
        @Nullable Integer version) {}
