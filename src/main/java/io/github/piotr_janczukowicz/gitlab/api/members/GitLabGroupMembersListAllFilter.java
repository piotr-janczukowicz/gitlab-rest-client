package io.github.piotr_janczukowicz.gitlab.api.members;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdMembersAll}, without paging.
 *
 * @param query the query
 * @param userIds the user ids
 * @param showSeatInfo the show seat info
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdMembersAll/parameters")
public record GitLabGroupMembersListAllFilter(
        @Nullable String query,
        @Nullable List<Long> userIds,
        @Nullable Boolean showSeatInfo,
        @Nullable GitLabGroupMembersListAllState state) {
    public GitLabGroupMembersListAllFilter {
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupMembersListAllFilter empty() {
        return GitLabGroupMembersListAllFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("query", query)
                .list("user_ids", userIds)
                .value("show_seat_info", showSeatInfo)
                .wire("state", state, GitLabGroupMembersListAllState::wireValue)
                .build();
    }
}
