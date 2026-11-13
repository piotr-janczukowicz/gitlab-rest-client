package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssueTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).id(null);

        final GitLabIssue built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).iid(null);

        final GitLabIssue built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).projectId(null);

        final GitLabIssue built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).title(null);

        final GitLabIssue built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).description(null);

        final GitLabIssue built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).state(null);

        final GitLabIssue built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).createdAt(null);

        final GitLabIssue built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).updatedAt(null);

        final GitLabIssue built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).closedAt(null);

        final GitLabIssue built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).closedBy(null);

        final GitLabIssue built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).labels(null);

        final GitLabIssue built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).milestone(null);

        final GitLabIssue built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).assignees(null);

        final GitLabIssue built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).author(null);

        final GitLabIssue built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).type(null);

        final GitLabIssue built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).assignee(null);

        final GitLabIssue built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).userNotesCount(null);

        final GitLabIssue built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).mergeRequestsCount(null);

        final GitLabIssue built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).upvotes(null);

        final GitLabIssue built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).downvotes(null);

        final GitLabIssue built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).startDate(null);

        final GitLabIssue built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).dueDate(null);

        final GitLabIssue built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).confidential(null);

        final GitLabIssue built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).discussionLocked(null);

        final GitLabIssue built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).issueType(null);

        final GitLabIssue built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).webUrl(null);

        final GitLabIssue built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).timeStats(null);

        final GitLabIssue built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).taskCompletionStatus(null);

        final GitLabIssue built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).weight(null);

        final GitLabIssue built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingIssuesCountIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).blockingIssuesCount(null);

        final GitLabIssue built = builder.build();

        assertThat(built.blockingIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasTasksIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).hasTasks(null);

        final GitLabIssue built = builder.build();

        assertThat(built.hasTasks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskStatusIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).taskStatus(null);

        final GitLabIssue built = builder.build();

        assertThat(built.taskStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).links(null);

        final GitLabIssue built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).references(null);

        final GitLabIssue built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).severity(null);

        final GitLabIssue built = builder.build();

        assertThat(built.severity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).subscribed(null);

        final GitLabIssue built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedToIdIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).movedToId(null);

        final GitLabIssue built = builder.build();

        assertThat(built.movedToId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).imported(null);

        final GitLabIssue built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).importedFrom(null);

        final GitLabIssue built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskReplyToIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).serviceDeskReplyTo(null);

        final GitLabIssue built = builder.build();

        assertThat(built.serviceDeskReplyTo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIidIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).epicIid(null);

        final GitLabIssue built = builder.build();

        assertThat(built.epicIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).epic(null);

        final GitLabIssue built = builder.build();

        assertThat(built.epic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).iteration(null);

        final GitLabIssue built = builder.build();

        assertThat(built.iteration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabIssueBuilder builder =
                GitLabIssueBuilder.builder(IssuesCatalogFixtures.issue()).healthStatus(null);

        final GitLabIssue built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssue value = IssuesCatalogFixtures.issue();

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
            softly.assertThat(value.type()).isEqualTo(GitLabIssueType.ISSUE);
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
            softly.assertThat(value.links()).isEqualTo(IssuesCatalogFixtures.issueLinks());
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.severity()).isEqualTo(GitLabIssueSeverity.UNKNOWN);
            softly.assertThat(value.subscribed()).isEqualTo(true);
            softly.assertThat(value.movedToId()).isEqualTo(1L);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("github");
            softly.assertThat(value.serviceDeskReplyTo()).isEqualTo("user@example.com");
            softly.assertThat(value.epicIid()).isEqualTo(1L);
            softly.assertThat(value.epic()).isEqualTo(CommonCatalogFixtures.epicBaseEntity());
            softly.assertThat(value.iteration()).isEqualTo(CommonCatalogFixtures.iteration());
            softly.assertThat(value.healthStatus()).isEqualTo("health_status");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssue original = IssuesCatalogFixtures.issue();

        final GitLabIssue rebuilt = GitLabIssueBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssue.class.getRecordComponents())
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
                        "healthStatus");
    }
}
