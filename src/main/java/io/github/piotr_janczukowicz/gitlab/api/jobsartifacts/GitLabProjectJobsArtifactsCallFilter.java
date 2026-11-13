package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobsJobIdArtifactsArtifactPath}, without paging.
 *
 * @param jobToken the job token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobsJobIdArtifactsArtifactPath/parameters")
public record GitLabProjectJobsArtifactsCallFilter(@Nullable String jobToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code jobToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectJobsArtifactsCallFilter[" + "jobToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsArtifactsCallFilter empty() {
        return GitLabProjectJobsArtifactsCallFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("job_token", jobToken).build();
    }
}
