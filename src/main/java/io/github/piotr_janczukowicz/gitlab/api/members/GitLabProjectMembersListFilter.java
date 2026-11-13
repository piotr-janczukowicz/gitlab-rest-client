package io.github.piotr_janczukowicz.gitlab.api.members;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMembers}, without paging.
 *
 * @param query the query
 * @param userIds the user ids
 * @param skipUsers the skip users
 * @param showSeatInfo the show seat info
 * @param withSamlIdentity the with saml identity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMembers/parameters")
public record GitLabProjectMembersListFilter(
        @Nullable String query,
        @Nullable List<Long> userIds,
        @Nullable List<Integer> skipUsers,
        @Nullable Boolean showSeatInfo,
        @Nullable Boolean withSamlIdentity) {
    public GitLabProjectMembersListFilter {
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
        if (skipUsers != null) {
            skipUsers = List.copyOf(skipUsers);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectMembersListFilter empty() {
        return GitLabProjectMembersListFilterBuilder.builder().build();
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
                .list("skip_users", skipUsers)
                .value("show_seat_info", showSeatInfo)
                .value("with_saml_identity", withSamlIdentity)
                .build();
    }
}
