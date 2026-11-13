package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab storage shard entity.
 *
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/StorageShardEntity")
public record GitLabStorageShardEntity(@Nullable String name) {}
