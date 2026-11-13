package io.github.piotr_janczukowicz.gitlab.api.tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryTags}.
 *
 * @param tagName the tag name
 * @param ref the ref
 * @param message the message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryTags/requestBody")
public record GitLabProjectTagsCreatePayload(
        @Nullable String tagName,
        @Nullable String ref,
        @Nullable String message) {}
