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
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .authorId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .authorUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .assigneeId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .assigneeUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .reviewerUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.reviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .labels(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .milestone(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .myReactionEmoji(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .reviewerId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.reviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .state(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .orderBy(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .sort(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .withLabelsDetails(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeStatusRecheckIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .withMergeStatusRecheck(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.withMergeStatusRecheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .createdAfter(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .createdBefore(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .updatedAfter(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .updatedBefore(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAfterIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .mergedAfter(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.mergedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedBeforeIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .mergedBefore(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.mergedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenViewIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .view(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.view()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .scope(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .sourceBranch(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .sourceProjectId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .targetBranch(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .search(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .inValue(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWipIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .wip(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.wip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .draft(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notAuthorId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notAuthorUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notAssigneeId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notAssigneeUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notReviewerUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notReviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notLabels(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notMilestone(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMyReactionEmojiIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notMyReactionEmoji(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notMyReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notReviewerId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.notReviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedBeforeIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .deployedBefore(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.deployedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedAfterIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .deployedAfter(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.deployedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .environment(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIdIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .mergeUserId(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.mergeUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserUsernameIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .mergeUserUsername(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.mergeUserUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverIdsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approverIds(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.approverIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIdsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approvedByIds(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.approvedByIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByUsernamesIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approvedByUsernames(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.approvedByUsernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidsIsNullable() {
        final GitLabProjectMergeRequestsListFilterBuilder builder = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .iids(null);

        final GitLabProjectMergeRequestsListFilter built = builder.build();

        assertThat(built.iids()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsListFilter value = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.authorUsername()).isEqualTo("author_username");
            softly.assertThat(value.assigneeId()).isEqualTo("text");
            softly.assertThat(value.assigneeUsername()).isEqualTo(List.of("assignee_username"));
            softly.assertThat(value.reviewerUsername()).isEqualTo("reviewer_username");
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.myReactionEmoji()).isEqualTo("my_reaction_emoji");
            softly.assertThat(value.reviewerId()).isEqualTo("text");
            softly.assertThat(value.state()).isEqualTo(GitLabProjectMergeRequestsListState.OPENED);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectMergeRequestsListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectMergeRequestsListSort.ASC);
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.withMergeStatusRecheck()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.view()).isEqualTo(GitLabProjectMergeRequestsListView.SIMPLE);
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED);
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo("in");
            softly.assertThat(value.wip()).isEqualTo(GitLabProjectMergeRequestsListWip.YES);
            softly.assertThat(value.draft()).isEqualTo(true);
            softly.assertThat(value.notAuthorId()).isEqualTo(1);
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
            softly.assertThat(value.notAssigneeId()).isEqualTo("text");
            softly.assertThat(value.notAssigneeUsername()).isEqualTo(List.of("not[assignee_username]"));
            softly.assertThat(value.notReviewerUsername()).isEqualTo("not[reviewer_username]");
            softly.assertThat(value.notLabels()).isEqualTo(List.of("not[labels]"));
            softly.assertThat(value.notMilestone()).isEqualTo("not[milestone]");
            softly.assertThat(value.notMyReactionEmoji()).isEqualTo("not[my_reaction_emoji]");
            softly.assertThat(value.notReviewerId()).isEqualTo(1);
            softly.assertThat(value.deployedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.deployedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.environment()).isEqualTo("environment");
            softly.assertThat(value.mergeUserId()).isEqualTo(1L);
            softly.assertThat(value.mergeUserUsername()).isEqualTo("merge_user_username");
            softly.assertThat(value.approverIds()).isEqualTo(List.of("approver_ids"));
            softly.assertThat(value.approvedByIds()).isEqualTo(List.of("approved_by_ids"));
            softly.assertThat(value.approvedByUsernames()).isEqualTo(List.of("approved_by_usernames"));
            softly.assertThat(value.iids()).isEqualTo(List.of(1));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsListFilter original = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();

        final GitLabProjectMergeRequestsListFilter rebuilt =
                GitLabProjectMergeRequestsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .assigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notAssigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .notLabels(source)
                .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApproverIdsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approver_ids"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approverIds(source)
                .build();
        source.clear();

        assertThat(built.approverIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApproverIdsIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.approverIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovedByIdsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approved_by_ids"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approvedByIds(source)
                .build();
        source.clear();

        assertThat(built.approvedByIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovedByIdsIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.approvedByIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovedByUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approved_by_usernames"));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .approvedByUsernames(source)
                .build();
        source.clear();

        assertThat(built.approvedByUsernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovedByUsernamesIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<String> values = built.approvedByUsernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder(
                        GitLabProjectMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabProjectMergeRequestsListState.OPENED)
                                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabProjectMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabProjectMergeRequestsListWip.YES)
                                .draft(true)
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId("text")
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notReviewerUsername("not[reviewer_username]")
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMyReactionEmoji("not[my_reaction_emoji]")
                                .notReviewerId(1)
                                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .mergeUserId(1L)
                                .mergeUserUsername("merge_user_username")
                                .approverIds(List.of("approver_ids"))
                                .approvedByIds(List.of("approved_by_ids"))
                                .approvedByUsernames(List.of("approved_by_usernames"))
                                .iids(List.of(1))
                                .build())
                .iids(source)
                .build();
        source.clear();

        assertThat(built.iids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIidsIsRead() {
        final GitLabProjectMergeRequestsListFilter built = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final List<Integer> values = built.iids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "authorId",
                        "authorUsername",
                        "assigneeId",
                        "assigneeUsername",
                        "reviewerUsername",
                        "labels",
                        "milestone",
                        "myReactionEmoji",
                        "reviewerId",
                        "state",
                        "orderBy",
                        "sort",
                        "withLabelsDetails",
                        "withMergeStatusRecheck",
                        "createdAfter",
                        "createdBefore",
                        "updatedAfter",
                        "updatedBefore",
                        "mergedAfter",
                        "mergedBefore",
                        "view",
                        "scope",
                        "sourceBranch",
                        "sourceProjectId",
                        "targetBranch",
                        "search",
                        "inValue",
                        "wip",
                        "draft",
                        "notAuthorId",
                        "notAuthorUsername",
                        "notAssigneeId",
                        "notAssigneeUsername",
                        "notReviewerUsername",
                        "notLabels",
                        "notMilestone",
                        "notMyReactionEmoji",
                        "notReviewerId",
                        "deployedBefore",
                        "deployedAfter",
                        "environment",
                        "mergeUserId",
                        "mergeUserUsername",
                        "approverIds",
                        "approvedByIds",
                        "approvedByUsernames",
                        "iids");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeRequestsListFilter empty = GitLabProjectMergeRequestsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeRequestsListFilter filter = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("author_id", "1"),
                        Map.entry("author_username", "author_username"),
                        Map.entry("assignee_id", "text"),
                        Map.entry("assignee_username", "assignee_username"),
                        Map.entry("reviewer_username", "reviewer_username"),
                        Map.entry("labels", "labels"),
                        Map.entry("milestone", "milestone"),
                        Map.entry("my_reaction_emoji", "my_reaction_emoji"),
                        Map.entry("reviewer_id", "text"),
                        Map.entry("state", "opened"),
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("with_labels_details", "true"),
                        Map.entry("with_merge_status_recheck", "true"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("merged_after", "2026-01-01T00:00:00Z"),
                        Map.entry("merged_before", "2026-01-01T00:00:00Z"),
                        Map.entry("view", "simple"),
                        Map.entry("scope", "created-by-me"),
                        Map.entry("source_branch", "source_branch"),
                        Map.entry("source_project_id", "1"),
                        Map.entry("target_branch", "target_branch"),
                        Map.entry("search", "search"),
                        Map.entry("in", "in"),
                        Map.entry("wip", "yes"),
                        Map.entry("draft", "true"),
                        Map.entry("not[author_id]", "1"),
                        Map.entry("not[author_username]", "not[author_username]"),
                        Map.entry("not[assignee_id]", "text"),
                        Map.entry("not[assignee_username]", "not[assignee_username]"),
                        Map.entry("not[reviewer_username]", "not[reviewer_username]"),
                        Map.entry("not[labels]", "not[labels]"),
                        Map.entry("not[milestone]", "not[milestone]"),
                        Map.entry("not[my_reaction_emoji]", "not[my_reaction_emoji]"),
                        Map.entry("not[reviewer_id]", "1"),
                        Map.entry("deployed_before", "2026-01-01T00:00:00Z"),
                        Map.entry("deployed_after", "2026-01-01T00:00:00Z"),
                        Map.entry("environment", "environment"),
                        Map.entry("merge_user_id", "1"),
                        Map.entry("merge_user_username", "merge_user_username"),
                        Map.entry("approver_ids", "approver_ids"),
                        Map.entry("approved_by_ids", "approved_by_ids"),
                        Map.entry("approved_by_usernames", "approved_by_usernames"),
                        Map.entry("iids", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeRequestsListFilter filter = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("author_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeRequestsListFilter filter = GitLabProjectMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabProjectMergeRequestsListState.OPENED)
                .orderBy(GitLabProjectMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabProjectMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabProjectMergeRequestsListView.SIMPLE)
                .scope(GitLabProjectMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabProjectMergeRequestsListWip.YES)
                .draft(true)
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId("text")
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notReviewerUsername("not[reviewer_username]")
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMyReactionEmoji("not[my_reaction_emoji]")
                .notReviewerId(1)
                .deployedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .deployedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .mergeUserId(1L)
                .mergeUserUsername("merge_user_username")
                .approverIds(List.of("approver_ids"))
                .approvedByIds(List.of("approved_by_ids"))
                .approvedByUsernames(List.of("approved_by_usernames"))
                .iids(List.of(1))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
