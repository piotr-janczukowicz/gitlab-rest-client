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
class GitLabInstanceIssuesCallIssuesStatisticsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .labels(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .milestone(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .milestoneId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidsIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .iids(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.iids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .search(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .inValue(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .authorId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .authorUsername(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .assigneeId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeUsernameIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .assigneeUsername(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.assigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .createdAfter(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .createdBefore(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .updatedAfter(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .updatedBefore(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notLabels(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notMilestone(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notMilestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notMilestoneId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notMilestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIidsIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notIids(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notIids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notAuthorId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notAuthorUsername(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notAssigneeId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notAssigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAssigneeUsernameIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notAssigneeUsername(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notAssigneeUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotWeightIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notWeight(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notWeight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notIterationId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notIterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotIterationTitleIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notIterationTitle(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.notIterationTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .scope(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .myReactionEmoji(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .confidential(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .weight(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .epicId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.epicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .healthStatus(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIdIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .iterationId(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.iterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationTitleIsNullable() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder builder =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .iterationTitle(null);

        final GitLabInstanceIssuesCallIssuesStatisticsFilter built = builder.build();

        assertThat(built.iterationTitle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter value =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.milestoneId()).isEqualTo(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY);
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
            softly.assertThat(value.notMilestoneId())
                    .isEqualTo(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY);
            softly.assertThat(value.notIids()).isEqualTo(List.of(1));
            softly.assertThat(value.notAuthorId()).isEqualTo(1);
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
            softly.assertThat(value.notAssigneeId()).isEqualTo(1);
            softly.assertThat(value.notAssigneeUsername()).isEqualTo(List.of("not[assignee_username]"));
            softly.assertThat(value.notWeight()).isEqualTo(1);
            softly.assertThat(value.notIterationId()).isEqualTo("text");
            softly.assertThat(value.notIterationTitle()).isEqualTo("not[iteration_title]");
            softly.assertThat(value.scope()).isEqualTo(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME);
            softly.assertThat(value.myReactionEmoji()).isEqualTo("my_reaction_emoji");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.weight()).isEqualTo("text");
            softly.assertThat(value.epicId()).isEqualTo("text");
            softly.assertThat(value.healthStatus())
                    .isEqualTo(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK);
            softly.assertThat(value.iterationId()).isEqualTo("text");
            softly.assertThat(value.iterationTitle()).isEqualTo("iteration_title");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter original =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();

        final GitLabInstanceIssuesCallIssuesStatisticsFilter rebuilt =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .labels(source)
                        .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .iids(source)
                        .build();
        source.clear();

        assertThat(built.iids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIidsIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<Integer> values = built.iids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("assignee_username"));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .assigneeUsername(source)
                        .build();
        source.clear();

        assertThat(built.assigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeUsernameIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<String> values = built.assigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notLabels(source)
                        .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notIids(source)
                        .build();
        source.clear();

        assertThat(built.notIids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotIidsIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<Integer> values = built.notIids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotAssigneeUsernameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[assignee_username]"));
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder(
                                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                                        .labels(List.of("labels"))
                                        .milestone("milestone")
                                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                                        .notIids(List.of(1))
                                        .notAuthorId(1)
                                        .notAuthorUsername("not[author_username]")
                                        .notAssigneeId(1)
                                        .notAssigneeUsername(List.of("not[assignee_username]"))
                                        .notWeight(1)
                                        .notIterationId("text")
                                        .notIterationTitle("not[iteration_title]")
                                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                                        .myReactionEmoji("my_reaction_emoji")
                                        .confidential(true)
                                        .weight("text")
                                        .epicId("text")
                                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                                        .iterationId("text")
                                        .iterationTitle("iteration_title")
                                        .build())
                        .notAssigneeUsername(source)
                        .build();
        source.clear();

        assertThat(built.notAssigneeUsername()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotAssigneeUsernameIsRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter built =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final List<String> values = built.notAssigneeUsername();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceIssuesCallIssuesStatisticsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
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
                        "iterationTitle");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter empty =
                GitLabInstanceIssuesCallIssuesStatisticsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter filter =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
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
                        Map.entry("scope", "created_by_me"),
                        Map.entry("my_reaction_emoji", "my_reaction_emoji"),
                        Map.entry("confidential", "true"),
                        Map.entry("weight", "text"),
                        Map.entry("epic_id", "text"),
                        Map.entry("health_status", "on_track"),
                        Map.entry("iteration_id", "text"),
                        Map.entry("iteration_title", "iteration_title"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter filter =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("labels", "labels"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceIssuesCallIssuesStatisticsFilter filter =
                GitLabInstanceIssuesCallIssuesStatisticsFilterBuilder.builder()
                        .labels(List.of("labels"))
                        .milestone("milestone")
                        .milestoneId(GitLabInstanceIssuesCallIssuesStatisticsMilestoneId.ANY)
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
                        .notMilestoneId(GitLabInstanceIssuesCallIssuesStatisticsNotMilestoneId.ANY)
                        .notIids(List.of(1))
                        .notAuthorId(1)
                        .notAuthorUsername("not[author_username]")
                        .notAssigneeId(1)
                        .notAssigneeUsername(List.of("not[assignee_username]"))
                        .notWeight(1)
                        .notIterationId("text")
                        .notIterationTitle("not[iteration_title]")
                        .scope(GitLabInstanceIssuesCallIssuesStatisticsScope.CREATED_BY_ME)
                        .myReactionEmoji("my_reaction_emoji")
                        .confidential(true)
                        .weight("text")
                        .epicId("text")
                        .healthStatus(GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.ON_TRACK)
                        .iterationId("text")
                        .iterationTitle("iteration_title")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
