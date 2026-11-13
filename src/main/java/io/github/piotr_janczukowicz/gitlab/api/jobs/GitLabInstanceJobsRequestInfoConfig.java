package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance jobs request info config of a GitLab resource.
 *
 * @param gpus the gpus
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsRequest/requestBody/properties/info/properties/config")
public record GitLabInstanceJobsRequestInfoConfig(@Nullable String gpus) {}
