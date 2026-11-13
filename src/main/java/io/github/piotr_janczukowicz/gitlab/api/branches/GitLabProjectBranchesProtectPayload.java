package io.github.piotr_janczukowicz.gitlab.api.branches;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdRepositoryBranchesBranchProtect}.
 *
 * @param developersCanPush the developers can push
 * @param developersCanMerge the developers can merge
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdRepositoryBranchesBranchProtect/requestBody")
public record GitLabProjectBranchesProtectPayload(
        @Nullable Boolean developersCanPush, @Nullable Boolean developersCanMerge) {}
