package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMlMlflowApi20MlflowRunsSearch}.
 *
 * @param experimentIds the experiment ids
 * @param maxResults the max results
 * @param orderBy the order by
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMlMlflowApi20MlflowRunsSearch/requestBody")
public record GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload(
        @Nullable List<String> experimentIds,
        @Nullable Integer maxResults,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_ARRAY)
        List<String> orderBy,

        @Nullable String pageToken) {
    public GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload {
        if (experimentIds != null) {
            experimentIds = List.copyOf(experimentIds);
        }
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
        return "GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload[" + "experimentIds=" + experimentIds
                + ", maxResults=" + maxResults + ", orderBy=" + orderBy + ", pageToken=<redacted>" + "]";
    }
}
