package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Namespaces}, without paging.
 *
 * @param search the search
 * @param ownedOnly the owned only
 * @param topLevelOnly the top level only
 * @param fullPathSearch the full path search
 * @param requestedHostedPlan the requested hosted plan
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Namespaces/parameters")
public record GitLabNamespacesListFilter(
        @Nullable String search,
        @Nullable Boolean ownedOnly,
        @Nullable Boolean topLevelOnly,
        @Nullable Boolean fullPathSearch,
        @Nullable String requestedHostedPlan) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabNamespacesListFilter empty() {
        return GitLabNamespacesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("search", search)
                .value("owned_only", ownedOnly)
                .value("top_level_only", topLevelOnly)
                .value("full_path_search", fullPathSearch)
                .text("requested_hosted_plan", requestedHostedPlan)
                .build();
    }
}
