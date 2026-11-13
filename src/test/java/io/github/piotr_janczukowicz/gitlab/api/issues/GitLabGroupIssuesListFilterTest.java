package io.github.piotr_janczukowicz.gitlab.api.issues;

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
class GitLabGroupIssuesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .withLabelsDetails(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .state(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .closedById(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.closedById()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .orderBy(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .sort(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .dueDate(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .issueType(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .labels(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .milestone(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .milestoneId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidsIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .iids(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.iids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .search(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .inValue(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .authorId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .authorUsername(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .assigneeId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .assigneeUsername(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .createdAfter(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .createdBefore(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .updatedAfter(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .updatedBefore(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notLabels(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notMilestone(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notMilestoneId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notMilestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIidsIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notIids(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notIids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notAuthorId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notAuthorUsername(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notAssigneeId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notAssigneeUsername(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotWeightIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notWeight(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notWeight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notIterationId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notIterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationTitleIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notIterationTitle(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.notIterationTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .scope(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .myReactionEmoji(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .confidential(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .weight(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .epicId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.epicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .healthStatus(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIdIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .iterationId(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.iterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationTitleIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .iterationTitle(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.iterationTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNonArchivedIsNullable() {
        final GitLabGroupIssuesListFilterBuilder builder = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .nonArchived(null);

        final GitLabGroupIssuesListFilter built = builder.build();

        assertThat(built.nonArchived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupIssuesListFilter value = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.state()).isEqualTo(GitLabGroupIssuesListState.OPENED);
            softly.assertThat(value.closedById()).isEqualTo(1L);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupIssuesListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupIssuesListSort.ASC);
            softly.assertThat(value.dueDate()).isEqualTo(GitLabGroupIssuesListDueDate.EMPTY);
            softly.assertThat(value.issueType()).isEqualTo(GitLabGroupIssuesListIssueType.ISSUE);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.milestoneId()).isEqualTo(GitLabGroupIssuesListMilestoneId.ANY);
            softly.assertThat(value.iids()).isEqualTo(List.of(1));
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo("in");
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.authorUsername()).isEqualTo("author_username");
            softly.assertThat(value.assigneeId()).isEqualTo("text");
            softly.assertThat(value.assigneeUsername()).isEqualTo(List.of("assignee_username"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.notLabels()).isEqualTo(List.of("not[labels]"));
            softly.assertThat(value.notMilestone()).isEqualTo("not[milestone]");
            softly.assertThat(value.notMilestoneId()).isEqualTo(GitLabGroupIssuesListNotMilestoneId.ANY);
            softly.assertThat(value.notIids()).isEqualTo(List.of(1));
            softly.assertThat(value.notAuthorId()).isEqualTo(1);
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
            softly.assertThat(value.notAssigneeId()).isEqualTo(1);
            softly.assertThat(value.notAssigneeUsername()).isEqualTo(List.of("not[assignee_username]"));
            softly.assertThat(value.notWeight()).isEqualTo(1);
            softly.assertThat(value.notIterationId()).isEqualTo("text");
            softly.assertThat(value.notIterationTitle()).isEqualTo("not[iteration_title]");
            softly.assertThat(value.scope()).isEqualTo(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED);
            softly.assertThat(value.myReactionEmoji()).isEqualTo("my_reaction_emoji");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.weight()).isEqualTo("text");
            softly.assertThat(value.epicId()).isEqualTo("text");
            softly.assertThat(value.healthStatus()).isEqualTo(GitLabGroupIssuesListHealthStatus.ON_TRACK);
            softly.assertThat(value.iterationId()).isEqualTo("text");
            softly.assertThat(value.iterationTitle()).isEqualTo("iteration_title");
            softly.assertThat(value.nonArchived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupIssuesListFilter original = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();

        final GitLabGroupIssuesListFilter rebuilt =
                GitLabGroupIssuesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .iids(source)
                .build();
        source.clear();

        assertThat(built.iids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIidsIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<Integer> values = built.iids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .assigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notLabels(source)
                .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notIids(source)
                .build();
        source.clear();

        assertThat(built.notIids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotIidsIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<Integer> values = built.notIids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder(
                        GitLabGroupIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabGroupIssuesListState.OPENED)
                                .closedById(1L)
                                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                                .sort(GitLabGroupIssuesListSort.ASC)
                                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                                .iids(List.of(1))
                                .search("search")
                                .inValue("in")
                                .authorId(1L)
                                .authorUsername("author_username")
                                .assigneeId("text")
                                .assigneeUsername(List.of("assignee_username"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .notLabels(List.of("not[labels]"))
                                .notMilestone("not[milestone]")
                                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .nonArchived(true)
                                .build())
                .notAssigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabGroupIssuesListFilter built = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupIssuesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "withLabelsDetails",
                        "state",
                        "closedById",
                        "orderBy",
                        "sort",
                        "dueDate",
                        "issueType",
                        "labels",
                        "milestone",
                        "milestoneId",
                        "iids",
                        "search",
                        "inValue",
                        "authorId",
                        "authorUsername",
                        "assigneeId",
                        "assigneeUsername",
                        "createdAfter",
                        "createdBefore",
                        "updatedAfter",
                        "updatedBefore",
                        "notLabels",
                        "notMilestone",
                        "notMilestoneId",
                        "notIids",
                        "notAuthorId",
                        "notAuthorUsername",
                        "notAssigneeId",
                        "notAssigneeUsername",
                        "notWeight",
                        "notIterationId",
                        "notIterationTitle",
                        "scope",
                        "myReactionEmoji",
                        "confidential",
                        "weight",
                        "epicId",
                        "healthStatus",
                        "iterationId",
                        "iterationTitle",
                        "nonArchived");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupIssuesListFilter empty = GitLabGroupIssuesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupIssuesListFilter filter = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_labels_details", "true"),
                        Map.entry("state", "opened"),
                        Map.entry("closed_by_id", "1"),
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("due_date", ""),
                        Map.entry("issue_type", "issue"),
                        Map.entry("labels", "labels"),
                        Map.entry("milestone", "milestone"),
                        Map.entry("milestone_id", "Any"),
                        Map.entry("iids", "1"),
                        Map.entry("search", "search"),
                        Map.entry("in", "in"),
                        Map.entry("author_id", "1"),
                        Map.entry("author_username", "author_username"),
                        Map.entry("assignee_id", "text"),
                        Map.entry("assignee_username", "assignee_username"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("not[labels]", "not[labels]"),
                        Map.entry("not[milestone]", "not[milestone]"),
                        Map.entry("not[milestone_id]", "Any"),
                        Map.entry("not[iids]", "1"),
                        Map.entry("not[author_id]", "1"),
                        Map.entry("not[author_username]", "not[author_username]"),
                        Map.entry("not[assignee_id]", "1"),
                        Map.entry("not[assignee_username]", "not[assignee_username]"),
                        Map.entry("not[weight]", "1"),
                        Map.entry("not[iteration_id]", "text"),
                        Map.entry("not[iteration_title]", "not[iteration_title]"),
                        Map.entry("scope", "created-by-me"),
                        Map.entry("my_reaction_emoji", "my_reaction_emoji"),
                        Map.entry("confidential", "true"),
                        Map.entry("weight", "text"),
                        Map.entry("epic_id", "text"),
                        Map.entry("health_status", "on_track"),
                        Map.entry("iteration_id", "text"),
                        Map.entry("iteration_title", "iteration_title"),
                        Map.entry("non_archived", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupIssuesListFilter filter = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_labels_details", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupIssuesListFilter filter = GitLabGroupIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabGroupIssuesListState.OPENED)
                .closedById(1L)
                .orderBy(GitLabGroupIssuesListOrderBy.CREATED_AT)
                .sort(GitLabGroupIssuesListSort.ASC)
                .dueDate(GitLabGroupIssuesListDueDate.EMPTY)
                .issueType(GitLabGroupIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabGroupIssuesListMilestoneId.ANY)
                .iids(List.of(1))
                .search("search")
                .inValue("in")
                .authorId(1L)
                .authorUsername("author_username")
                .assigneeId("text")
                .assigneeUsername(List.of("assignee_username"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .notLabels(List.of("not[labels]"))
                .notMilestone("not[milestone]")
                .notMilestoneId(GitLabGroupIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabGroupIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabGroupIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .nonArchived(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
