package io.github.piotr_janczukowicz.gitlab.api.issues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdIssuesIssueIidMove}.
 *
 * @param toProjectId the to project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdIssuesIssueIidMove/requestBody")
public record GitLabProjectIssuesMovePayload(@Nullable Long toProjectId) {}
