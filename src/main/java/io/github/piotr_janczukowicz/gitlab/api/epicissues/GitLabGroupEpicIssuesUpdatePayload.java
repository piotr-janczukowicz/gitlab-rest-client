package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdDashEpicsEpicIidIssuesEpicIssueId}.
 *
 * @param moveBeforeId the move before id
 * @param moveAfterId the move after id
 * @param page the page
 * @param perPage the per page
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdDashEpicsEpicIidIssuesEpicIssueId/requestBody")
public record GitLabGroupEpicIssuesUpdatePayload(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String moveBeforeId,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String moveAfterId,

        @Nullable Integer page,
        @Nullable Integer perPage) {}
