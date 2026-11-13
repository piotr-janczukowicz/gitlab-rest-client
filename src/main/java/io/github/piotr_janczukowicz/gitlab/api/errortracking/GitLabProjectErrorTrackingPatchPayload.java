package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdErrorTrackingSettings}.
 *
 * @param active the active
 * @param integrated the integrated
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdErrorTrackingSettings/requestBody")
public record GitLabProjectErrorTrackingPatchPayload(
        @Nullable Boolean active, @Nullable Boolean integrated) {}
