package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotificationSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLevelIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .level(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.level()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewReleaseIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .newRelease(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newRelease()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNoteIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .newNote(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .newIssue(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenIssueIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .reopenIssue(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseIssueIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .closeIssue(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignIssueIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .reassignIssue(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueDueIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .issueDue(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.issueDue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .newMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushToMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .pushToMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.pushToMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReopenMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .reopenMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reopenMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloseMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .closeMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.closeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReassignMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .reassignMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.reassignMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangeReviewerMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .changeReviewerMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.changeReviewerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMergeRequestIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .mergeMergeRequest(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .failedPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.failedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFixedPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .fixedPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.fixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .successPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.successPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedProjectIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .movedProject(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.movedProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .mergeWhenPipelineSucceeds(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewEpicIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .newEpic(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.newEpic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFailedPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .serviceAccountFailedPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFailedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountSuccessPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .serviceAccountSuccessPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountSuccessPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountFixedPipelineIsNullable() {
        final GitLabGroupNotificationSettingsUpdatePayloadBuilder builder =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(
                                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload())
                        .serviceAccountFixedPipeline(null);

        final GitLabGroupNotificationSettingsUpdatePayload built = builder.build();

        assertThat(built.serviceAccountFixedPipeline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotificationSettingsUpdatePayload value =
                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload();

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
            softly.assertThat(value.newEpic()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFailedPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountSuccessPipeline()).isEqualTo(true);
            softly.assertThat(value.serviceAccountFixedPipeline()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotificationSettingsUpdatePayload original =
                NotificationsettingsCatalogFixtures.groupNotificationSettingsUpdatePayload();

        final GitLabGroupNotificationSettingsUpdatePayload rebuilt =
                GitLabGroupNotificationSettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotificationSettingsUpdatePayload.class.getRecordComponents())
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
                        "newEpic",
                        "serviceAccountFailedPipeline",
                        "serviceAccountSuccessPipeline",
                        "serviceAccountFixedPipeline");
    }
}
