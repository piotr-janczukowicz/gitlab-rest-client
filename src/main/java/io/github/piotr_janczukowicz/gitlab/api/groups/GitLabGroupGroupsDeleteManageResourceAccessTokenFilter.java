package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4GroupsIdManageResourceAccessTokensPratId}, without
 * paging.
 *
 * @param expiresAt the expires at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4GroupsIdManageResourceAccessTokensPratId/parameters")
public record GitLabGroupGroupsDeleteManageResourceAccessTokenFilter(
        @Nullable LocalDate expiresAt) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupsDeleteManageResourceAccessTokenFilter empty() {
        return GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("expires_at", expiresAt).build();
    }
}
