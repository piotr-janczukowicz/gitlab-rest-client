package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdRepositoryStorageMoves}.
 *
 * @param destinationStorageName the destination storage name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdRepositoryStorageMoves/requestBody")
public record GitLabGroupGroupsCreateRepositoryStorageMovePayload(
        @Nullable String destinationStorageName) {}
