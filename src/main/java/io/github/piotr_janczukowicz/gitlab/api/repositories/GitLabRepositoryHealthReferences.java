package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health references.
 *
 * @param looseCount the loose count
 * @param packedSize the packed size
 * @param referenceBackend the reference backend
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthReferences")
public record GitLabRepositoryHealthReferences(
        @Nullable Integer looseCount,
        @Nullable Long packedSize,
        @Nullable String referenceBackend) {}
