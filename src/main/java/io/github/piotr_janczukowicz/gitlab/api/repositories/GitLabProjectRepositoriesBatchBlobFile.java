package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project repositories batch blob file of a GitLab resource.
 *
 * @param path the path
 * @param ref the ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryBlobsBatch/requestBody/properties/files/items")
public record GitLabProjectRepositoriesBatchBlobFile(
        @Nullable String path, @Nullable String ref) {}
