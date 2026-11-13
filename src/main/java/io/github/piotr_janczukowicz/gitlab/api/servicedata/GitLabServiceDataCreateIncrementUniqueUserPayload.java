package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsageDataIncrementUniqueUsers}.
 *
 * @param event the event
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsageDataIncrementUniqueUsers/requestBody")
public record GitLabServiceDataCreateIncrementUniqueUserPayload(
        @Nullable String event) {}
