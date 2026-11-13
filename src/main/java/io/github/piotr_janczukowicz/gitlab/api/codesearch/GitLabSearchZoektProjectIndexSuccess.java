package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab search zoekt project index success.
 *
 * @param jobId the job id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSearchZoektProjectIndexSuccess")
public record GitLabSearchZoektProjectIndexSuccess(@Nullable String jobId) {}
