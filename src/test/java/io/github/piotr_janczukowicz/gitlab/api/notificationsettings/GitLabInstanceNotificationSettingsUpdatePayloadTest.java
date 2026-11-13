package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceNotificationSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLevelIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .level(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.level()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationEmailIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .notificationEmail(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.notificationEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewReleaseIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .newRelease(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newRelease()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNoteIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .newNote(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .newIssue(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenIssueIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .reopenIssue(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseIssueIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .closeIssue(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignIssueIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .reassignIssue(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueDueIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .issueDue(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.issueDue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .newMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushToMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .pushToMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.pushToMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .reopenMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .closeMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .reassignMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangeReviewerMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .changeReviewerMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.changeReviewerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMergeRequestIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .mergeMergeRequest(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .failedPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.failedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFixedPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .fixedPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.fixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .successPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.successPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedProjectIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .movedProject(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.movedProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .mergeWhenPipelineSucceeds(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewEpicIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .newEpic(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newEpic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFailedPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .serviceAccountFailedPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFailedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountSuccessPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .serviceAccountSuccessPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountSuccessPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFixedPipelineIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .serviceAccountFixedPipeline(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverIsNullable() {
        final GitLabInstanceNotificationSettingsUpdatePayloadBuilder builder =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload())
                        .approver(null);

        final GitLabInstanceNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.approver()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceNotificationSettingsUpdatePayload value =
                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.level()).isEqualTo("level");
            softly.assertThat(value.notificationEmail()).isEqualTo("notification_email");
            softly.assertThat(value.newRelease()).isEqualTo(true);
            softly.assertThat(value.newNote()).isEqualTo(true);
            softly.assertThat(value.newIssue()).isEqualTo(true);
            softly.assertThat(value.reopenIssue()).isEqualTo(true);
            softly.assertThat(value.closeIssue()).isEqualTo(true);
            softly.assertThat(value.reassignIssue()).isEqualTo(true);
            softly.assertThat(value.issueDue()).isEqualTo(true);
            softly.assertThat(value.newMergeRequest()).isEqualTo(true);
            softly.assertThat(value.pushToMergeRequest()).isEqualTo(true);
            softly.assertThat(value.reopenMergeRequest()).isEqualTo(true);
            softly.assertThat(value.closeMergeRequest()).isEqualTo(true);
            softly.assertThat(value.reassignMergeRequest()).isEqualTo(true);
            softly.assertThat(value.changeReviewerMergeRequest()).isEqualTo(true);
            softly.assertThat(value.mergeMergeRequest()).isEqualTo(true);
            softly.assertThat(value.failedPipeline()).isEqualTo(true);
            softly.assertThat(value.fixedPipeline()).isEqualTo(true);
            softly.assertThat(value.successPipeline()).isEqualTo(true);
            softly.assertThat(value.movedProject()).isEqualTo(true);
            softly.assertThat(value.mergeWhenPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.newEpic()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFailedPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountSuccessPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFixedPipeline()).isEqualTo(true);
            softly.assertThat(value.approver()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceNotificationSettingsUpdatePayload original =
                NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload();

        final GitLabInstanceNotificationSettingsUpdatePayload rebuilt =
                GitLabInstanceNotificationSettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceNotificationSettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "level",
                        "notificationEmail",
                        "newRelease",
                        "newNote",
                        "newIssue",
                        "reopenIssue",
                        "closeIssue",
                        "reassignIssue",
                        "issueDue",
                        "newMergeRequest",
                        "pushToMergeRequest",
                        "reopenMergeRequest",
                        "closeMergeRequest",
                        "reassignMergeRequest",
                        "changeReviewerMergeRequest",
                        "mergeMergeRequest",
                        "failedPipeline",
                        "fixedPipeline",
                        "successPipeline",
                        "movedProject",
                        "mergeWhenPipelineSucceeds",
                        "newEpic",
                        "serviceAccountFailedPipeline",
                        "serviceAccountSuccessPipeline",
                        "serviceAccountFixedPipeline",
                        "approver");
    }
}
