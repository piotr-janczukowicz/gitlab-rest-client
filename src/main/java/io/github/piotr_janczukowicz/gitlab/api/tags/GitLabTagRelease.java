package io.github.piotr_janczukowicz.gitlab.api.tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab tag release.
 *
 * @param tagName the tag name
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTagRelease")
public record GitLabTagRelease(
        @Nullable String tagName, @Nullable String description) {}
