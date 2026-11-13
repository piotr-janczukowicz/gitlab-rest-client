package io.github.piotr_janczukowicz.gitlab.api.issues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdIssuesIssueIidClone}.
 *
 * @param toProjectId the to project id
 * @param withNotes the with notes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdIssuesIssueIidClone/requestBody")
public record GitLabProjectIssuesDoClonePayload(
        @Nullable Long toProjectId, @Nullable Boolean withNotes) {}
