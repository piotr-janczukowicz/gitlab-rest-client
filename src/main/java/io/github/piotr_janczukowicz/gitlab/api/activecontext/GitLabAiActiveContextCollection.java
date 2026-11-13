package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai active context collection.
 *
 * @param id the id
 * @param name the name
 * @param connectionId the connection id
 * @param options the options
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiActiveContextCollection")
public record GitLabAiActiveContextCollection(
        @Nullable Long id,
        @Nullable String name,
        @Nullable Long connectionId,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> options,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (updated_at)")
        Instant updatedAt) {}
