package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab container registry tag.
 *
 * @param name the name
 * @param path the path
 * @param location the location
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesContainerRegistryTag")
public record GitLabContainerRegistryTag(
        @Nullable String name,
        @Nullable String path,
        @Nullable String location) {}
