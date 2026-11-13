package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user counts.
 *
 * @param mergeRequests the merge requests
 * @param assignedIssues the assigned issues
 * @param assignedMergeRequests the assigned merge requests
 * @param reviewRequestedMergeRequests the review requested merge requests
 * @param todos the todos
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserCounts")
public record GitLabUserCounts(
        @Nullable Integer mergeRequests,
        @Nullable Integer assignedIssues,
        @Nullable Integer assignedMergeRequests,
        @Nullable Integer reviewRequestedMergeRequests,
        @Nullable Integer todos) {}
