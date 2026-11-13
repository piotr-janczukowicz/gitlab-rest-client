package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4UsersId}, without paging.
 *
 * @param hardDelete the hard delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4UsersId/parameters")
public record GitLabUsersDeleteFilter(@Nullable Boolean hardDelete) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabUsersDeleteFilter empty() {
        return GitLabUsersDeleteFilterBuilder.builder().build();
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
