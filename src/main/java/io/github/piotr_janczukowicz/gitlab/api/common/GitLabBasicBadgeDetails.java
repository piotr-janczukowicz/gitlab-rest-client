package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab basic badge details.
 *
 * @param name the name
 * @param linkUrl the link url
 * @param imageUrl the image url
 * @param renderedLinkUrl the rendered link url
 * @param renderedImageUrl the rendered image url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBasicBadgeDetails")
public record GitLabBasicBadgeDetails(
        @Nullable String name,
        @Nullable String linkUrl,
        @Nullable String imageUrl,
        @Nullable String renderedLinkUrl,
        @Nullable String renderedImageUrl) {}
