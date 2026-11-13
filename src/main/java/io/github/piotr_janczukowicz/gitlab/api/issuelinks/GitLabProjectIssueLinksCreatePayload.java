package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdIssuesIssueIidLinks}.
 *
 * @param targetProjectId the target project id
 * @param targetIssueIid the target issue iid
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdIssuesIssueIidLinks/requestBody")
public record GitLabProjectIssueLinksCreatePayload(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String targetProjectId,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String targetIssueIid,

        @Nullable GitLabProjectIssueLinksCreateLinkType linkType) {}
