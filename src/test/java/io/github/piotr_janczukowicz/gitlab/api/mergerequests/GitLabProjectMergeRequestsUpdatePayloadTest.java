package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .title(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .targetBranch(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateEventIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .stateEvent(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.stateEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .discussionLocked(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .assigneeId(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdsIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .assigneeIds(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.assigneeIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerIdsIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .reviewerIds(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.reviewerIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .description(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .labels(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddLabelsIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .addLabels(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.addLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveLabelsIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .removeLabels(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.removeLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .milestoneId(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .milestone(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMilestoneIsTooLong() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .milestone("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMilestoneHasTheMaximumLength() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .milestone("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .removeSourceBranch(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.removeSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCollaborationIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .allowCollaboration(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.allowCollaboration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMaintainerToPushIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .allowMaintainerToPush(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.allowMaintainerToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .squash(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAfterIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .mergeAfter(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.mergeAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectMergeRequestsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                        .approvalsBeforeMerge(null);

        final GitLabProjectMergeRequestsUpdatePayload built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsUpdatePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.stateEvent()).isEqualTo(GitLabProjectMergeRequestsUpdateStateEvent.CLOSE);
            softly.assertThat(value.discussionLocked()).isEqualTo(true);
            softly.assertThat(value.assigneeId()).isEqualTo(1L);
            softly.assertThat(value.assigneeIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.reviewerIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.addLabels()).isEqualTo(List.of("add_labels"));
            softly.assertThat(value.removeLabels()).isEqualTo(List.of("remove_labels"));
            softly.assertThat(value.milestoneId()).isEqualTo(1L);
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.removeSourceBranch()).isEqualTo(true);
            softly.assertThat(value.allowCollaboration()).isEqualTo(true);
            softly.assertThat(value.allowMaintainerToPush()).isEqualTo(true);
            softly.assertThat(value.squash()).isEqualTo(true);
            softly.assertThat(value.mergeAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsUpdatePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();

        final GitLabProjectMergeRequestsUpdatePayload rebuilt =
                GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestsUpdatePayload built = GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                .assigneeIds(source)
                .build();
        source.clear();

        assertThat(built.assigneeIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeIdsIsRead() {
        final GitLabProjectMergeRequestsUpdatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();
        final List<Long> values = built.assigneeIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenReviewerIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestsUpdatePayload built = GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                .reviewerIds(source)
                .build();
        source.clear();

        assertThat(built.reviewerIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenReviewerIdsIsRead() {
        final GitLabProjectMergeRequestsUpdatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();
        final List<Long> values = built.reviewerIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectMergeRequestsUpdatePayload built = GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectMergeRequestsUpdatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAddLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("add_labels"));
        final GitLabProjectMergeRequestsUpdatePayload built = GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                .addLabels(source)
                .build();
        source.clear();

        assertThat(built.addLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAddLabelsIsRead() {
        final GitLabProjectMergeRequestsUpdatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();
        final List<String> values = built.addLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenRemoveLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("remove_labels"));
        final GitLabProjectMergeRequestsUpdatePayload built = GitLabProjectMergeRequestsUpdatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload())
                .removeLabels(source)
                .build();
        source.clear();

        assertThat(built.removeLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRemoveLabelsIsRead() {
        final GitLabProjectMergeRequestsUpdatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsUpdatePayload();
        final List<String> values = built.removeLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "targetBranch",
                        "stateEvent",
                        "discussionLocked",
                        "assigneeId",
                        "assigneeIds",
                        "reviewerIds",
                        "description",
                        "labels",
                        "addLabels",
                        "removeLabels",
                        "milestoneId",
                        "milestone",
                        "removeSourceBranch",
                        "allowCollaboration",
                        "allowMaintainerToPush",
                        "squash",
                        "mergeAfter",
                        "approvalsBeforeMerge");
    }
}
