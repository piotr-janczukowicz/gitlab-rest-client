package io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4TemplatesLicenses}, without paging.
 *
 * @param popular the popular
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4TemplatesLicenses/parameters")
public record GitLabOpenSourceLicenseTemplatesListFilter(
        @Nullable Boolean popular) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabOpenSourceLicenseTemplatesListFilter empty() {
        return GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("popular", popular).build();
    }
}
