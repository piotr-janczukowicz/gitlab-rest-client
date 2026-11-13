package io.github.piotr_janczukowicz.gitlab.api.markdownuploads;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project upload.
 *
 * @param id the id
 * @param alt the alt
 * @param url the url
 * @param fullPath the full path
 * @param markdown the markdown
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectUpload")
public record GitLabProjectUpload(
        @Nullable Long id,
        @Nullable String alt,
        @Nullable String url,
        @Nullable String fullPath,
        @Nullable String markdown) {}
