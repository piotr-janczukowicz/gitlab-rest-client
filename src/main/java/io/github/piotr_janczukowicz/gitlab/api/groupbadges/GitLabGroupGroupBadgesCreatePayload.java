package io.github.piotr_janczukowicz.gitlab.api.groupbadges;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdBadges}.
 *
 * @param linkUrl the link url
 * @param imageUrl the image url
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdBadges/requestBody")
public record GitLabGroupGroupBadgesCreatePayload(
        @Nullable String linkUrl,
        @Nullable String imageUrl,
        @Nullable String name) {}
