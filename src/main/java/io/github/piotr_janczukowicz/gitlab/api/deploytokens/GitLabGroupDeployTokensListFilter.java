package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdDeployTokens}, without paging.
 *
 * @param active the active
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdDeployTokens/parameters")
public record GitLabGroupDeployTokensListFilter(@Nullable Boolean active) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupDeployTokensListFilter empty() {
        return GitLabGroupDeployTokensListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("active", active).build();
    }
}
