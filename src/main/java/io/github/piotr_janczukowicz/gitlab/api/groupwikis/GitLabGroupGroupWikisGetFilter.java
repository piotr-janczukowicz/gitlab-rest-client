package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdWikisSlug}, without paging.
 *
 * @param version the version
 * @param renderHtml the render html
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdWikisSlug/parameters")
public record GitLabGroupGroupWikisGetFilter(
        @Nullable String version, @Nullable Boolean renderHtml) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupWikisGetFilter empty() {
        return GitLabGroupGroupWikisGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("version", version)
                .value("render_html", renderHtml)
                .build();
    }
}
