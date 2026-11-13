package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackagesConanV2ConansSearch}, without paging.
 *
 * @param ignorecase the ignorecase
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesConanV2ConansSearch/parameters")
public record GitLabProjectConanV2DistributionsCallV2ConansSearchFilter(
        @Nullable Boolean ignorecase) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectConanV2DistributionsCallV2ConansSearchFilter empty() {
        return GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("ignorecase", ignorecase).build();
    }
}
