package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryCommitsShaRevert}.
 *
 * @param branch the branch
 * @param dryRun the dry run
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryCommitsShaRevert/requestBody")
public record GitLabProjectCommitsRevertPayload(
        @Nullable String branch, @Nullable Boolean dryRun) {}
