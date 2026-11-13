package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPipelinesPipelineIdBridges}, without paging.
 *
 * @param scope the scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPipelinesPipelineIdBridges/parameters")
public record GitLabProjectPipelinesListBridgesFilter(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_ARRAY)
        List<String> scope) {
    public GitLabProjectPipelinesListBridgesFilter {
        if (scope != null) {
            scope = List.copyOf(scope);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPipelinesListBridgesFilter empty() {
        return GitLabProjectPipelinesListBridgesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().list("scope", scope).build();
    }
}
