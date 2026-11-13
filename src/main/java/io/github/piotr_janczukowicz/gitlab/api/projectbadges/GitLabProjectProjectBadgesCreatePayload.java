package io.github.piotr_janczukowicz.gitlab.api.projectbadges;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdBadges}.
 *
 * @param linkUrl the link url
 * @param imageUrl the image url
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdBadges/requestBody")
public record GitLabProjectProjectBadgesCreatePayload(
        @Nullable String linkUrl,
        @Nullable String imageUrl,
        @Nullable String name) {}
