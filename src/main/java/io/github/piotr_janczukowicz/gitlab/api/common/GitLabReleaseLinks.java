package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab release links of a GitLab resource.
 *
 * @param closedIssuesUrl the closed issues url
 * @param closedMergeRequestsUrl the closed merge requests url
 * @param editUrl the edit url
 * @param mergedMergeRequestsUrl the merged merge requests url
 * @param openedIssuesUrl the opened issues url
 * @param openedMergeRequestsUrl the opened merge requests url
 * @param self the self
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelease/properties/_links")
public record GitLabReleaseLinks(
        @Nullable String closedIssuesUrl,
        @Nullable String closedMergeRequestsUrl,
        @Nullable String editUrl,
        @Nullable String mergedMergeRequestsUrl,
        @Nullable String openedIssuesUrl,
        @Nullable String openedMergeRequestsUrl,
        @Nullable String self) {}
