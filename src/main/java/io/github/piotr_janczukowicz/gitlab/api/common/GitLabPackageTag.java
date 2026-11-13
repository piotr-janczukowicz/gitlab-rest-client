package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * The git lab package tag of a GitLab resource.
 *
 * @param id the id
 * @param packageId the package id
 * @param name the name
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param projectId the project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackage/properties/tags/items")
public record GitLabPackageTag(
        @Nullable Long id,
        @Nullable Long packageId,
        @Nullable String name,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Long projectId) {}
