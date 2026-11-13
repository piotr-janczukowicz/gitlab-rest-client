package io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4TemplatesLicensesName}, without paging.
 *
 * @param project the project
 * @param fullname the fullname
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4TemplatesLicensesName/parameters")
public record GitLabOpenSourceLicenseTemplatesGetFilter(
        @Nullable String project, @Nullable String fullname) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabOpenSourceLicenseTemplatesGetFilter empty() {
        return GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("project", project)
                .text("fullname", fullname)
                .build();
    }
}
