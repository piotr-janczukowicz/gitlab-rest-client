package io.github.piotr_janczukowicz.gitlab.api.deployments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDeploymentsDeploymentIdMergeRequests}, without
 * paging.
 *
 * @param authorId the author id
 * @param authorUsername the author username
 * @param assigneeId the assignee id
 * @param assigneeUsername the assignee username
 * @param reviewerUsername the reviewer username
 * @param labels the labels
 * @param milestone the milestone
 * @param myReactionEmoji the my reaction emoji
 * @param reviewerId the reviewer id
 * @param state the state
 * @param orderBy the order by
 * @param sort the sort
 * @param withLabelsDetails the with labels details
 * @param withMergeStatusRecheck the with merge status recheck
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param updatedAfter the updated after
 * @param updatedBefore the updated before
 * @param mergedAfter the merged after
 * @param mergedBefore the merged before
 * @param view the view
 * @param scope the scope
 * @param sourceBranch the source branch
 * @param sourceProjectId the source project id
 * @param targetBranch the target branch
 * @param search the search
 * @param inValue the in
 * @param wip the wip
 * @param draft the draft
 * @param notAuthorId the not author id
 * @param notAuthorUsername the not author username
 * @param notAssigneeId the not assignee id
 * @param notAssigneeUsername the not assignee username
 * @param notReviewerUsername the not reviewer username
 * @param notLabels the not labels
 * @param notMilestone the not milestone
 * @param notMyReactionEmoji the not my reaction emoji
 * @param notReviewerId the not reviewer id
 * @param deployedBefore the deployed before
 * @param deployedAfter the deployed after
 * @param environment the environment
 * @param mergeUserId the merge user id
 * @param mergeUserUsername the merge user username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDeploymentsDeploymentIdMergeRequests/parameters")
public record GitLabProjectDeploymentsListMergeRequestsFilter(
        @Nullable Long authorId,
        @Nullable String authorUsername,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String assigneeId,

        @Nullable List<String> assigneeUsername,
        @Nullable String reviewerUsername,
        @Nullable List<String> labels,
        @Nullable String milestone,
        @Nullable String myReactionEmoji,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String reviewerId,

        @Nullable GitLabProjectDeploymentsListMergeRequestsState state,
        @Nullable GitLabProjectDeploymentsListMergeRequestsOrderBy orderBy,
        @Nullable GitLabProjectDeploymentsListMergeRequestsSort sort,
        @Nullable Boolean withLabelsDetails,
        @Nullable Boolean withMergeStatusRecheck,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant updatedBefore,
        @Nullable Instant mergedAfter,
        @Nullable Instant mergedBefore,
        @Nullable GitLabProjectDeploymentsListMergeRequestsView view,
        @Nullable GitLabProjectDeploymentsListMergeRequestsScope scope,
        @Nullable String sourceBranch,
        @Nullable Long sourceProjectId,
        @Nullable String targetBranch,
        @Nullable String search,
        @Nullable @JsonProperty("in") String inValue,
        @Nullable GitLabProjectDeploymentsListMergeRequestsWip wip,
        @Nullable Boolean draft,
        @Nullable @JsonProperty("not[author_id]") Integer notAuthorId,
        @Nullable @JsonProperty("not[author_username]") String notAuthorUsername,

        @Nullable @JsonProperty("not[assignee_id]") @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String notAssigneeId,

        @Nullable @JsonProperty("not[assignee_username]") List<String> notAssigneeUsername,
        @Nullable @JsonProperty("not[reviewer_username]") String notReviewerUsername,
        @Nullable @JsonProperty("not[labels]") List<String> notLabels,
        @Nullable @JsonProperty("not[milestone]") String notMilestone,
        @Nullable @JsonProperty("not[my_reaction_emoji]") String notMyReactionEmoji,
        @Nullable @JsonProperty("not[reviewer_id]") Integer notReviewerId,
        @Nullable Instant deployedBefore,
        @Nullable Instant deployedAfter,
        @Nullable String environment,
        @Nullable Long mergeUserId,
        @Nullable String mergeUserUsername) {
    public GitLabProjectDeploymentsListMergeRequestsFilter {
        if (assigneeUsername != null) {
            assigneeUsername = List.copyOf(assigneeUsername);
        }
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (notAssigneeUsername != null) {
            notAssigneeUsername = List.copyOf(notAssigneeUsername);
        }
        if (notLabels != null) {
            notLabels = List.copyOf(notLabels);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectDeploymentsListMergeRequestsFilter empty() {
        return GitLabProjectDeploymentsListMergeRequestsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("author_id", authorId)
                .text("author_username", authorUsername)
                .text("assignee_id", assigneeId)
                .list("assignee_username", assigneeUsername)
                .text("reviewer_username", reviewerUsername)
                .list("labels", labels)
                .text("milestone", milestone)
                .text("my_reaction_emoji", myReactionEmoji)
                .text("reviewer_id", reviewerId)
                .wire("state", state, GitLabProjectDeploymentsListMergeRequestsState::wireValue)
                .wire("order_by", orderBy, GitLabProjectDeploymentsListMergeRequestsOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectDeploymentsListMergeRequestsSort::wireValue)
                .value("with_labels_details", withLabelsDetails)
                .value("with_merge_status_recheck", withMergeStatusRecheck)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .value("updated_after", updatedAfter)
                .value("updated_before", updatedBefore)
                .value("merged_after", mergedAfter)
                .value("merged_before", mergedBefore)
                .wire("view", view, GitLabProjectDeploymentsListMergeRequestsView::wireValue)
                .wire("scope", scope, GitLabProjectDeploymentsListMergeRequestsScope::wireValue)
                .text("source_branch", sourceBranch)
                .value("source_project_id", sourceProjectId)
                .text("target_branch", targetBranch)
                .text("search", search)
                .text("in", inValue)
                .wire("wip", wip, GitLabProjectDeploymentsListMergeRequestsWip::wireValue)
                .value("draft", draft)
                .value("not[author_id]", notAuthorId)
                .text("not[author_username]", notAuthorUsername)
                .text("not[assignee_id]", notAssigneeId)
                .list("not[assignee_username]", notAssigneeUsername)
                .text("not[reviewer_username]", notReviewerUsername)
                .list("not[labels]", notLabels)
                .text("not[milestone]", notMilestone)
                .text("not[my_reaction_emoji]", notMyReactionEmoji)
                .value("not[reviewer_id]", notReviewerId)
                .value("deployed_before", deployedBefore)
                .value("deployed_after", deployedAfter)
                .text("environment", environment)
                .value("merge_user_id", mergeUserId)
                .text("merge_user_username", mergeUserUsername)
                .build();
    }
}
