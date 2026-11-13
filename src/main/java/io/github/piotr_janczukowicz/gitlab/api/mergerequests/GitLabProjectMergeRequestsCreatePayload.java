package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequests}.
 *
 * @param title the title
 * @param sourceBranch the source branch
 * @param targetBranch the target branch
 * @param targetProjectId the target project id
 * @param assigneeId the assignee id
 * @param assigneeIds the assignee ids
 * @param reviewerIds the reviewer ids
 * @param description the description
 * @param labels the labels
 * @param addLabels the add labels
 * @param removeLabels the remove labels
 * @param milestoneId the milestone id
 * @param milestone the milestone
 * @param removeSourceBranch the remove source branch
 * @param allowCollaboration the allow collaboration
 * @param allowMaintainerToPush the allow maintainer to push
 * @param squash the squash
 * @param mergeAfter the merge after
 * @param approvalsBeforeMerge the approvals before merge
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequests/requestBody")
public record GitLabProjectMergeRequestsCreatePayload(
        @Nullable String title,
        @Nullable String sourceBranch,
        @Nullable String targetBranch,
        @Nullable Long targetProjectId,
        @Nullable Long assigneeId,
        @Nullable List<Long> assigneeIds,
        @Nullable List<Long> reviewerIds,
        @Nullable String description,
        @Nullable List<String> labels,
        @Nullable List<String> addLabels,
        @Nullable List<String> removeLabels,
        @Nullable Long milestoneId,
        @Nullable String milestone,
        @Nullable Boolean removeSourceBranch,
        @Nullable Boolean allowCollaboration,
        @Nullable Boolean allowMaintainerToPush,
        @Nullable Boolean squash,
        @Nullable Instant mergeAfter,
        @Nullable Integer approvalsBeforeMerge) {
    public GitLabProjectMergeRequestsCreatePayload {
        if (assigneeIds != null) {
            assigneeIds = List.copyOf(assigneeIds);
        }
        if (reviewerIds != null) {
            reviewerIds = List.copyOf(reviewerIds);
        }
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (addLabels != null) {
            addLabels = List.copyOf(addLabels);
        }
        if (removeLabels != null) {
            removeLabels = List.copyOf(removeLabels);
        }
        requireMaxLengthIfPresent(milestone, 255, "milestone");
    }
}
