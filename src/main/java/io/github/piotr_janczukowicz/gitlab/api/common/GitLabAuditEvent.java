package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab audit event.
 *
 * @param id the id
 * @param authorId the author id
 * @param entityId the entity id
 * @param entityType the entity type
 * @param eventName the event name
 * @param details the details
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAuditEvent")
public record GitLabAuditEvent(
        @Nullable Long id,
        @Nullable Long authorId,
        @Nullable Long entityId,
        @Nullable String entityType,
        @Nullable String eventName,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> details,

        @Nullable Instant createdAt) {}
