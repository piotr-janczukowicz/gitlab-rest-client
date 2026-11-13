package io.github.piotr_janczukowicz.gitlab.api.issues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIssuesIssueIidReorder}.
 *
 * @param moveAfterId the move after id
 * @param moveBeforeId the move before id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIssuesIssueIidReorder/requestBody")
public record GitLabProjectIssuesReorderPayload(
        @Nullable Long moveAfterId, @Nullable Long moveBeforeId) {}
