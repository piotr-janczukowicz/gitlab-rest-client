package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidBlocks}.
 *
 * @param blockingMergeRequestId the blocking merge request id
 * @param blockingMergeRequestIid the blocking merge request iid
 * @param blockingProjectId the blocking project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidBlocks/requestBody")
public record GitLabProjectMergeRequestsCreateBlockPayload(
        @Nullable Long blockingMergeRequestId,
        @Nullable Long blockingMergeRequestIid,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String blockingProjectId) {}
