package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4NamespacesIdExists}, without paging.
 *
 * @param parentId the parent id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4NamespacesIdExists/parameters")
public record GitLabNamespacesGetExistsFilter(@Nullable Long parentId) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabNamespacesGetExistsFilter empty() {
        return GitLabNamespacesGetExistsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("parent_id", parentId).build();
    }
}
