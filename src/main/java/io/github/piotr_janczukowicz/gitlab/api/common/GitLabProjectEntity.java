package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project entity.
 *
 * @param id the id
 * @param name the name
 * @param fullPath the full path
 * @param fullName the full name
 * @param refsUrl the refs url
 * @param forked the forked
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/ProjectEntity")
public record GitLabProjectEntity(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String fullPath,
        @Nullable String fullName,
        @Nullable String refsUrl,
        @Nullable Boolean forked) {}
