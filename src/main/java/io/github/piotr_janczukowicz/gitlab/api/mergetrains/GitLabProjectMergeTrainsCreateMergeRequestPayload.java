package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeTrainsMergeRequestsMergeRequestIid}.
 *
 * @param sha the sha
 * @param squash the squash
 * @param whenPipelineSucceeds the when pipeline succeeds
 * @param autoMerge the auto merge
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeTrainsMergeRequestsMergeRequestIid/requestBody")
public record GitLabProjectMergeTrainsCreateMergeRequestPayload(
        @Nullable String sha,
        @Nullable Boolean squash,
        @Nullable Boolean whenPipelineSucceeds,
        @Nullable Boolean autoMerge) {}
