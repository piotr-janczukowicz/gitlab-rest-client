package io.github.piotr_janczukowicz.gitlab.api.branches;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryBranches}.
 *
 * @param branch the branch
 * @param ref the ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryBranches/requestBody")
public record GitLabProjectBranchesCreatePayload(
        @Nullable String branch, @Nullable String ref) {}
