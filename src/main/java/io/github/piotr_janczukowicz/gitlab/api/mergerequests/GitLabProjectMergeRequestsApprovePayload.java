package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidApprove}.
 *
 * @param sha the sha
 * @param publishReview the publish review
 * @param approvalPassword the approval password
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidApprove/requestBody")
public record GitLabProjectMergeRequestsApprovePayload(
        @Nullable String sha,
        @Nullable Boolean publishReview,
        @Nullable String approvalPassword) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code approvalPassword} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectMergeRequestsApprovePayload[" + "sha=" + sha + ", publishReview=" + publishReview
                + ", approvalPassword=<redacted>" + "]";
    }
}
