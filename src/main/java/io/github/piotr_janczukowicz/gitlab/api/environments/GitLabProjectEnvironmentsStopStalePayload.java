package io.github.piotr_janczukowicz.gitlab.api.environments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdEnvironmentsStopStale}.
 *
 * @param before the before
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdEnvironmentsStopStale/requestBody")
public record GitLabProjectEnvironmentsStopStalePayload(
        @Nullable Instant before) {}
