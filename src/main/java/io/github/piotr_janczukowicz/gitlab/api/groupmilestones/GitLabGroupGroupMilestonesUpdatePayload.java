package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdMilestonesMilestoneId}.
 *
 * @param title the title
 * @param stateEvent the state event
 * @param description the description
 * @param dueDate the due date
 * @param startDate the start date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdMilestonesMilestoneId/requestBody")
public record GitLabGroupGroupMilestonesUpdatePayload(
        @Nullable String title,
        @Nullable GitLabGroupGroupMilestonesUpdateStateEvent stateEvent,
        @Nullable String description,
        @Nullable String dueDate,
        @Nullable String startDate) {}
