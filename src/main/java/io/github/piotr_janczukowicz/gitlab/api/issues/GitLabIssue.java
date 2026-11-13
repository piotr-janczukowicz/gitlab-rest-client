package io.github.piotr_janczukowicz.gitlab.api.issues;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicBaseEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableReferences;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssuableTimeStats;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIteration;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMilestone;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTaskCompletionStatus;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab issue.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param closedAt the closed at
 * @param closedBy the closed by
 * @param labels the labels
 * @param milestone the milestone
 * @param assignees the assignees
 * @param author the author
 * @param type the type
 * @param assignee the assignee
 * @param userNotesCount the user notes count
 * @param mergeRequestsCount the merge requests count
 * @param upvotes the upvotes
 * @param downvotes the downvotes
 * @param startDate the start date
 * @param dueDate the due date
 * @param confidential the confidential
 * @param discussionLocked the discussion locked
 * @param issueType the issue type
 * @param webUrl the web url
 * @param timeStats the time stats
 * @param taskCompletionStatus the task completion status
 * @param weight the weight
 * @param blockingIssuesCount the blocking issues count
 * @param hasTasks the has tasks
 * @param taskStatus the task status
 * @param links the links
 * @param references the references
 * @param severity the severity
 * @param subscribed the subscribed
 * @param movedToId the moved to id
 * @param imported the imported
 * @param importedFrom the imported from
 * @param serviceDeskReplyTo the service desk reply to
 * @param epicIid the epic iid
 * @param epic the epic
 * @param iteration the iteration
 * @param healthStatus the health status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIssue")
public record GitLabIssue(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Instant closedAt,
        @Nullable GitLabUserBasic closedBy,
        @Nullable List<String> labels,
        @Nullable GitLabMilestone milestone,
        @Nullable List<GitLabUserBasic> assignees,
        @Nullable GitLabUserBasic author,
        @Nullable GitLabIssueType type,
        @Nullable GitLabUserBasic assignee,
        @Nullable Integer userNotesCount,
        @Nullable Integer mergeRequestsCount,
        @Nullable Integer upvotes,
        @Nullable Integer downvotes,
        @Nullable LocalDate startDate,
        @Nullable LocalDate dueDate,
        @Nullable Boolean confidential,
        @Nullable Boolean discussionLocked,
        @Nullable String issueType,
        @Nullable String webUrl,
        @Nullable GitLabIssuableTimeStats timeStats,
        @Nullable GitLabTaskCompletionStatus taskCompletionStatus,
        @Nullable Integer weight,
        @Nullable Integer blockingIssuesCount,
        @Nullable Boolean hasTasks,
        @Nullable String taskStatus,
        @Nullable @JsonProperty("_links") GitLabIssueLinks links,
        @Nullable GitLabIssuableReferences references,
        @Nullable GitLabIssueSeverity severity,
        @Nullable Boolean subscribed,
        @Nullable Long movedToId,
        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable String serviceDeskReplyTo,
        @Nullable Long epicIid,
        @Nullable GitLabEpicBaseEntity epic,
        @Nullable GitLabIteration iteration,
        @Nullable String healthStatus) {}
