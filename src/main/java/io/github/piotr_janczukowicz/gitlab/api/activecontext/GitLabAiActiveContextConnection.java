package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai active context connection.
 *
 * @param id the id
 * @param name the name
 * @param adapterClass the adapter class
 * @param prefix the prefix
 * @param active the active
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiActiveContextConnection")
public record GitLabAiActiveContextConnection(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String adapterClass,
        @Nullable String prefix,
        @Nullable Boolean active,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (updated_at)")
        Instant updatedAt) {}
