package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMilestones}.
 *
 * @param title the title
 * @param description the description
 * @param dueDate the due date
 * @param startDate the start date
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMilestones/requestBody")
public record GitLabProjectProjectMilestonesCreatePayload(
        @Nullable String title,
        @Nullable String description,
        @Nullable String dueDate,
        @Nullable String startDate) {}
