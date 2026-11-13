package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryBlobsBatch}.
 *
 * @param files the files
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryBlobsBatch/requestBody")
public record GitLabProjectRepositoriesBatchBlobPayload(
        @Nullable List<GitLabProjectRepositoriesBatchBlobFile> files) {
    public GitLabProjectRepositoriesBatchBlobPayload {
        if (files != null) {
            files = List.copyOf(files);
        }
    }
}
