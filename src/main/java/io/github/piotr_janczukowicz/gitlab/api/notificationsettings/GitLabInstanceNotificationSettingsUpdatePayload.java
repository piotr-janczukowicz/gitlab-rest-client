package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4NotificationSettings}.
 *
 * @param level the level
 * @param notificationEmail the notification email
 * @param newRelease the new release
 * @param newNote the new note
 * @param newIssue the new issue
 * @param reopenIssue the reopen issue
 * @param closeIssue the close issue
 * @param reassignIssue the reassign issue
 * @param issueDue the issue due
 * @param newMergeRequest the new merge request
 * @param pushToMergeRequest the push to merge request
 * @param reopenMergeRequest the reopen merge request
 * @param closeMergeRequest the close merge request
 * @param reassignMergeRequest the reassign merge request
 * @param changeReviewerMergeRequest the change reviewer merge request
 * @param mergeMergeRequest the merge merge request
 * @param failedPipeline the failed pipeline
 * @param fixedPipeline the fixed pipeline
 * @param successPipeline the success pipeline
 * @param movedProject the moved project
 * @param mergeWhenPipelineSucceeds the merge when pipeline succeeds
 * @param newEpic the new epic
 * @param serviceAccountFailedPipeline the service account failed pipeline
 * @param serviceAccountSuccessPipeline the service account success pipeline
 * @param serviceAccountFixedPipeline the service account fixed pipeline
 * @param approver the approver
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4NotificationSettings/requestBody")
public record GitLabInstanceNotificationSettingsUpdatePayload(
        @Nullable String level,
        @Nullable String notificationEmail,
        @Nullable Boolean newRelease,
        @Nullable Boolean newNote,
        @Nullable Boolean newIssue,
        @Nullable Boolean reopenIssue,
        @Nullable Boolean closeIssue,
        @Nullable Boolean reassignIssue,
        @Nullable Boolean issueDue,
        @Nullable Boolean newMergeRequest,
        @Nullable Boolean pushToMergeRequest,
        @Nullable Boolean reopenMergeRequest,
        @Nullable Boolean closeMergeRequest,
        @Nullable Boolean reassignMergeRequest,
        @Nullable Boolean changeReviewerMergeRequest,
        @Nullable Boolean mergeMergeRequest,
        @Nullable Boolean failedPipeline,
        @Nullable Boolean fixedPipeline,
        @Nullable Boolean successPipeline,
        @Nullable Boolean movedProject,
        @Nullable Boolean mergeWhenPipelineSucceeds,
        @Nullable Boolean newEpic,
        @Nullable Boolean serviceAccountFailedPipeline,
        @Nullable Boolean serviceAccountSuccessPipeline,
        @Nullable Boolean serviceAccountFixedPipeline,
        @Nullable Boolean approver) {}
