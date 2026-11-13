package io.github.piotr_janczukowicz.gitlab.api.issues;

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
 * Optional query parameters of the operation {@code getApiV4GroupsIdIssues}, without paging.
 *
 * @param withLabelsDetails the with labels details
 * @param state the state
 * @param closedById the closed by id
 * @param orderBy the order by
 * @param sort the sort
 * @param dueDate the due date
 * @param issueType the issue type
 * @param labels the labels
 * @param milestone the milestone
 * @param milestoneId the milestone id
 * @param iids the iids
 * @param search the search
 * @param inValue the in
 * @param authorId the author id
 * @param authorUsername the author username
 * @param assigneeId the assignee id
 * @param assigneeUsername the assignee username
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param updatedAfter the updated after
 * @param updatedBefore the updated before
 * @param notLabels the not labels
 * @param notMilestone the not milestone
 * @param notMilestoneId the not milestone id
 * @param notIids the not iids
 * @param notAuthorId the not author id
 * @param notAuthorUsername the not author username
 * @param notAssigneeId the not assignee id
 * @param notAssigneeUsername the not assignee username
 * @param notWeight the not weight
 * @param notIterationId the not iteration id
 * @param notIterationTitle the not iteration title
 * @param scope the scope
 * @param myReactionEmoji the my reaction emoji
 * @param confidential the confidential
 * @param weight the weight
 * @param epicId the epic id
 * @param healthStatus the health status
 * @param iterationId the iteration id
 * @param iterationTitle the iteration title
 * @param nonArchived the non archived
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdIssues/parameters")
public record GitLabGroupIssuesListFilter(
        @Nullable Boolean withLabelsDetails,
        @Nullable GitLabGroupIssuesListState state,
        @Nullable Long closedById,
        @Nullable GitLabGroupIssuesListOrderBy orderBy,
        @Nullable GitLabGroupIssuesListSort sort,
        @Nullable GitLabGroupIssuesListDueDate dueDate,
        @Nullable GitLabGroupIssuesListIssueType issueType,
        @Nullable List<String> labels,
        @Nullable String milestone,
        @Nullable GitLabGroupIssuesListMilestoneId milestoneId,
        @Nullable List<Integer> iids,
        @Nullable String search,
        @Nullable @JsonProperty("in") String inValue,
        @Nullable Long authorId,
        @Nullable String authorUsername,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String assigneeId,

        @Nullable List<String> assigneeUsername,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant updatedBefore,
        @Nullable @JsonProperty("not[labels]") List<String> notLabels,
        @Nullable @JsonProperty("not[milestone]") String notMilestone,
        @Nullable @JsonProperty("not[milestone_id]") GitLabGroupIssuesListNotMilestoneId notMilestoneId,
        @Nullable @JsonProperty("not[iids]") List<Integer> notIids,
        @Nullable @JsonProperty("not[author_id]") Integer notAuthorId,
        @Nullable @JsonProperty("not[author_username]") String notAuthorUsername,
        @Nullable @JsonProperty("not[assignee_id]") Integer notAssigneeId,
        @Nullable @JsonProperty("not[assignee_username]") List<String> notAssigneeUsername,
        @Nullable @JsonProperty("not[weight]") Integer notWeight,

        @Nullable @JsonProperty("not[iteration_id]") @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String notIterationId,

        @Nullable @JsonProperty("not[iteration_title]") String notIterationTitle,
        @Nullable GitLabGroupIssuesListScope scope,
        @Nullable String myReactionEmoji,
        @Nullable Boolean confidential,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String weight,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String epicId,

        @Nullable GitLabGroupIssuesListHealthStatus healthStatus,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String iterationId,

        @Nullable String iterationTitle,
        @Nullable Boolean nonArchived) {
    public GitLabGroupIssuesListFilter {
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (iids != null) {
            iids = List.copyOf(iids);
        }
        if (assigneeUsername != null) {
            assigneeUsername = List.copyOf(assigneeUsername);
        }
        if (notLabels != null) {
            notLabels = List.copyOf(notLabels);
        }
        if (notIids != null) {
            notIids = List.copyOf(notIids);
        }
        if (notAssigneeUsername != null) {
            notAssigneeUsername = List.copyOf(notAssigneeUsername);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupIssuesListFilter empty() {
        return GitLabGroupIssuesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("with_labels_details", withLabelsDetails)
                .wire("state", state, GitLabGroupIssuesListState::wireValue)
                .value("closed_by_id", closedById)
                .wire("order_by", orderBy, GitLabGroupIssuesListOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupIssuesListSort::wireValue)
                .wire("due_date", dueDate, GitLabGroupIssuesListDueDate::wireValue)
                .wire("issue_type", issueType, GitLabGroupIssuesListIssueType::wireValue)
                .list("labels", labels)
                .text("milestone", milestone)
                .wire("milestone_id", milestoneId, GitLabGroupIssuesListMilestoneId::wireValue)
                .list("iids", iids)
                .text("search", search)
                .text("in", inValue)
                .value("author_id", authorId)
                .text("author_username", authorUsername)
                .text("assignee_id", assigneeId)
                .list("assignee_username", assigneeUsername)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .value("updated_after", updatedAfter)
                .value("updated_before", updatedBefore)
                .list("not[labels]", notLabels)
                .text("not[milestone]", notMilestone)
                .wire("not[milestone_id]", notMilestoneId, GitLabGroupIssuesListNotMilestoneId::wireValue)
                .list("not[iids]", notIids)
                .value("not[author_id]", notAuthorId)
                .text("not[author_username]", notAuthorUsername)
                .value("not[assignee_id]", notAssigneeId)
                .list("not[assignee_username]", notAssigneeUsername)
                .value("not[weight]", notWeight)
                .text("not[iteration_id]", notIterationId)
                .text("not[iteration_title]", notIterationTitle)
                .wire("scope", scope, GitLabGroupIssuesListScope::wireValue)
                .text("my_reaction_emoji", myReactionEmoji)
                .value("confidential", confidential)
                .text("weight", weight)
                .text("epic_id", epicId)
                .wire("health_status", healthStatus, GitLabGroupIssuesListHealthStatus::wireValue)
                .text("iteration_id", iterationId)
                .text("iteration_title", iterationTitle)
                .value("non_archived", nonArchived)
                .build();
    }
}
