package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param mergedBy the merged by
 * @param mergeUser the merge user
 * @param mergedAt the merged at
 * @param closedBy the closed by
 * @param closedAt the closed at
 * @param titleHtml the title html
 * @param descriptionHtml the description html
 * @param targetBranch the target branch
 * @param sourceBranch the source branch
 * @param userNotesCount the user notes count
 * @param upvotes the upvotes
 * @param downvotes the downvotes
 * @param author the author
 * @param assignees the assignees
 * @param assignee the assignee
 * @param reviewers the reviewers
 * @param sourceProjectId the source project id
 * @param targetProjectId the target project id
 * @param labels the labels
 * @param draft the draft
 * @param imported the imported
 * @param importedFrom the imported from
 * @param workInProgress the work in progress
 * @param milestone the milestone
 * @param mergeWhenPipelineSucceeds the merge when pipeline succeeds
 * @param mergeStatus the merge status
 * @param detailedMergeStatus the detailed merge status
 * @param mergeAfter the merge after
 * @param sha the sha
 * @param mergeCommitSha the merge commit sha
 * @param squashCommitSha the squash commit sha
 * @param discussionLocked the discussion locked
 * @param shouldRemoveSourceBranch the should remove source branch
 * @param forceRemoveSourceBranch the force remove source branch
 * @param preparedAt the prepared at
 * @param allowCollaboration the allow collaboration
 * @param allowMaintainerToPush the allow maintainer to push
 * @param reference the reference
 * @param references the references
 * @param webUrl the web url
 * @param timeStats the time stats
 * @param squash the squash
 * @param squashOnMerge the squash on merge
 * @param taskCompletionStatus the task completion status
 * @param hasConflicts the has conflicts
 * @param blockingDiscussionsResolved the blocking discussions resolved
 * @param approvalsBeforeMerge the approvals before merge
 * @param subscribed the subscribed
 * @param changesCount the changes count
 * @param latestBuildStartedAt the latest build started at
 * @param latestBuildFinishedAt the latest build finished at
 * @param firstDeployedToProductionAt the first deployed to production at
 * @param pipeline the pipeline
 * @param headPipeline the head pipeline
 * @param diffRefs the diff refs
 * @param mergeError the merge error
 * @param rebaseInProgress the rebase in progress
 * @param divergedCommitsCount the diverged commits count
 * @param firstContribution the first contribution
 * @param user the user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequest")
public record GitLabMergeRequest(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable GitLabUserBasic mergedBy,
        @Nullable GitLabUserBasic mergeUser,
        @Nullable Instant mergedAt,
        @Nullable GitLabUserBasic closedBy,
        @Nullable Instant closedAt,
        @Nullable String titleHtml,
        @Nullable String descriptionHtml,
        @Nullable String targetBranch,
        @Nullable String sourceBranch,
        @Nullable Integer userNotesCount,
        @Nullable Integer upvotes,
        @Nullable Integer downvotes,
        @Nullable GitLabMergeRequestAuthor author,
        @Nullable List<GitLabUserBasic> assignees,
        @Nullable GitLabUserBasic assignee,
        @Nullable List<GitLabUserBasic> reviewers,
        @Nullable Long sourceProjectId,
        @Nullable Long targetProjectId,
        @Nullable List<String> labels,
        @Nullable Boolean draft,
        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable Boolean workInProgress,
        @Nullable GitLabMilestone milestone,
        @Nullable Boolean mergeWhenPipelineSucceeds,
        @Nullable String mergeStatus,
        @Nullable String detailedMergeStatus,
        @Nullable Instant mergeAfter,
        @Nullable String sha,
        @Nullable String mergeCommitSha,
        @Nullable String squashCommitSha,
        @Nullable Boolean discussionLocked,
        @Nullable Boolean shouldRemoveSourceBranch,
        @Nullable Boolean forceRemoveSourceBranch,
        @Nullable Instant preparedAt,
        @Nullable Boolean allowCollaboration,
        @Nullable Boolean allowMaintainerToPush,
        @Nullable String reference,
        @Nullable GitLabIssuableReferences references,
        @Nullable String webUrl,
        @Nullable GitLabIssuableTimeStats timeStats,
        @Nullable Boolean squash,
        @Nullable Boolean squashOnMerge,
        @Nullable GitLabTaskCompletionStatus taskCompletionStatus,
        @Nullable Boolean hasConflicts,
        @Nullable Boolean blockingDiscussionsResolved,
        @Nullable Integer approvalsBeforeMerge,
        @Nullable Boolean subscribed,
        @Nullable String changesCount,
        @Nullable Instant latestBuildStartedAt,
        @Nullable Instant latestBuildFinishedAt,
        @Nullable Instant firstDeployedToProductionAt,
        @Nullable GitLabCiPipelineBasic pipeline,
        @Nullable GitLabCiPipeline headPipeline,
        @Nullable GitLabDiffRefs diffRefs,
        @Nullable String mergeError,
        @Nullable Boolean rebaseInProgress,
        @Nullable Integer divergedCommitsCount,
        @Nullable Boolean firstContribution,
        @Nullable GitLabMergeRequestUser user) {}
