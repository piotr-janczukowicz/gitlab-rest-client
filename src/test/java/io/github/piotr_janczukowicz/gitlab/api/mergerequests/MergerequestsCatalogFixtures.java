package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class MergerequestsCatalogFixtures {

    private MergerequestsCatalogFixtures() {}

    public static GitLabAiSuggestedReviewer aiSuggestedReviewer() {
        return GitLabAiSuggestedReviewerBuilder.builder()
                .user(CommonCatalogFixtures.userBasic())
                .reason("Authored most of the changed files.")
                .approvalRule(Map.of("key", "value"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabMergeRequestApprovalState mergeRequestApprovalState() {
        return GitLabMergeRequestApprovalStateBuilder.builder()
                .approvalRulesOverwritten(true)
                .rules(List.of(MergerequestsCatalogFixtures.mergeRequestApprovalStateRule()))
                .build();
    }

    public static GitLabMergeRequestApprovalStateRule mergeRequestApprovalStateRule() {
        return GitLabMergeRequestApprovalStateRuleBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .eligibleApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvalsRequired(1)
                .users(List.of(CommonCatalogFixtures.userBasic()))
                .groups(List.of(CommonCatalogFixtures.group()))
                .containsHiddenGroups(true)
                .reportType("report_type")
                .section("Backend")
                .sourceRule(CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule())
                .overridden(true)
                .codeOwner(true)
                .approvedBy(List.of(CommonCatalogFixtures.userBasic()))
                .approved(true)
                .build();
    }

    public static GitLabMergeRequestChanges mergeRequestChanges() {
        return GitLabMergeRequestChangesBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBy(CommonCatalogFixtures.userBasic())
                .mergeUser(CommonCatalogFixtures.userBasic())
                .mergedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .titleHtml("title_html")
                .descriptionHtml("description_html")
                .targetBranch("target_branch")
                .sourceBranch("source_branch")
                .userNotesCount(1)
                .upvotes(1)
                .downvotes(1)
                .author(CommonCatalogFixtures.mergeRequestAuthor())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .assignee(CommonCatalogFixtures.userBasic())
                .reviewers(List.of(CommonCatalogFixtures.userBasic()))
                .sourceProjectId(1L)
                .targetProjectId(1L)
                .labels(List.of("labels"))
                .draft(true)
                .imported(true)
                .importedFrom("bitbucket")
                .workInProgress(true)
                .milestone(CommonCatalogFixtures.milestone())
                .mergeWhenPipelineSucceeds(true)
                .mergeStatus("unchecked")
                .detailedMergeStatus("mergeable")
                .mergeAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .sha("1234abcd")
                .mergeCommitSha("1234abcd")
                .squashCommitSha("1234abcd")
                .discussionLocked(true)
                .shouldRemoveSourceBranch(true)
                .forceRemoveSourceBranch(true)
                .preparedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .allowCollaboration(true)
                .allowMaintainerToPush(true)
                .reference("!1")
                .references(CommonCatalogFixtures.issuableReferences())
                .webUrl("https://gitlab.example.com/my-group/my-project/-/merge_requests/1")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .squash(true)
                .squashOnMerge(true)
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .hasConflicts(true)
                .blockingDiscussionsResolved(true)
                .approvalsBeforeMerge(1)
                .subscribed(true)
                .changesCount("1")
                .latestBuildStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .latestBuildFinishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .firstDeployedToProductionAt(Instant.parse("2026-01-01T00:00:00Z"))
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .headPipeline(CommonCatalogFixtures.ciPipeline())
                .diffRefs(CommonCatalogFixtures.diffRefs())
                .mergeError("Merge error")
                .rebaseInProgress(true)
                .divergedCommitsCount(1)
                .firstContribution(true)
                .user(MergerequestsCatalogFixtures.mergeRequestChangesUser())
                .changes(List.of(CommonCatalogFixtures.diff()))
                .overflow(true)
                .build();
    }

    public static GitLabMergeRequestChangesUser mergeRequestChangesUser() {
        return GitLabMergeRequestChangesUserBuilder.builder().canMerge(true).build();
    }

    public static GitLabMergeRequestDependency mergeRequestDependency() {
        return GitLabMergeRequestDependencyBuilder.builder()
                .id(1L)
                .blockingMergeRequest(CommonCatalogFixtures.mergeRequestBasic())
                .blockedMergeRequest(CommonCatalogFixtures.mergeRequestBasic())
                .projectId(1L)
                .build();
    }

    public static GitLabMergeRequestDiff mergeRequestDiff() {
        return GitLabMergeRequestDiffBuilder.builder()
                .id(1L)
                .headCommitSha("1234abcd")
                .baseCommitSha("1234abcd")
                .startCommitSha("1234abcd")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestId(1L)
                .state("collected")
                .realSize("1")
                .patchIdSha("1234abcd")
                .build();
    }

    public static GitLabMergeRequestDiffFull mergeRequestDiffFull() {
        return GitLabMergeRequestDiffFullBuilder.builder()
                .id(1L)
                .headCommitSha("1234abcd")
                .baseCommitSha("1234abcd")
                .startCommitSha("1234abcd")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestId(1L)
                .state("collected")
                .realSize("1")
                .patchIdSha("1234abcd")
                .commits(List.of(CommonCatalogFixtures.commit()))
                .diffs(List.of(CommonCatalogFixtures.diff()))
                .build();
    }

    public static GitLabMergeRequestReviewer mergeRequestReviewer() {
        return GitLabMergeRequestReviewerBuilder.builder()
                .user(CommonCatalogFixtures.userBasic())
                .state("unreviewed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabMergeRequestsStatusCheckResponse mergeRequestsStatusCheckResponse() {
        return GitLabMergeRequestsStatusCheckResponseBuilder.builder()
                .id(1L)
                .mergeRequest(CommonCatalogFixtures.mergeRequest())
                .externalStatusCheck(MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck())
                .build();
    }

    public static GitLabMergeRequestsStatusCheckResponseExternalStatusCheck
            mergeRequestsStatusCheckResponseExternalStatusCheck() {
        return GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder.builder()
                .id(1L)
                .name("QA")
                .externalUrl("https://www.example.com")
                .build();
    }

    public static GitLabProjectMergeRequestsAddSpentTimePayload projectMergeRequestsAddSpentTimePayload() {
        return GitLabProjectMergeRequestsAddSpentTimePayloadBuilder.builder()
                .duration("duration")
                .build();
    }

    public static GitLabProjectMergeRequestsApprovePayload projectMergeRequestsApprovePayload() {
        return GitLabProjectMergeRequestsApprovePayloadBuilder.builder()
                .sha("sha")
                .publishReview(true)
                .approvalPassword("secret")
                .build();
    }

    public static GitLabProjectMergeRequestsCreateBlockPayload projectMergeRequestsCreateBlockPayload() {
        return GitLabProjectMergeRequestsCreateBlockPayloadBuilder.builder()
                .blockingMergeRequestId(1L)
                .blockingMergeRequestIid(1L)
                .blockingProjectId("text")
                .build();
    }

    public static GitLabProjectMergeRequestsCreatePayload projectMergeRequestsCreatePayload() {
        return GitLabProjectMergeRequestsCreatePayloadBuilder.builder()
                .title("title")
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .targetProjectId(1L)
                .assigneeId(1L)
                .assigneeIds(List.of(1L))
                .reviewerIds(List.of(1L))
                .description("description")
                .labels(List.of("labels"))
                .addLabels(List.of("add_labels"))
                .removeLabels(List.of("remove_labels"))
                .milestoneId(1L)
                .milestone("milestone")
                .removeSourceBranch(true)
                .allowCollaboration(true)
                .allowMaintainerToPush(true)
                .squash(true)
                .mergeAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .approvalsBeforeMerge(1)
                .build();
    }

    public static GitLabProjectMergeRequestsCreatePipelinePayload projectMergeRequestsCreatePipelinePayload() {
        return GitLabProjectMergeRequestsCreatePipelinePayloadBuilder.builder()
                .asyncValue(true)
                .build();
    }

    public static GitLabProjectMergeRequestsCreateStatusCheckResponsePayload
            projectMergeRequestsCreateStatusCheckResponsePayload() {
        return GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder.builder()
                .externalStatusCheckId(1L)
                .sha("5957a570eee0ac4580ec027fb874ad7514d1e576")
                .status(GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.PASSED)
                .build();
    }

    public static GitLabProjectMergeRequestsMergePayload projectMergeRequestsMergePayload() {
        return GitLabProjectMergeRequestsMergePayloadBuilder.builder()
                .mergeCommitMessage("merge_commit_message")
                .squashCommitMessage("squash_commit_message")
                .shouldRemoveSourceBranch(true)
                .mergeWhenPipelineSucceeds(true)
                .autoMerge(true)
                .sha("sha")
                .squash(true)
                .skipMergeTrain(true)
                .build();
    }

    public static GitLabProjectMergeRequestsRebasePayload projectMergeRequestsRebasePayload() {
        return GitLabProjectMergeRequestsRebasePayloadBuilder.builder()
                .skipCi(true)
                .build();
    }

    public static GitLabProjectMergeRequestsTimeEstimatePayload projectMergeRequestsTimeEstimatePayload() {
        return GitLabProjectMergeRequestsTimeEstimatePayloadBuilder.builder()
                .duration("3h30m")
                .build();
    }

    public static GitLabProjectMergeRequestsUpdatePayload projectMergeRequestsUpdatePayload() {
        return GitLabProjectMergeRequestsUpdatePayloadBuilder.builder()
                .title("title")
                .targetBranch("target_branch")
                .stateEvent(GitLabProjectMergeRequestsUpdateStateEvent.CLOSE)
                .discussionLocked(true)
                .assigneeId(1L)
                .assigneeIds(List.of(1L))
                .reviewerIds(List.of(1L))
                .description("description")
                .labels(List.of("labels"))
                .addLabels(List.of("add_labels"))
                .removeLabels(List.of("remove_labels"))
                .milestoneId(1L)
                .milestone("milestone")
                .removeSourceBranch(true)
                .allowCollaboration(true)
                .allowMaintainerToPush(true)
                .squash(true)
                .mergeAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .approvalsBeforeMerge(1)
                .build();
    }

    public static GitLabProjectSuggestedReviewerCreatePayload projectSuggestedReviewerCreatePayload() {
        return GitLabProjectSuggestedReviewerCreatePayloadBuilder.builder()
                .suggestions(List.of(MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion()))
                .build();
    }

    public static GitLabProjectSuggestedReviewerCreateSuggestion projectSuggestedReviewerCreateSuggestion() {
        return GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder()
                .userId(1L)
                .reason("reason")
                .approvalRuleId(1L)
                .approvalRuleType(GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.MERGE_REQUEST_RULE)
                .build();
    }
}
