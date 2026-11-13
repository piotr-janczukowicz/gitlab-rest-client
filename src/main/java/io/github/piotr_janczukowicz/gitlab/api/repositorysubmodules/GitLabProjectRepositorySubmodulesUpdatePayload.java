package io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdRepositorySubmodulesSubmodule}.
 *
 * @param commitSha the commit sha
 * @param branch the branch
 * @param commitMessage the commit message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdRepositorySubmodulesSubmodule/requestBody")
public record GitLabProjectRepositorySubmodulesUpdatePayload(
        @Nullable String commitSha,
        @Nullable String branch,
        @Nullable String commitMessage) {}
