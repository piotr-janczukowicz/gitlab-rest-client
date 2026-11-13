package io.github.piotr_janczukowicz.gitlab.api.deployments;

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
class GitLabProjectDeploymentsListMergeRequestsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .authorId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .authorUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .assigneeId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .assigneeUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .reviewerUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.reviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .labels(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .milestone(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .myReactionEmoji(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .reviewerId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.reviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .state(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .orderBy(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .sort(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .withLabelsDetails(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeStatusRecheckIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .withMergeStatusRecheck(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.withMergeStatusRecheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .createdAfter(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .createdBefore(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .updatedAfter(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .updatedBefore(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAfterIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .mergedAfter(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.mergedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedBeforeIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .mergedBefore(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.mergedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenViewIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .view(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.view()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .scope(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .sourceBranch(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .sourceProjectId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .targetBranch(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .search(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .inValue(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWipIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .wip(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.wip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .draft(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notAuthorId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notAuthorUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notAssigneeId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notAssigneeUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notReviewerUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notReviewerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notLabels(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notMilestone(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMyReactionEmojiIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notMyReactionEmoji(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notMyReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotReviewerIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notReviewerId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.notReviewerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedBeforeIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .deployedBefore(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.deployedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployedAfterIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .deployedAfter(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.deployedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .environment(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIdIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .mergeUserId(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.mergeUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserUsernameIsNullable() {
        final GitLabProjectDeploymentsListMergeRequestsFilterBuilder builder =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .mergeUserUsername(null);

        final GitLabProjectDeploymentsListMergeRequestsFilter built = builder.build();

        assertThat(built.mergeUserUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeploymentsListMergeRequestsFilter value =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
            softly.assertThat(value.state()).isEqualTo(GitLabProjectDeploymentsListMergeRequestsState.OPENED);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectDeploymentsListMergeRequestsSort.ASC);
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.withMergeStatusRecheck()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.view()).isEqualTo(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE);
            softly.assertThat(value.scope())
                    .isEqualTo(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED);
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo("in");
            softly.assertThat(value.wip()).isEqualTo(GitLabProjectDeploymentsListMergeRequestsWip.YES);
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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeploymentsListMergeRequestsFilter original =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();

        final GitLabProjectDeploymentsListMergeRequestsFilter rebuilt =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .assigneeUsername(source)
                        .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .labels(source)
                        .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notAssigneeUsername(source)
                        .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder(
                                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                                        .authorId(1L)
                                        .authorUsername("author_username")
                                        .assigneeId("text")
                                        .assigneeUsername(List.of("assignee_username"))
                                        .reviewerUsername("reviewer_username")
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .myReactionEmoji("my_reaction_emoji")
                                        .reviewerId("text")
                                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                                        .withLabelsDetails(true)
                                        .withMergeStatusRecheck(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                                        .sourceBranch("source_branch")
                                        .sourceProjectId(1L)
                                        .targetBranch("target_branch")
                                        .search("search")
                                        .inValue("in")
                                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                                        .build())
                        .notLabels(source)
                        .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabProjectDeploymentsListMergeRequestsFilter built =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDeploymentsListMergeRequestsFilter.class.getRecordComponents())
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
                        "mergeUserUsername");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectDeploymentsListMergeRequestsFilter empty =
                GitLabProjectDeploymentsListMergeRequestsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectDeploymentsListMergeRequestsFilter filter =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        Map.entry("merge_user_username", "merge_user_username"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectDeploymentsListMergeRequestsFilter filter =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("author_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectDeploymentsListMergeRequestsFilter filter =
                GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder()
                        .authorId(1L)
                        .authorUsername("author_username")
                        .assigneeId("text")
                        .assigneeUsername(List.of("assignee_username"))
                        .reviewerUsername("reviewer_username")
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .myReactionEmoji("my_reaction_emoji")
                        .reviewerId("text")
                        .state(GitLabProjectDeploymentsListMergeRequestsState.OPENED)
                        .orderBy(GitLabProjectDeploymentsListMergeRequestsOrderBy.CREATED_AT)
                        .sort(GitLabProjectDeploymentsListMergeRequestsSort.ASC)
                        .withLabelsDetails(true)
                        .withMergeStatusRecheck(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .mergedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .view(GitLabProjectDeploymentsListMergeRequestsView.SIMPLE)
                        .scope(GitLabProjectDeploymentsListMergeRequestsScope.CREATED_BY_ME_DASHED)
                        .sourceBranch("source_branch")
                        .sourceProjectId(1L)
                        .targetBranch("target_branch")
                        .search("search")
                        .inValue("in")
                        .wip(GitLabProjectDeploymentsListMergeRequestsWip.YES)
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
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
