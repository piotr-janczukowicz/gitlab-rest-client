package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIssuesIssueIid}.
 *
 * @param title the title
 * @param updatedAt the updated at
 * @param stateEvent the state event
 * @param description the description
 * @param assigneeIds the assignee ids
 * @param assigneeId the assignee id
 * @param milestoneId the milestone id
 * @param milestone the milestone
 * @param labels the labels
 * @param addLabels the add labels
 * @param removeLabels the remove labels
 * @param dueDate the due date
 * @param startDate the start date
 * @param confidential the confidential
 * @param discussionLocked the discussion locked
 * @param issueType the issue type
 * @param severity the severity
 * @param weight the weight
 * @param epicId the epic id
 * @param epicIid the epic iid
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIssuesIssueIid/requestBody")
public record GitLabProjectIssuesUpdatePayload(
        @Nullable String title,
        @Nullable Instant updatedAt,
        @Nullable GitLabProjectIssuesUpdateStateEvent stateEvent,
        @Nullable String description,
        @Nullable List<Long> assigneeIds,
        @Nullable Long assigneeId,
        @Nullable Long milestoneId,
        @Nullable String milestone,
        @Nullable List<String> labels,
        @Nullable List<String> addLabels,
        @Nullable List<String> removeLabels,
        @Nullable String dueDate,
        @Nullable String startDate,
        @Nullable Boolean confidential,
        @Nullable Boolean discussionLocked,
        @Nullable GitLabProjectIssuesUpdateIssueType issueType,
        @Nullable GitLabProjectIssuesUpdateSeverity severity,
        @Nullable Integer weight,
        @Nullable Long epicId,
        @Nullable Long epicIid,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt) {
    public GitLabProjectIssuesUpdatePayload {
        if (assigneeIds != null) {
            assigneeIds = List.copyOf(assigneeIds);
        }
        requireMaxLengthIfPresent(milestone, 255, "milestone");
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (addLabels != null) {
            addLabels = List.copyOf(addLabels);
        }
        if (removeLabels != null) {
            removeLabels = List.copyOf(removeLabels);
        }
    }
}
