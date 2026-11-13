package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab changed path.
 *
 * @param status the status
 * @param path the path
 * @param oldPath the old path
 * @param oldMode the old mode
 * @param newMode the new mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesChangedPath")
public record GitLabChangedPath(
        @Nullable String status,
        @Nullable String path,
        @Nullable String oldPath,
        @Nullable String oldMode,
        @Nullable String newMode) {}
