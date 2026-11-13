package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project identity.
 *
 * @param id the id
 * @param description the description
 * @param name the name
 * @param nameWithNamespace the name with namespace
 * @param path the path
 * @param pathWithNamespace the path with namespace
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectIdentity")
public record GitLabProjectIdentity(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String name,
        @Nullable String nameWithNamespace,
        @Nullable String path,
        @Nullable String pathWithNamespace,
        @Nullable Instant createdAt) {}
