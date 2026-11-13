package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4UsersUserIdMemberships}, without paging.
 *
 * @param type the type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4UsersUserIdMemberships/parameters")
public record GitLabUsersListMembershipsFilter(@Nullable GitLabUsersListMembershipsType type) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabUsersListMembershipsFilter empty() {
        return GitLabUsersListMembershipsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("type", type, GitLabUsersListMembershipsType::wireValue)
                .build();
    }
}
