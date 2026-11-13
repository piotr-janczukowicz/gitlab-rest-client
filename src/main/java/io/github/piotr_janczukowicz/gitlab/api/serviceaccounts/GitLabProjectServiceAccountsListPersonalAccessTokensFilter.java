package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdServiceAccountsUserIdPersonalAccessTokens},
 * without paging.
 *
 * @param revoked the revoked
 * @param state the state
 * @param createdBefore the created before
 * @param createdAfter the created after
 * @param lastUsedBefore the last used before
 * @param lastUsedAfter the last used after
 * @param expiresBefore the expires before
 * @param expiresAfter the expires after
 * @param search the search
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdServiceAccountsUserIdPersonalAccessTokens/parameters")
public record GitLabProjectServiceAccountsListPersonalAccessTokensFilter(
        @Nullable Boolean revoked,
        @Nullable GitLabProjectServiceAccountsListPersonalAccessTokensState state,
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter,
        @Nullable Instant lastUsedBefore,
        @Nullable Instant lastUsedAfter,
        @Nullable LocalDate expiresBefore,
        @Nullable LocalDate expiresAfter,
        @Nullable String search,
        @Nullable String sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectServiceAccountsListPersonalAccessTokensFilter empty() {
        return GitLabProjectServiceAccountsListPersonalAccessTokensFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("revoked", revoked)
                .wire("state", state, GitLabProjectServiceAccountsListPersonalAccessTokensState::wireValue)
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .value("last_used_before", lastUsedBefore)
                .value("last_used_after", lastUsedAfter)
                .value("expires_before", expiresBefore)
                .value("expires_after", expiresAfter)
                .text("search", search)
                .text("sort", sort)
                .build();
    }
}
