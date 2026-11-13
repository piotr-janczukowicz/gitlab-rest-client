package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab label basic.
 *
 * @param id the id
 * @param name the name
 * @param description the description
 * @param textColor the text color
 * @param descriptionHtml the description html
 * @param color the color
 * @param archived the archived
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesLabelBasic")
public record GitLabLabelBasic(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String description,
        @Nullable String textColor,
        @Nullable String descriptionHtml,
        @Nullable String color,
        @Nullable Boolean archived) {}
