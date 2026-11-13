package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdBoardsBoardIdListsListId}.
 *
 * @param position the position
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdBoardsBoardIdListsListId/requestBody")
public record GitLabProjectIssueBoardsUpdateListPayload(
        @Nullable Integer position) {}
