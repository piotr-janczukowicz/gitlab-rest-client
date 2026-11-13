package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge requests status check response.
 *
 * @param id the id
 * @param mergeRequest the merge request
 * @param externalStatusCheck the external status check
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestsStatusCheckResponse")
public record GitLabMergeRequestsStatusCheckResponse(
        @Nullable Long id,
        @Nullable GitLabMergeRequest mergeRequest,
        @Nullable GitLabMergeRequestsStatusCheckResponseExternalStatusCheck externalStatusCheck) {}
