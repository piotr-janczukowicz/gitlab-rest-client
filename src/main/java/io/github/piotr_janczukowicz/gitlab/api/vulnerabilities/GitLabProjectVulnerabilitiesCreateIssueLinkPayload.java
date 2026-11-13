package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4VulnerabilitiesIdIssueLinks}.
 *
 * @param targetIssueIid the target issue iid
 * @param targetProjectId the target project id
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4VulnerabilitiesIdIssueLinks/requestBody")
public record GitLabProjectVulnerabilitiesCreateIssueLinkPayload(
        @Nullable Long targetIssueIid,
        @Nullable String targetProjectId,
        @Nullable String linkType) {}
