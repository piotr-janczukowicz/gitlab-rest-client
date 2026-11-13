package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobsArtifactsRefNameRawArtifactPath}, without
 * paging.
 *
 * @param jobToken the job token
 * @param searchRecentSuccessfulPipelines the search recent successful pipelines
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobsArtifactsRefNameRawArtifactPath/parameters")
public record GitLabProjectJobsCallArtifactsRawFilter(
        @Nullable String jobToken, @Nullable Boolean searchRecentSuccessfulPipelines) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code jobToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectJobsCallArtifactsRawFilter[" + "jobToken=<redacted>" + ", searchRecentSuccessfulPipelines="
                + searchRecentSuccessfulPipelines + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsCallArtifactsRawFilter empty() {
        return GitLabProjectJobsCallArtifactsRawFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("job_token", jobToken)
                .value("search_recent_successful_pipelines", searchRecentSuccessfulPipelines)
                .build();
    }
}
