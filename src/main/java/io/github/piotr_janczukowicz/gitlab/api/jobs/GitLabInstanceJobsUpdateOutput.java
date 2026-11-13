package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance jobs update output of a GitLab resource.
 *
 * @param checksum the checksum
 * @param bytesize the bytesize
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4JobsId/requestBody/properties/output")
public record GitLabInstanceJobsUpdateOutput(
        @Nullable String checksum, @Nullable Integer bytesize) {}
