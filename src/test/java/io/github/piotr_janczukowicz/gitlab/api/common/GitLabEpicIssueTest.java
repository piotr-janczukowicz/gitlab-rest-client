package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicIssueTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .id(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .iid(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .projectId(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .title(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .description(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .state(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .createdAt(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .updatedAt(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .closedAt(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .closedBy(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .labels(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .milestone(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .assignees(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .author(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .type(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .assignee(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .userNotesCount(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .mergeRequestsCount(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .upvotes(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .downvotes(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .startDate(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .dueDate(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .confidential(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .discussionLocked(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .issueType(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .webUrl(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .timeStats(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .taskCompletionStatus(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .weight(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingIssuesCountIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .blockingIssuesCount(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.blockingIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasTasksIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .hasTasks(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.hasTasks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskStatusIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .taskStatus(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.taskStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .links(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .references(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .severity(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.severity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .subscribed(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedToIdIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .movedToId(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.movedToId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .imported(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .importedFrom(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskReplyToIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .serviceDeskReplyTo(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.serviceDeskReplyTo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIidIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .epicIid(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.epicIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .epic(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.epic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .iteration(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.iteration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .healthStatus(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIssueIdIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .epicIssueId(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.epicIssueId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelativePositionIsNullable() {
        final GitLabEpicIssueBuilder builder = GitLabEpicIssueBuilder.builder(CommonCatalogFixtures.epicIssue())
                .relativePosition(null);

        final GitLabEpicIssue built = builder.build();

        assertThat(built.relativePosition()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicIssue value = CommonCatalogFixtures.epicIssue();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Impedit et ut et dolores vero provident ullam est");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.closedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.closedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.labels()).isEqualTo(List.of("bug"));
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.assignees()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.type()).isEqualTo(GitLabEpicIssueType.ISSUE);
            softly.assertThat(value.assignee()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.userNotesCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestsCount()).isEqualTo(1);
            softly.assertThat(value.upvotes()).isEqualTo(1);
            softly.assertThat(value.downvotes()).isEqualTo(1);
            softly.assertThat(value.startDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.discussionLocked()).isEqualTo(true);
            softly.assertThat(value.issueType()).isEqualTo("issue");
            softly.assertThat(value.webUrl()).isEqualTo("http://example.com/example/example/issues/14");
            softly.assertThat(value.timeStats()).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(value.taskCompletionStatus()).isEqualTo(CommonCatalogFixtures.taskCompletionStatus());
            softly.assertThat(value.weight()).isEqualTo(1);
            softly.assertThat(value.blockingIssuesCount()).isEqualTo(1);
            softly.assertThat(value.hasTasks()).isEqualTo(true);
            softly.assertThat(value.taskStatus()).isEqualTo("2 of 4 tasks completed");
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.epicIssueLinks());
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.severity()).isEqualTo(GitLabEpicIssueSeverity.UNKNOWN);
            softly.assertThat(value.subscribed()).isEqualTo(true);
            softly.assertThat(value.movedToId()).isEqualTo(1L);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("github");
            softly.assertThat(value.serviceDeskReplyTo()).isEqualTo("user@example.com");
            softly.assertThat(value.epicIid()).isEqualTo("epic_iid");
            softly.assertThat(value.epic()).isEqualTo(CommonCatalogFixtures.epicBaseEntity());
            softly.assertThat(value.iteration()).isEqualTo(CommonCatalogFixtures.iteration());
            softly.assertThat(value.healthStatus()).isEqualTo("health_status");
            softly.assertThat(value.epicIssueId()).isEqualTo(1L);
            softly.assertThat(value.relativePosition()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicIssue original = CommonCatalogFixtures.epicIssue();

        final GitLabEpicIssue rebuilt = GitLabEpicIssueBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicIssue.class.getRecordComponents())
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
                        "closedAt",
                        "closedBy",
                        "labels",
                        "milestone",
                        "assignees",
                        "author",
                        "type",
                        "assignee",
                        "userNotesCount",
                        "mergeRequestsCount",
                        "upvotes",
                        "downvotes",
                        "startDate",
                        "dueDate",
                        "confidential",
                        "discussionLocked",
                        "issueType",
                        "webUrl",
                        "timeStats",
                        "taskCompletionStatus",
                        "weight",
                        "blockingIssuesCount",
                        "hasTasks",
                        "taskStatus",
                        "links",
                        "references",
                        "severity",
                        "subscribed",
                        "movedToId",
                        "imported",
                        "importedFrom",
                        "serviceDeskReplyTo",
                        "epicIid",
                        "epic",
                        "iteration",
                        "healthStatus",
                        "epicIssueId",
                        "relativePosition");
    }
}
