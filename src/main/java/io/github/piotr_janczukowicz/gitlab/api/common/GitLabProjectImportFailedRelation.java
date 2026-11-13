package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project import failed relation.
 *
 * @param id the id
 * @param createdAt the created at
 * @param exceptionClass the exception class
 * @param source the source
 * @param exceptionMessage the exception message
 * @param relationName the relation name
 * @param lineNumber the line number
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectImportFailedRelation")
public record GitLabProjectImportFailedRelation(
        @Nullable Long id,
        @Nullable Instant createdAt,
        @Nullable String exceptionClass,
        @Nullable String source,
        @Nullable String exceptionMessage,
        @Nullable String relationName,
        @Nullable Integer lineNumber) {}
