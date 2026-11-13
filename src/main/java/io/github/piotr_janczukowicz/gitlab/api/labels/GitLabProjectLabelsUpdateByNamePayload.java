package io.github.piotr_janczukowicz.gitlab.api.labels;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdLabelsName}.
 *
 * @param newName the new name
 * @param color the color
 * @param description the description
 * @param archived the archived
 * @param priority the priority
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdLabelsName/requestBody")
public record GitLabProjectLabelsUpdateByNamePayload(
        @Nullable String newName,
        @Nullable String color,
        @Nullable String description,
        @Nullable Boolean archived,
        @Nullable Integer priority) {}
