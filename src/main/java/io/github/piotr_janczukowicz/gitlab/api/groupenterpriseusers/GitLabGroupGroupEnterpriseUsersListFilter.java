package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdEnterpriseUsers}, without paging.
 *
 * @param username the username
 * @param search the search
 * @param active the active
 * @param blocked the blocked
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param twoFactor the two factor
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdEnterpriseUsers/parameters")
public record GitLabGroupGroupEnterpriseUsersListFilter(
        @Nullable String username,
        @Nullable String search,
        @Nullable Boolean active,
        @Nullable Boolean blocked,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable String twoFactor) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupEnterpriseUsersListFilter empty() {
        return GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("username", username)
                .text("search", search)
                .value("active", active)
                .value("blocked", blocked)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .text("two_factor", twoFactor)
                .build();
    }
}
