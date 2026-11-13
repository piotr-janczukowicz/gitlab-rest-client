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
class GitLabInstanceMergeRequestsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .authorId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .authorUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .assigneeId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .assigneeUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .reviewerUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.reviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .labels(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .milestone(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .myReactionEmoji(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .reviewerId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.reviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .state(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .orderBy(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .sort(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .withLabelsDetails(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeStatusRecheckIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .withMergeStatusRecheck(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.withMergeStatusRecheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .createdAfter(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .createdBefore(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .updatedAfter(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .updatedBefore(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAfterIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .mergedAfter(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.mergedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedBeforeIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .mergedBefore(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.mergedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenViewIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .view(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.view()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .scope(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .sourceBranch(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .sourceProjectId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .targetBranch(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .search(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .inValue(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWipIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .wip(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.wip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .draft(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notAuthorId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notAuthorUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notAssigneeId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notAssigneeUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notReviewerUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notReviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notLabels(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notMilestone(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMyReactionEmojiIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notMyReactionEmoji(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notMyReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .notReviewerId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.notReviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedBeforeIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .deployedBefore(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.deployedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedAfterIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .deployedAfter(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.deployedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .environment(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIdIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .mergeUserId(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.mergeUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserUsernameIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .mergeUserUsername(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.mergeUserUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverIdsIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .approverIds(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.approverIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIdsIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .approvedByIds(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.approvedByIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByUsernamesIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .approvedByUsernames(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.approvedByUsernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNonArchivedIsNullable() {
        final GitLabInstanceMergeRequestsListFilterBuilder builder =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(
                                GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabInstanceMergeRequestsListState.OPENED)
                                        .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                        .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                        .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                        .nonArchived(true)
                                        .build())
                        .nonArchived(null);

        final GitLabInstanceMergeRequestsListFilter built = builder.build();

        assertThat(built.nonArchived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceMergeRequestsListFilter value = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
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
            softly.assertThat(value.state()).isEqualTo(GitLabInstanceMergeRequestsListState.OPENED);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceMergeRequestsListSort.ASC);
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.withMergeStatusRecheck()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.view()).isEqualTo(GitLabInstanceMergeRequestsListView.SIMPLE);
            softly.assertThat(value.scope()).isEqualTo(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED);
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo("in");
            softly.assertThat(value.wip()).isEqualTo(GitLabInstanceMergeRequestsListWip.YES);
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
            softly.assertThat(value.nonArchived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceMergeRequestsListFilter original = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();

        final GitLabInstanceMergeRequestsListFilter rebuilt =
                GitLabInstanceMergeRequestsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .assigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .notAssigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .notLabels(source)
                .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApproverIdsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approver_ids"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .approverIds(source)
                .build();
        source.clear();

        assertThat(built.approverIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApproverIdsIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.approverIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovedByIdsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approved_by_ids"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .approvedByIds(source)
                .build();
        source.clear();

        assertThat(built.approvedByIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovedByIdsIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.approvedByIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovedByUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("approved_by_usernames"));
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder(
                        GitLabInstanceMergeRequestsListFilterBuilder.builder()
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .reviewerUsername("reviewer_username")
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .myReactionEmoji("my_reaction_emoji")
                                .reviewerId("text")
                                .state(GitLabInstanceMergeRequestsListState.OPENED)
                                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                                .withLabelsDetails(true)
                                .withMergeStatusRecheck(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                                .sourceBranch("source_branch")
                                .sourceProjectId(1L)
                                .targetBranch("target_branch")
                                .search("search")
                                .inValue("in")
                                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                                .nonArchived(true)
                                .build())
                .approvedByUsernames(source)
                .build();
        source.clear();

        assertThat(built.approvedByUsernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovedByUsernamesIsRead() {
        final GitLabInstanceMergeRequestsListFilter built = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final List<String> values = built.approvedByUsernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceMergeRequestsListFilter.class.getRecordComponents())
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
                        "nonArchived");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceMergeRequestsListFilter empty = GitLabInstanceMergeRequestsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceMergeRequestsListFilter filter = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
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
                        Map.entry("non_archived", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceMergeRequestsListFilter filter = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("author_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceMergeRequestsListFilter filter = GitLabInstanceMergeRequestsListFilterBuilder.builder()
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .reviewerUsername("reviewer_username")
                .labels(List.of("labels"))
                .milestone("milestone")
                .myReactionEmoji("my_reaction_emoji")
                .reviewerId("text")
                .state(GitLabInstanceMergeRequestsListState.OPENED)
                .orderBy(GitLabInstanceMergeRequestsListOrderBy.CREATED_AT)
                .sort(GitLabInstanceMergeRequestsListSort.ASC)
                .withLabelsDetails(true)
                .withMergeStatusRecheck(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .view(GitLabInstanceMergeRequestsListView.SIMPLE)
                .scope(GitLabInstanceMergeRequestsListScope.CREATED_BY_ME_DASHED)
                .sourceBranch("source_branch")
                .sourceProjectId(1L)
                .targetBranch("target_branch")
                .search("search")
                .inValue("in")
                .wip(GitLabInstanceMergeRequestsListWip.YES)
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
                .nonArchived(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
