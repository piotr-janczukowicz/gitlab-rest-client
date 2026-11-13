package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab snippet repository storage move.
 *
 * @param id the id
 * @param createdAt the created at
 * @param state the state
 * @param sourceStorageName the source storage name
 * @param destinationStorageName the destination storage name
 * @param errorMessage the error message
 * @param snippet the snippet
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSnippetsRepositoryStorageMove")
public record GitLabSnippetRepositoryStorageMove(
        @Nullable Long id,
        @Nullable Instant createdAt,
        @Nullable String state,
        @Nullable String sourceStorageName,
        @Nullable String destinationStorageName,
        @Nullable String errorMessage,
        @Nullable GitLabBasicSnippet snippet) {}
