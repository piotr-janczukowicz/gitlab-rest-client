package io.github.piotr_janczukowicz.gitlab.api.epics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdDashEpics}.
 *
 * @param title the title
 * @param description the description
 * @param color the color
 * @param confidential the confidential
 * @param createdAt the created at
 * @param startDate the start date
 * @param startDateFixed the start date fixed
 * @param startDateIsFixed the start date is fixed
 * @param endDate the end date
 * @param dueDateFixed the due date fixed
 * @param dueDateIsFixed the due date is fixed
 * @param labels the labels
 * @param parentId the parent id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdDashEpics/requestBody")
public record GitLabGroupEpicsCreatePayload(
        @Nullable String title,
        @Nullable String description,
        @Nullable String color,
        @Nullable Boolean confidential,
        @Nullable Instant createdAt,
        @Nullable String startDate,
        @Nullable String startDateFixed,
        @Nullable Boolean startDateIsFixed,
        @Nullable String endDate,
        @Nullable String dueDateFixed,
        @Nullable Boolean dueDateIsFixed,
        @Nullable List<String> labels,
        @Nullable Long parentId) {
    public GitLabGroupEpicsCreatePayload {
        if (labels != null) {
            labels = List.copyOf(labels);
        }
    }
}
