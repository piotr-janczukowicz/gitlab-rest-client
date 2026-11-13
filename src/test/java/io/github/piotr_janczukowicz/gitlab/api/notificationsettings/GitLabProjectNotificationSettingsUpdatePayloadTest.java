package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotificationSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLevelIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .level(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.level()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewReleaseIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .newRelease(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newRelease()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNoteIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .newNote(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .newIssue(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenIssueIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .reopenIssue(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseIssueIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .closeIssue(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignIssueIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .reassignIssue(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueDueIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .issueDue(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.issueDue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .newMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushToMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .pushToMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.pushToMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .reopenMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .closeMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .reassignMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangeReviewerMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .changeReviewerMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.changeReviewerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMergeRequestIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .mergeMergeRequest(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .failedPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.failedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFixedPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .fixedPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.fixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .successPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.successPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedProjectIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .movedProject(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.movedProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .mergeWhenPipelineSucceeds(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .approver(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.approver()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFailedPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .serviceAccountFailedPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFailedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountSuccessPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .serviceAccountSuccessPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountSuccessPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFixedPipelineIsNullable() {
        final GitLabProjectNotificationSettingsUpdatePayloadBuilder builder =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload())
                        .serviceAccountFixedPipeline(null);

        final GitLabProjectNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotificationSettingsUpdatePayload value =
                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.level()).isEqualTo("level");
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
            softly.assertThat(value.approver()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFailedPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountSuccessPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFixedPipeline()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotificationSettingsUpdatePayload original =
                NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload();

        final GitLabProjectNotificationSettingsUpdatePayload rebuilt =
                GitLabProjectNotificationSettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotificationSettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "level",
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
                        "approver",
                        "serviceAccountFailedPipeline",
                        "serviceAccountSuccessPipeline",
                        "serviceAccountFixedPipeline");
    }
}
