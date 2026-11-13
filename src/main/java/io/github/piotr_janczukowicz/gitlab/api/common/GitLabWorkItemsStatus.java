package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab work items status.
 *
 * @param id the id
 * @param name the name
 * @param iconName the icon name
 * @param color the color
 * @param position the position
 * @param description the description
 * @param category the category
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesWorkItemsStatus")
public record GitLabWorkItemsStatus(
        @Nullable Long id,
        @Nullable String name,
        @Nullable GitLabWorkItemsStatusIconName iconName,
        @Nullable String color,
        @Nullable Integer position,
        @Nullable String description,
        @Nullable GitLabWorkItemsStatusCategory category) {}
