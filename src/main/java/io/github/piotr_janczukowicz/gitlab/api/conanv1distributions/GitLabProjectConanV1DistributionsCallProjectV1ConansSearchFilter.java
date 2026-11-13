package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackagesConanV1ConansSearch}, without paging.
 *
 * @param ignorecase the ignorecase
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesConanV1ConansSearch/parameters")
public record GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter(
        @Nullable Boolean ignorecase) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter empty() {
        return GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
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
