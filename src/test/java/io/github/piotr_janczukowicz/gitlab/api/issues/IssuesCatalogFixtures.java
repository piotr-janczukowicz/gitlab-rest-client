package io.github.piotr_janczukowicz.gitlab.api.issues;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public final class IssuesCatalogFixtures {

    private IssuesCatalogFixtures() {}

    public static GitLabIssuableMetricImage issuableMetricImage() {
        return GitLabIssuableMetricImageBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .filename("image.png")
                .filePath("/uploads/-/system/issuable_metric_image/file/1/image.png")
                .url("https://gitlab.example.com/example")
                .urlText("Example URL")
                .build();
    }

    public static GitLabIssue issue() {
        return GitLabIssueBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .labels(List.of("bug"))
                .milestone(CommonCatalogFixtures.milestone())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .author(CommonCatalogFixtures.userBasic())
                .type(GitLabIssueType.ISSUE)
                .assignee(CommonCatalogFixtures.userBasic())
                .userNotesCount(1)
                .mergeRequestsCount(1)
                .upvotes(1)
                .downvotes(1)
                .startDate(LocalDate.parse("2026-01-01"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .confidential(true)
                .discussionLocked(true)
                .issueType("issue")
                .webUrl("http://example.com/example/example/issues/14")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .weight(1)
                .blockingIssuesCount(1)
                .hasTasks(true)
                .taskStatus("2 of 4 tasks completed")
                .links(IssuesCatalogFixtures.issueLinks())
                .references(CommonCatalogFixtures.issuableReferences())
                .severity(GitLabIssueSeverity.UNKNOWN)
                .subscribed(true)
                .movedToId(1L)
                .imported(true)
                .importedFrom("github")
                .serviceDeskReplyTo("user@example.com")
                .epicIid(1L)
                .epic(CommonCatalogFixtures.epicBaseEntity())
                .iteration(CommonCatalogFixtures.iteration())
                .healthStatus("health_status")
                .build();
    }

    public static GitLabIssueLinks issueLinks() {
        return GitLabIssueLinksBuilder.builder()
                .self("http://example.com/api/v4/projects/1/issues/2")
                .notes("http://example.com/api/v4/projects/1/issues/2/notes")
                .awardEmoji("http://example.com/api/v4/projects/1/issues/2/award_emoji")
                .project("http://example.com/api/v4/projects/1")
                .closedAsDuplicateOf("http://example.com/api/v4/projects/1/issues/75")
                .build();
    }

    public static GitLabProjectIssuesAddSpentTimePayload projectIssuesAddSpentTimePayload() {
        return GitLabProjectIssuesAddSpentTimePayloadBuilder.builder()
                .duration("duration")
                .build();
    }

    public static GitLabProjectIssuesCreatePayload projectIssuesCreatePayload() {
        return GitLabProjectIssuesCreatePayloadBuilder.builder()
                .title("title")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestToResolveDiscussionsOf(1)
                .discussionToResolve("discussion_to_resolve")
                .iid(1L)
                .description("description")
                .assigneeIds(List.of(1L))
                .assigneeId(1L)
                .milestoneId(1L)
                .milestone("milestone")
                .labels(List.of("labels"))
                .addLabels(List.of("add_labels"))
                .removeLabels(List.of("remove_labels"))
                .dueDate("due_date")
                .startDate("start_date")
                .confidential(true)
                .discussionLocked(true)
                .issueType(GitLabProjectIssuesCreateIssueType.ISSUE)
                .severity(GitLabProjectIssuesCreateSeverity.UNKNOWN)
                .weight(1)
                .epicId(1L)
                .epicIid(1L)
                .build();
    }

    public static GitLabProjectIssuesDoClonePayload projectIssuesDoClonePayload() {
        return GitLabProjectIssuesDoClonePayloadBuilder.builder()
                .toProjectId(1L)
                .withNotes(true)
                .build();
    }

    public static GitLabProjectIssuesMovePayload projectIssuesMovePayload() {
        return GitLabProjectIssuesMovePayloadBuilder.builder().toProjectId(1L).build();
    }

    public static GitLabProjectIssuesReorderPayload projectIssuesReorderPayload() {
        return GitLabProjectIssuesReorderPayloadBuilder.builder()
                .moveAfterId(1L)
                .moveBeforeId(1L)
                .build();
    }

    public static GitLabProjectIssuesTimeEstimatePayload projectIssuesTimeEstimatePayload() {
        return GitLabProjectIssuesTimeEstimatePayloadBuilder.builder()
                .duration("3h30m")
                .build();
    }

    public static GitLabProjectIssuesUpdateMetricImagePayload projectIssuesUpdateMetricImagePayload() {
        return GitLabProjectIssuesUpdateMetricImagePayloadBuilder.builder()
                .url("url")
                .urlText("url_text")
                .build();
    }

    public static GitLabProjectIssuesUpdatePayload projectIssuesUpdatePayload() {
        return GitLabProjectIssuesUpdatePayloadBuilder.builder()
                .title("title")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .stateEvent(GitLabProjectIssuesUpdateStateEvent.REOPEN)
                .description("description")
                .assigneeIds(List.of(1L))
                .assigneeId(1L)
                .milestoneId(1L)
                .milestone("milestone")
                .labels(List.of("labels"))
                .addLabels(List.of("add_labels"))
                .removeLabels(List.of("remove_labels"))
                .dueDate("due_date")
                .startDate("start_date")
                .confidential(true)
                .discussionLocked(true)
                .issueType(GitLabProjectIssuesUpdateIssueType.ISSUE)
                .severity(GitLabProjectIssuesUpdateSeverity.UNKNOWN)
                .weight(1)
                .epicId(1L)
                .epicIid(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }
}
