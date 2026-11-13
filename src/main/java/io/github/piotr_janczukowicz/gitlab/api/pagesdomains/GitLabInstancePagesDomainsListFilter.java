package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4PagesDomains}, without paging.
 *
 * @param domain the domain
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4PagesDomains/parameters")
public record GitLabInstancePagesDomainsListFilter(@Nullable String domain) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstancePagesDomainsListFilter empty() {
        return GitLabInstancePagesDomainsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("domain", domain).build();
    }
}
