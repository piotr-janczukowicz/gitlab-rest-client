package io.github.piotr_janczukowicz.gitlab.api.epics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdDashEpicsEpicIid}.
 *
 * @param title the title
 * @param color the color
 * @param description the description
 * @param confidential the confidential
 * @param updatedAt the updated at
 * @param startDate the start date
 * @param startDateFixed the start date fixed
 * @param startDateIsFixed the start date is fixed
 * @param endDate the end date
 * @param dueDateFixed the due date fixed
 * @param dueDateIsFixed the due date is fixed
 * @param labels the labels
 * @param addLabels the add labels
 * @param removeLabels the remove labels
 * @param stateEvent the state event
 * @param parentId the parent id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdDashEpicsEpicIid/requestBody")
public record GitLabGroupEpicsUpdatePayload(
        @Nullable String title,
        @Nullable String color,
        @Nullable String description,
        @Nullable Boolean confidential,
        @Nullable Instant updatedAt,
        @Nullable String startDate,
        @Nullable String startDateFixed,
        @Nullable Boolean startDateIsFixed,
        @Nullable String endDate,
        @Nullable String dueDateFixed,
        @Nullable Boolean dueDateIsFixed,
        @Nullable List<String> labels,
        @Nullable List<String> addLabels,
        @Nullable List<String> removeLabels,
        @Nullable GitLabGroupEpicsUpdateStateEvent stateEvent,
        @Nullable Long parentId) {
    public GitLabGroupEpicsUpdatePayload {
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (addLabels != null) {
            addLabels = List.copyOf(addLabels);
        }
        if (removeLabels != null) {
            removeLabels = List.copyOf(removeLabels);
        }
    }
}
