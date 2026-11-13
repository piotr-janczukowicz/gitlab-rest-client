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
class GitLabProjectIssuesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .withLabelsDetails(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .state(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .closedById(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.closedById()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .dueDate(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .issueType(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .labels(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .milestone(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .milestoneId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidsIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .iids(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.iids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .search(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .inValue(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .authorId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .authorUsername(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .assigneeId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .assigneeUsername(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .createdAfter(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .createdBefore(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .updatedAfter(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .updatedBefore(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notLabels(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notMilestone(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notMilestoneId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notMilestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIidsIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notIids(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notIids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notAuthorId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notAuthorUsername(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notAssigneeId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notAssigneeUsername(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotWeightIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notWeight(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notWeight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notIterationId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notIterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationTitleIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notIterationTitle(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.notIterationTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .scope(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .myReactionEmoji(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .confidential(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .weight(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .epicId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.epicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .healthStatus(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIdIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .iterationId(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.iterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationTitleIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .iterationTitle(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.iterationTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabProjectIssuesListFilterBuilder builder = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .cursor(null);

        final GitLabProjectIssuesListFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesListFilter value = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.state()).isEqualTo(GitLabProjectIssuesListState.OPENED);
            softly.assertThat(value.closedById()).isEqualTo(1L);
            softly.assertThat(value.dueDate()).isEqualTo(GitLabProjectIssuesListDueDate.EMPTY);
            softly.assertThat(value.issueType()).isEqualTo(GitLabProjectIssuesListIssueType.ISSUE);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.milestoneId()).isEqualTo(GitLabProjectIssuesListMilestoneId.ANY);
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
            softly.assertThat(value.notMilestoneId()).isEqualTo(GitLabProjectIssuesListNotMilestoneId.ANY);
            softly.assertThat(value.notIids()).isEqualTo(List.of(1));
            softly.assertThat(value.notAuthorId()).isEqualTo(1);
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
            softly.assertThat(value.notAssigneeId()).isEqualTo(1);
            softly.assertThat(value.notAssigneeUsername()).isEqualTo(List.of("not[assignee_username]"));
            softly.assertThat(value.notWeight()).isEqualTo(1);
            softly.assertThat(value.notIterationId()).isEqualTo("text");
            softly.assertThat(value.notIterationTitle()).isEqualTo("not[iteration_title]");
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED);
            softly.assertThat(value.myReactionEmoji()).isEqualTo("my_reaction_emoji");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.weight()).isEqualTo("text");
            softly.assertThat(value.epicId()).isEqualTo("text");
            softly.assertThat(value.healthStatus()).isEqualTo(GitLabProjectIssuesListHealthStatus.ON_TRACK);
            softly.assertThat(value.iterationId()).isEqualTo("text");
            softly.assertThat(value.iterationTitle()).isEqualTo("iteration_title");
            softly.assertThat(value.cursor()).isEqualTo("cursor");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesListFilter original = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();

        final GitLabProjectIssuesListFilter rebuilt =
                GitLabProjectIssuesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .iids(source)
                .build();
        source.clear();

        assertThat(built.iids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIidsIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<Integer> values = built.iids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .assigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notLabels(source)
                .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notIids(source)
                .build();
        source.clear();

        assertThat(built.notIids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotIidsIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<Integer> values = built.notIids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder(
                        GitLabProjectIssuesListFilterBuilder.builder()
                                .withLabelsDetails(true)
                                .state(GitLabProjectIssuesListState.OPENED)
                                .closedById(1L)
                                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                                .labels(List.of("labels"))
                                .milestone("milestone")
                                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                                .notIids(List.of(1))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .notAssigneeId(1)
                                .notAssigneeUsername(List.of("not[assignee_username]"))
                                .notWeight(1)
                                .notIterationId("text")
                                .notIterationTitle("not[iteration_title]")
                                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .weight("text")
                                .epicId("text")
                                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                                .iterationId("text")
                                .iterationTitle("iteration_title")
                                .cursor("cursor")
                                .build())
                .notAssigneeUsername(source)
                .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabProjectIssuesListFilter built = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "withLabelsDetails",
                        "state",
                        "closedById",
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
                        "cursor");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectIssuesListFilter empty = GitLabProjectIssuesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectIssuesListFilter filter = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_labels_details", "true"),
                        Map.entry("state", "opened"),
                        Map.entry("closed_by_id", "1"),
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
                        Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectIssuesListFilter filter = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_labels_details", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectIssuesListFilter filter = GitLabProjectIssuesListFilterBuilder.builder()
                .withLabelsDetails(true)
                .state(GitLabProjectIssuesListState.OPENED)
                .closedById(1L)
                .dueDate(GitLabProjectIssuesListDueDate.EMPTY)
                .issueType(GitLabProjectIssuesListIssueType.ISSUE)
                .labels(List.of("labels"))
                .milestone("milestone")
                .milestoneId(GitLabProjectIssuesListMilestoneId.ANY)
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
                .notMilestoneId(GitLabProjectIssuesListNotMilestoneId.ANY)
                .notIids(List.of(1))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .notAssigneeId(1)
                .notAssigneeUsername(List.of("not[assignee_username]"))
                .notWeight(1)
                .notIterationId("text")
                .notIterationTitle("not[iteration_title]")
                .scope(GitLabProjectIssuesListScope.CREATED_BY_ME_DASHED)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .weight("text")
                .epicId("text")
                .healthStatus(GitLabProjectIssuesListHealthStatus.ON_TRACK)
                .iterationId("text")
                .iterationTitle("iteration_title")
                .cursor("cursor")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
