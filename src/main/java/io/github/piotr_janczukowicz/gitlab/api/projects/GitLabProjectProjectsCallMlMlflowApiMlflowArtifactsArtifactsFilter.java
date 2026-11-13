package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMlMlflowApi20MlflowArtifactsArtifacts}, without
 * paging.
 *
 * @param path the path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMlMlflowApi20MlflowArtifactsArtifacts/parameters")
public record GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter(
        @Nullable String path) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter empty() {
        return GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("path", path).build();
    }
}
