package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestChangesTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .id(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .iid(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .projectId(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .title(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .description(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .state(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .createdAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .updatedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedByIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergedBy(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeUser(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .closedBy(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .closedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleHtmlIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .titleHtml(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.titleHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .descriptionHtml(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .targetBranch(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .sourceBranch(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .userNotesCount(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .upvotes(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .downvotes(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .author(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .assignees(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .assignee(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewersIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .reviewers(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.reviewers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .sourceProjectId(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .targetProjectId(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .labels(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .draft(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .imported(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .importedFrom(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInProgressIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .workInProgress(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.workInProgress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .milestone(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeWhenPipelineSucceeds(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeStatusIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeStatus(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedMergeStatusIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .detailedMergeStatus(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.detailedMergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAfterIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeAfter(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .sha(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitShaIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeCommitSha(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitShaIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .squashCommitSha(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.squashCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .discussionLocked(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShouldRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .shouldRemoveSourceBranch(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.shouldRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForceRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .forceRemoveSourceBranch(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.forceRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreparedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .preparedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.preparedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCollaborationIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .allowCollaboration(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.allowCollaboration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMaintainerToPushIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .allowMaintainerToPush(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.allowMaintainerToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .reference(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .references(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .webUrl(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .timeStats(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .squash(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOnMergeIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .squashOnMerge(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.squashOnMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .taskCompletionStatus(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasConflictsIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .hasConflicts(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.hasConflicts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingDiscussionsResolvedIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .blockingDiscussionsResolved(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.blockingDiscussionsResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .approvalsBeforeMerge(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .subscribed(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangesCountIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .changesCount(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.changesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLatestBuildStartedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .latestBuildStartedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.latestBuildStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLatestBuildFinishedAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .latestBuildFinishedAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.latestBuildFinishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstDeployedToProductionAtIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .firstDeployedToProductionAt(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.firstDeployedToProductionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .pipeline(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadPipelineIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .headPipeline(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.headPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffRefsIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .diffRefs(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.diffRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeErrorIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .mergeError(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.mergeError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRebaseInProgressIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .rebaseInProgress(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.rebaseInProgress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDivergedCommitsCountIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .divergedCommitsCount(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.divergedCommitsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstContributionIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .firstContribution(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.firstContribution()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .user(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangesIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .changes(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.changes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverflowIsNullable() {
        final GitLabMergeRequestChangesBuilder builder = GitLabMergeRequestChangesBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChanges())
                .overflow(null);

        final GitLabMergeRequestChanges built = builder.build();

        assertThat(built.overflow()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestChanges value = MergerequestsCatalogFixtures.mergeRequestChanges();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Impedit et ut et dolores vero provident ullam est");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.mergeUser()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.mergedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.closedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.closedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.titleHtml()).isEqualTo("title_html");
            softly.assertThat(value.descriptionHtml()).isEqualTo("description_html");
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.userNotesCount()).isEqualTo(1);
            softly.assertThat(value.upvotes()).isEqualTo(1);
            softly.assertThat(value.downvotes()).isEqualTo(1);
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.mergeRequestAuthor());
            softly.assertThat(value.assignees()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.assignee()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.reviewers()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetProjectId()).isEqualTo(1L);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.draft()).isEqualTo(true);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("bitbucket");
            softly.assertThat(value.workInProgress()).isEqualTo(true);
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.mergeWhenPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.mergeStatus()).isEqualTo("unchecked");
            softly.assertThat(value.detailedMergeStatus()).isEqualTo("mergeable");
            softly.assertThat(value.mergeAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.sha()).isEqualTo("1234abcd");
            softly.assertThat(value.mergeCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.squashCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.discussionLocked()).isEqualTo(true);
            softly.assertThat(value.shouldRemoveSourceBranch()).isEqualTo(true);
            softly.assertThat(value.forceRemoveSourceBranch()).isEqualTo(true);
            softly.assertThat(value.preparedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.allowCollaboration()).isEqualTo(true);
            softly.assertThat(value.allowMaintainerToPush()).isEqualTo(true);
            softly.assertThat(value.reference()).isEqualTo("!1");
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/my-group/my-project/-/merge_requests/1");
            softly.assertThat(value.timeStats()).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(value.squash()).isEqualTo(true);
            softly.assertThat(value.squashOnMerge()).isEqualTo(true);
            softly.assertThat(value.taskCompletionStatus()).isEqualTo(CommonCatalogFixtures.taskCompletionStatus());
            softly.assertThat(value.hasConflicts()).isEqualTo(true);
            softly.assertThat(value.blockingDiscussionsResolved()).isEqualTo(true);
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
            softly.assertThat(value.subscribed()).isEqualTo(true);
            softly.assertThat(value.changesCount()).isEqualTo("1");
            softly.assertThat(value.latestBuildStartedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.latestBuildFinishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.firstDeployedToProductionAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(value.headPipeline()).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(value.diffRefs()).isEqualTo(CommonCatalogFixtures.diffRefs());
            softly.assertThat(value.mergeError()).isEqualTo("Merge error");
            softly.assertThat(value.rebaseInProgress()).isEqualTo(true);
            softly.assertThat(value.divergedCommitsCount()).isEqualTo(1);
            softly.assertThat(value.firstContribution()).isEqualTo(true);
            softly.assertThat(value.user()).isEqualTo(MergerequestsCatalogFixtures.mergeRequestChangesUser());
            softly.assertThat(value.changes()).isEqualTo(List.of(CommonCatalogFixtures.diff()));
            softly.assertThat(value.overflow()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestChanges original = MergerequestsCatalogFixtures.mergeRequestChanges();

        final GitLabMergeRequestChanges rebuilt =
                GitLabMergeRequestChangesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestChanges.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "mergedBy",
                        "mergeUser",
                        "mergedAt",
                        "closedBy",
                        "closedAt",
                        "titleHtml",
                        "descriptionHtml",
                        "targetBranch",
                        "sourceBranch",
                        "userNotesCount",
                        "upvotes",
                        "downvotes",
                        "author",
                        "assignees",
                        "assignee",
                        "reviewers",
                        "sourceProjectId",
                        "targetProjectId",
                        "labels",
                        "draft",
                        "imported",
                        "importedFrom",
                        "workInProgress",
                        "milestone",
                        "mergeWhenPipelineSucceeds",
                        "mergeStatus",
                        "detailedMergeStatus",
                        "mergeAfter",
                        "sha",
                        "mergeCommitSha",
                        "squashCommitSha",
                        "discussionLocked",
                        "shouldRemoveSourceBranch",
                        "forceRemoveSourceBranch",
                        "preparedAt",
                        "allowCollaboration",
                        "allowMaintainerToPush",
                        "reference",
                        "references",
                        "webUrl",
                        "timeStats",
                        "squash",
                        "squashOnMerge",
                        "taskCompletionStatus",
                        "hasConflicts",
                        "blockingDiscussionsResolved",
                        "approvalsBeforeMerge",
                        "subscribed",
                        "changesCount",
                        "latestBuildStartedAt",
                        "latestBuildFinishedAt",
                        "firstDeployedToProductionAt",
                        "pipeline",
                        "headPipeline",
                        "diffRefs",
                        "mergeError",
                        "rebaseInProgress",
                        "divergedCommitsCount",
                        "firstContribution",
                        "user",
                        "changes",
                        "overflow");
    }
}
