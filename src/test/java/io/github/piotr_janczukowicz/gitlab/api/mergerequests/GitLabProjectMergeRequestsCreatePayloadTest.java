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
class GitLabProjectMergeRequestsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .title(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .sourceBranch(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .targetBranch(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .targetProjectId(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .assigneeId(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdsIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .assigneeIds(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.assigneeIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerIdsIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .reviewerIds(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.reviewerIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .description(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .labels(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddLabelsIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .addLabels(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.addLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveLabelsIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .removeLabels(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.removeLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .milestoneId(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .milestone(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMilestoneIsTooLong() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .milestone("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMilestoneHasTheMaximumLength() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .milestone("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .removeSourceBranch(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.removeSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCollaborationIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .allowCollaboration(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.allowCollaboration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMaintainerToPushIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .allowMaintainerToPush(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.allowMaintainerToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .squash(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAfterIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .mergeAfter(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.mergeAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectMergeRequestsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                        .approvalsBeforeMerge(null);

        final GitLabProjectMergeRequestsCreatePayload built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsCreatePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.targetProjectId()).isEqualTo(1L);
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
        final GitLabProjectMergeRequestsCreatePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();

        final GitLabProjectMergeRequestsCreatePayload rebuilt =
                GitLabProjectMergeRequestsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestsCreatePayload built = GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                .assigneeIds(source)
                .build();
        source.clear();

        assertThat(built.assigneeIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeIdsIsRead() {
        final GitLabProjectMergeRequestsCreatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();
        final List<Long> values = built.assigneeIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenReviewerIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestsCreatePayload built = GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                .reviewerIds(source)
                .build();
        source.clear();

        assertThat(built.reviewerIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenReviewerIdsIsRead() {
        final GitLabProjectMergeRequestsCreatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();
        final List<Long> values = built.reviewerIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectMergeRequestsCreatePayload built = GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectMergeRequestsCreatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAddLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("add_labels"));
        final GitLabProjectMergeRequestsCreatePayload built = GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                .addLabels(source)
                .build();
        source.clear();

        assertThat(built.addLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAddLabelsIsRead() {
        final GitLabProjectMergeRequestsCreatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();
        final List<String> values = built.addLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenRemoveLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("remove_labels"));
        final GitLabProjectMergeRequestsCreatePayload built = GitLabProjectMergeRequestsCreatePayloadBuilder.builder(
                        MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload())
                .removeLabels(source)
                .build();
        source.clear();

        assertThat(built.removeLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRemoveLabelsIsRead() {
        final GitLabProjectMergeRequestsCreatePayload built =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePayload();
        final List<String> values = built.removeLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "sourceBranch",
                        "targetBranch",
                        "targetProjectId",
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
