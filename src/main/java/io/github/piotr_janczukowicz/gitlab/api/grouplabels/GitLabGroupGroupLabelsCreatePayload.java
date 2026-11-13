package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdLabels}.
 *
 * @param name the name
 * @param color the color
 * @param description the description
 * @param archived the archived
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdLabels/requestBody")
public record GitLabGroupGroupLabelsCreatePayload(
        @Nullable String name,
        @Nullable String color,
        @Nullable String description,
        @Nullable Boolean archived) {}
