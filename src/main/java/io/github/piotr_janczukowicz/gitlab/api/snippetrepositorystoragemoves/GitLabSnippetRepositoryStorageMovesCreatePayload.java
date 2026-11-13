package io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMinLength;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4SnippetRepositoryStorageMoves}.
 *
 * @param sourceStorageName the source storage name
 * @param destinationStorageName the destination storage name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4SnippetRepositoryStorageMoves/requestBody")
public record GitLabSnippetRepositoryStorageMovesCreatePayload(
        String sourceStorageName, @Nullable String destinationStorageName) {
    public GitLabSnippetRepositoryStorageMovesCreatePayload {
        requireNonNull(sourceStorageName, "sourceStorageName");
        requireMinLength(sourceStorageName, 1, "sourceStorageName");
    }
}
