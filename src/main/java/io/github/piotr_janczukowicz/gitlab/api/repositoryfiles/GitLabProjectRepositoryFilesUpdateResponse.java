package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project repository files update response.
 *
 * @param filePath the file path
 * @param branch the branch
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdRepositoryFilesFilePath/200")
public record GitLabProjectRepositoryFilesUpdateResponse(
        @Nullable String filePath, @Nullable String branch) {}
