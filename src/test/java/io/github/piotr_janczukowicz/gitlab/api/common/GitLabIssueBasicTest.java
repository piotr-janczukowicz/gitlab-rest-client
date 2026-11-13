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
class GitLabIssueBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .id(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .iid(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .projectId(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .title(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .description(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .state(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .createdAt(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .updatedAt(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .closedAt(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .closedBy(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .labels(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .milestone(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .assignees(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .author(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .type(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .assignee(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .userNotesCount(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .mergeRequestsCount(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .upvotes(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .downvotes(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .startDate(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .dueDate(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .confidential(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .discussionLocked(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .issueType(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .webUrl(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .timeStats(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .taskCompletionStatus(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .weight(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingIssuesCountIsNullable() {
        final GitLabIssueBasicBuilder builder = GitLabIssueBasicBuilder.builder(CommonCatalogFixtures.issueBasic())
                .blockingIssuesCount(null);

        final GitLabIssueBasic built = builder.build();

        assertThat(built.blockingIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssueBasic value = CommonCatalogFixtures.issueBasic();

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
            softly.assertThat(value.type()).isEqualTo(GitLabIssueBasicType.ISSUE);
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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssueBasic original = CommonCatalogFixtures.issueBasic();

        final GitLabIssueBasic rebuilt =
                GitLabIssueBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssueBasic.class.getRecordComponents())
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
                        "blockingIssuesCount");
    }
}
