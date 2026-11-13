package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab environment basic.
 *
 * @param id the id
 * @param name the name
 * @param slug the slug
 * @param externalUrl the external url
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEnvironmentBasic")
public record GitLabEnvironmentBasic(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String slug,
        @Nullable String externalUrl,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
