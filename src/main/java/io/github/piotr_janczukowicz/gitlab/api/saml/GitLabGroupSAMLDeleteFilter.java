package io.github.piotr_janczukowicz.gitlab.api.saml;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4GroupsIdSamlGroupLinksSamlGroupName}, without paging.
 *
 * @param provider the provider
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4GroupsIdSamlGroupLinksSamlGroupName/parameters")
public record GitLabGroupSAMLDeleteFilter(@Nullable String provider) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupSAMLDeleteFilter empty() {
        return GitLabGroupSAMLDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("provider", provider).build();
    }
}
