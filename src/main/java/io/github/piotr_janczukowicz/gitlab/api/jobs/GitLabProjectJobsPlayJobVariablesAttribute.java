package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project jobs play job variables attribute of a GitLab resource.
 *
 * @param key the key
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdJobsJobIdPlay/requestBody/properties/job_variables_attributes/items")
public record GitLabProjectJobsPlayJobVariablesAttribute(
        @Nullable String key, @Nullable String value) {}
