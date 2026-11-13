package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab batch blob.
 *
 * @param path the path
 * @param ref the ref
 * @param size the size
 * @param truncated the truncated
 * @param encoding the encoding
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBatchBlob")
public record GitLabBatchBlob(
        @Nullable String path,
        @Nullable String ref,
        @Nullable Long size,
        @Nullable Boolean truncated,
        @Nullable String encoding,
        @Nullable String content) {}
