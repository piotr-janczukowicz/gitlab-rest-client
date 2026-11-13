package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdMergeRequestsMergeRequestIidMerge}.
 *
 * @param mergeCommitMessage the merge commit message
 * @param squashCommitMessage the squash commit message
 * @param shouldRemoveSourceBranch the should remove source branch
 * @param mergeWhenPipelineSucceeds the merge when pipeline succeeds
 * @param autoMerge the auto merge
 * @param sha the sha
 * @param squash the squash
 * @param skipMergeTrain the skip merge train
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdMergeRequestsMergeRequestIidMerge/requestBody")
public record GitLabProjectMergeRequestsMergePayload(
        @Nullable String mergeCommitMessage,
        @Nullable String squashCommitMessage,
        @Nullable Boolean shouldRemoveSourceBranch,
        @Nullable Boolean mergeWhenPipelineSucceeds,
        @Nullable Boolean autoMerge,
        @Nullable String sha,
        @Nullable Boolean squash,
        @Nullable Boolean skipMergeTrain) {}
