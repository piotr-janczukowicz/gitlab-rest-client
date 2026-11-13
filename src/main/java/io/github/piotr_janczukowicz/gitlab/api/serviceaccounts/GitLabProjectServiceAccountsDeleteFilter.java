package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdServiceAccountsUserId}, without paging.
 *
 * @param hardDelete the hard delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdServiceAccountsUserId/parameters")
public record GitLabProjectServiceAccountsDeleteFilter(
        @Nullable Boolean hardDelete) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectServiceAccountsDeleteFilter empty() {
        return GitLabProjectServiceAccountsDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("hard_delete", hardDelete).build();
    }
}
