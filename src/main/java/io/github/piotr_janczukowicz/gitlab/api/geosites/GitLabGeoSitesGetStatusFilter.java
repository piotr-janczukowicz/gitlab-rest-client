package io.github.piotr_janczukowicz.gitlab.api.geosites;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GeoSitesIdStatus}, without paging.
 *
 * @param refresh the refresh
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GeoSitesIdStatus/parameters")
public record GitLabGeoSitesGetStatusFilter(@Nullable Boolean refresh) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGeoSitesGetStatusFilter empty() {
        return GitLabGeoSitesGetStatusFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("refresh", refresh).build();
    }
}
