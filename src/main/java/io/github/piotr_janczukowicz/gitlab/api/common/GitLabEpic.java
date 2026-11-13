package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab epic.
 *
 * @param id the id
 * @param workItemId the work item id
 * @param iid the iid
 * @param color the color
 * @param textColor the text color
 * @param groupId the group id
 * @param parentId the parent id
 * @param parentIid the parent iid
 * @param imported the imported
 * @param importedFrom the imported from
 * @param title the title
 * @param description the description
 * @param confidential the confidential
 * @param author the author
 * @param startDate the start date
 * @param startDateIsFixed the start date is fixed
 * @param startDateFixed the start date fixed
 * @param startDateFromInheritedSource the start date from inherited source
 * @param startDateFromMilestones the start date from milestones
 * @param endDate the end date
 * @param dueDate the due date
 * @param dueDateIsFixed the due date is fixed
 * @param dueDateFixed the due date fixed
 * @param dueDateFromInheritedSource the due date from inherited source
 * @param dueDateFromMilestones the due date from milestones
 * @param state the state
 * @param webEditUrl the web edit url
 * @param webUrl the web url
 * @param references the references
 * @param reference the reference
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param closedAt the closed at
 * @param labels the labels
 * @param upvotes the upvotes
 * @param downvotes the downvotes
 * @param subscribed the subscribed
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEpic")
public record GitLabEpic(
        @Nullable Long id,
        @Nullable Long workItemId,
        @Nullable Long iid,
        @Nullable String color,
        @Nullable String textColor,
        @Nullable Long groupId,
        @Nullable Long parentId,
        @Nullable Long parentIid,
        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable String title,
        @Nullable String description,
        @Nullable Boolean confidential,
        @Nullable GitLabUserBasic author,
        @Nullable LocalDate startDate,
        @Nullable Boolean startDateIsFixed,
        @Nullable LocalDate startDateFixed,
        @Nullable Instant startDateFromInheritedSource,
        @Nullable Instant startDateFromMilestones,
        @Nullable LocalDate endDate,
        @Nullable LocalDate dueDate,
        @Nullable Boolean dueDateIsFixed,
        @Nullable LocalDate dueDateFixed,
        @Nullable Instant dueDateFromInheritedSource,
        @Nullable Instant dueDateFromMilestones,
        @Nullable String state,
        @Nullable String webEditUrl,
        @Nullable String webUrl,
        @Nullable GitLabIssuableReferences references,
        @Nullable String reference,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Instant closedAt,
        @Nullable List<String> labels,
        @Nullable Integer upvotes,
        @Nullable Integer downvotes,
        @Nullable Boolean subscribed,
        @Nullable @JsonProperty("_links") GitLabEpicLinks links) {}
