package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public final class IssuelinksCatalogFixtures {

    private IssuelinksCatalogFixtures() {}

    public static GitLabIssueLink issueLink() {
        return GitLabIssueLinkBuilder.builder()
                .id(1L)
                .sourceIssue(CommonCatalogFixtures.issueBasic())
                .targetIssue(CommonCatalogFixtures.issueBasic())
                .linkType("relates_to")
                .build();
    }

    public static GitLabProjectIssueLinksCreatePayload projectIssueLinksCreatePayload() {
        return GitLabProjectIssueLinksCreatePayloadBuilder.builder()
                .targetProjectId("text")
                .targetIssueIid("text")
                .linkType(GitLabProjectIssueLinksCreateLinkType.RELATES_TO)
                .build();
    }

    public static GitLabRelatedIssue relatedIssue() {
        return GitLabRelatedIssueBuilder.builder()
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
                .type(GitLabRelatedIssueType.ISSUE)
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
                .links(IssuelinksCatalogFixtures.relatedIssueLinks())
                .references(CommonCatalogFixtures.issuableReferences())
                .severity(GitLabRelatedIssueSeverity.UNKNOWN)
                .subscribed(true)
                .movedToId(1L)
                .imported(true)
                .importedFrom("github")
                .serviceDeskReplyTo("user@example.com")
                .epicIid("epic_iid")
                .epic(CommonCatalogFixtures.epicBaseEntity())
                .iteration(CommonCatalogFixtures.iteration())
                .healthStatus("health_status")
                .issueLinkId(1L)
                .linkType("relates_to")
                .linkCreatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .linkUpdatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabRelatedIssueLinks relatedIssueLinks() {
        return GitLabRelatedIssueLinksBuilder.builder()
                .self("http://example.com/api/v4/projects/1/issues/2")
                .notes("http://example.com/api/v4/projects/1/issues/2/notes")
                .awardEmoji("http://example.com/api/v4/projects/1/issues/2/award_emoji")
                .project("http://example.com/api/v4/projects/1")
                .closedAsDuplicateOf("http://example.com/api/v4/projects/1/issues/75")
                .build();
    }
}
