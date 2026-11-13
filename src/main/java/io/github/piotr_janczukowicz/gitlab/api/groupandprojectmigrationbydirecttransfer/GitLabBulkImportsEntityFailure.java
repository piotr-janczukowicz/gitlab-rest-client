package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab bulk imports entity failure.
 *
 * @param relation the relation
 * @param exceptionMessage the exception message
 * @param exceptionClass the exception class
 * @param correlationIdValue the correlation id value
 * @param sourceUrl the source url
 * @param sourceTitle the source title
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBulkImportsEntityFailure")
public record GitLabBulkImportsEntityFailure(
        @Nullable String relation,
        @Nullable String exceptionMessage,
        @Nullable String exceptionClass,
        @Nullable String correlationIdValue,
        @Nullable String sourceUrl,
        @Nullable String sourceTitle) {}
