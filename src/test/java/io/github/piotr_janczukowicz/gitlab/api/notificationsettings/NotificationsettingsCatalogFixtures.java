package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

public final class NotificationsettingsCatalogFixtures {

    private NotificationsettingsCatalogFixtures() {}

    public static GitLabGlobalNotificationSetting globalNotificationSetting() {
        return GitLabGlobalNotificationSettingBuilder.builder()
                .level("level")
                .events("events")
                .notificationEmail("notification_email")
                .build();
    }

    public static GitLabGroupNotificationSettingsUpdatePayload groupNotificationSettingsUpdatePayload() {
        return GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder()
                .level("level")
                .newRelease(true)
                .newNote(true)
                .newIssue(true)
                .reopenIssue(true)
                .closeIssue(true)
                .reassignIssue(true)
                .issueDue(true)
                .newMergeRequest(true)
                .pushToMergeRequest(true)
                .reopenMergeRequest(true)
                .closeMergeRequest(true)
                .reassignMergeRequest(true)
                .changeReviewerMergeRequest(true)
                .mergeMergeRequest(true)
                .failedPipeline(true)
                .fixedPipeline(true)
                .successPipeline(true)
                .movedProject(true)
                .mergeWhenPipelineSucceeds(true)
                .newEpic(true)
                .serviceAccountFailedPipeline(true)
                .serviceAccountSuccessPipeline(true)
                .serviceAccountFixedPipeline(true)
                .build();
    }

    public static GitLabInstanceNotificationSettingsUpdatePayload instanceNotificationSettingsUpdatePayload() {
        return GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder()
                .level("level")
                .notificationEmail("notification_email")
                .newRelease(true)
                .newNote(true)
                .newIssue(true)
                .reopenIssue(true)
                .closeIssue(true)
                .reassignIssue(true)
                .issueDue(true)
                .newMergeRequest(true)
                .pushToMergeRequest(true)
                .reopenMergeRequest(true)
                .closeMergeRequest(true)
                .reassignMergeRequest(true)
                .changeReviewerMergeRequest(true)
                .mergeMergeRequest(true)
                .failedPipeline(true)
                .fixedPipeline(true)
                .successPipeline(true)
                .movedProject(true)
                .mergeWhenPipelineSucceeds(true)
                .newEpic(true)
                .serviceAccountFailedPipeline(true)
                .serviceAccountSuccessPipeline(true)
                .serviceAccountFixedPipeline(true)
                .approver(true)
                .build();
    }

    public static GitLabNotificationSetting notificationSetting() {
        return GitLabNotificationSettingBuilder.builder()
                .level("level")
                .events("events")
                .build();
    }

    public static GitLabProjectNotificationSettingsUpdatePayload projectNotificationSettingsUpdatePayload() {
        return GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder()
                .level("level")
                .newRelease(true)
                .newNote(true)
                .newIssue(true)
                .reopenIssue(true)
                .closeIssue(true)
                .reassignIssue(true)
                .issueDue(true)
                .newMergeRequest(true)
                .pushToMergeRequest(true)
                .reopenMergeRequest(true)
                .closeMergeRequest(true)
                .reassignMergeRequest(true)
                .changeReviewerMergeRequest(true)
                .mergeMergeRequest(true)
                .failedPipeline(true)
                .fixedPipeline(true)
                .successPipeline(true)
                .movedProject(true)
                .mergeWhenPipelineSucceeds(true)
                .approver(true)
                .serviceAccountFailedPipeline(true)
                .serviceAccountSuccessPipeline(true)
                .serviceAccountFixedPipeline(true)
                .build();
    }
}
