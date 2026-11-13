package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .id(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .iid(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .projectId(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .title(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .description(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .state(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .createdAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .updatedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedByIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergedBy(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeUser(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .closedBy(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .closedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleHtmlIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .titleHtml(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.titleHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .descriptionHtml(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .targetBranch(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .sourceBranch(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .userNotesCount(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .upvotes(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .downvotes(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .author(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .assignees(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .assignee(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewersIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .reviewers(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.reviewers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .sourceProjectId(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .targetProjectId(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .labels(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .draft(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .imported(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .importedFrom(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInProgressIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .workInProgress(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.workInProgress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .milestone(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeWhenPipelineSucceeds(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeStatusIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeStatus(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedMergeStatusIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .detailedMergeStatus(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.detailedMergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAfterIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeAfter(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .sha(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitShaIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeCommitSha(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitShaIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .squashCommitSha(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.squashCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .discussionLocked(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShouldRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .shouldRemoveSourceBranch(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.shouldRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForceRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .forceRemoveSourceBranch(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.forceRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreparedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .preparedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.preparedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCollaborationIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .allowCollaboration(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.allowCollaboration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMaintainerToPushIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .allowMaintainerToPush(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.allowMaintainerToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .reference(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .references(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .webUrl(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .timeStats(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .squash(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOnMergeIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .squashOnMerge(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.squashOnMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .taskCompletionStatus(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasConflictsIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .hasConflicts(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.hasConflicts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingDiscussionsResolvedIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .blockingDiscussionsResolved(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.blockingDiscussionsResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .approvalsBeforeMerge(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .subscribed(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChangesCountIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .changesCount(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.changesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLatestBuildStartedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .latestBuildStartedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.latestBuildStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLatestBuildFinishedAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .latestBuildFinishedAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.latestBuildFinishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstDeployedToProductionAtIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .firstDeployedToProductionAt(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.firstDeployedToProductionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .pipeline(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadPipelineIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .headPipeline(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.headPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffRefsIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .diffRefs(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.diffRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeErrorIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .mergeError(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.mergeError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRebaseInProgressIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .rebaseInProgress(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.rebaseInProgress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDivergedCommitsCountIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .divergedCommitsCount(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.divergedCommitsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstContributionIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .firstContribution(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.firstContribution()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabMergeRequestBuilder builder = GitLabMergeRequestBuilder.builder(
                        CommonCatalogFixtures.mergeRequest())
                .user(null);

        final GitLabMergeRequest built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequest value = CommonCatalogFixtures.mergeRequest();

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
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.mergeRequestUser());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequest original = CommonCatalogFixtures.mergeRequest();

        final GitLabMergeRequest rebuilt =
                GitLabMergeRequestBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequest.class.getRecordComponents())
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
                        "user");
    }
}
