package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab markdown upload admin.
 *
 * @param id the id
 * @param size the size
 * @param filename the filename
 * @param createdAt the created at
 * @param uploadedBy the uploaded by
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMarkdownUploadAdmin")
public record GitLabMarkdownUploadAdmin(
        @Nullable Long id,
        @Nullable Long size,
        @Nullable String filename,
        @Nullable Instant createdAt,
        @Nullable GitLabUserSafe uploadedBy) {}
