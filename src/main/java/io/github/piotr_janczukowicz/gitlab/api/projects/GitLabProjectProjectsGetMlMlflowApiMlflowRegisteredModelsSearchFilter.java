package io.github.piotr_janczukowicz.gitlab.api.projects;

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
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsSearch},
 * without paging.
 *
 * @param filter the filter
 * @param maxResults the max results
 * @param orderBy the order by
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMlMlflowApi20MlflowRegisteredModelsSearch/parameters")
public record GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter(
        @Nullable String filter,
        @Nullable Integer maxResults,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_ARRAY)
        List<String> orderBy,

        @Nullable String pageToken) {
    public GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter {
        if (orderBy != null) {
            orderBy = List.copyOf(orderBy);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code pageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter[" + "filter=" + filter
                + ", maxResults=" + maxResults + ", orderBy=" + orderBy + ", pageToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter empty() {
        return GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("filter", filter)
                .value("max_results", maxResults)
                .list("order_by", orderBy)
                .text("page_token", pageToken)
                .build();
    }
}
