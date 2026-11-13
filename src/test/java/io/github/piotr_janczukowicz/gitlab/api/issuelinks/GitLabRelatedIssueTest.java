package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

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
class GitLabRelatedIssueTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .id(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .iid(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .projectId(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .title(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .description(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .state(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .createdAt(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .updatedAt(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .closedAt(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .closedBy(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .labels(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .milestone(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .assignees(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .author(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .type(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .assignee(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .userNotesCount(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .mergeRequestsCount(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .upvotes(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .downvotes(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .startDate(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .dueDate(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .confidential(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .discussionLocked(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .issueType(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .webUrl(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .timeStats(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .taskCompletionStatus(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .weight(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingIssuesCountIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .blockingIssuesCount(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.blockingIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasTasksIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .hasTasks(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.hasTasks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskStatusIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .taskStatus(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.taskStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .links(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .references(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .severity(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.severity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .subscribed(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMovedToIdIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .movedToId(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.movedToId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .imported(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .importedFrom(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskReplyToIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .serviceDeskReplyTo(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.serviceDeskReplyTo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIidIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .epicIid(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.epicIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .epic(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.epic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .iteration(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.iteration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHealthStatusIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .healthStatus(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.healthStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueLinkIdIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .issueLinkId(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.issueLinkId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .linkType(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkCreatedAtIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .linkCreatedAt(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.linkCreatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkUpdatedAtIsNullable() {
        final GitLabRelatedIssueBuilder builder = GitLabRelatedIssueBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssue())
                .linkUpdatedAt(null);

        final GitLabRelatedIssue built = builder.build();

        assertThat(built.linkUpdatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelatedIssue value = IssuelinksCatalogFixtures.relatedIssue();

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
            softly.assertThat(value.type()).isEqualTo(GitLabRelatedIssueType.ISSUE);
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
            softly.assertThat(value.links()).isEqualTo(IssuelinksCatalogFixtures.relatedIssueLinks());
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.severity()).isEqualTo(GitLabRelatedIssueSeverity.UNKNOWN);
            softly.assertThat(value.subscribed()).isEqualTo(true);
            softly.assertThat(value.movedToId()).isEqualTo(1L);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("github");
            softly.assertThat(value.serviceDeskReplyTo()).isEqualTo("user@example.com");
            softly.assertThat(value.epicIid()).isEqualTo("epic_iid");
            softly.assertThat(value.epic()).isEqualTo(CommonCatalogFixtures.epicBaseEntity());
            softly.assertThat(value.iteration()).isEqualTo(CommonCatalogFixtures.iteration());
            softly.assertThat(value.healthStatus()).isEqualTo("health_status");
            softly.assertThat(value.issueLinkId()).isEqualTo(1L);
            softly.assertThat(value.linkType()).isEqualTo("relates_to");
            softly.assertThat(value.linkCreatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.linkUpdatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRelatedIssue original = IssuelinksCatalogFixtures.relatedIssue();

        final GitLabRelatedIssue rebuilt =
                GitLabRelatedIssueBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelatedIssue.class.getRecordComponents())
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
                        "issueLinkId",
                        "linkType",
                        "linkCreatedAt",
                        "linkUpdatedAt");
    }
}
