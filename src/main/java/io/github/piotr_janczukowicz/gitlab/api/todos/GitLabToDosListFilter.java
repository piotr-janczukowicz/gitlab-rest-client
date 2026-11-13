package io.github.piotr_janczukowicz.gitlab.api.todos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Todos}, without paging.
 *
 * @param action the action
 * @param authorId the author id
 * @param projectId the project id
 * @param groupId the group id
 * @param state the state
 * @param type the type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Todos/parameters")
public record GitLabToDosListFilter(
        @Nullable GitLabToDosListAction action,
        @Nullable Long authorId,
        @Nullable Long projectId,
        @Nullable Long groupId,
        @Nullable GitLabToDosListState state,
        @Nullable GitLabToDosListType type) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabToDosListFilter empty() {
        return GitLabToDosListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("action", action, GitLabToDosListAction::wireValue)
                .value("author_id", authorId)
                .value("project_id", projectId)
                .value("group_id", groupId)
                .wire("state", state, GitLabToDosListState::wireValue)
                .wire("type", type, GitLabToDosListType::wireValue)
                .build();
    }
}
