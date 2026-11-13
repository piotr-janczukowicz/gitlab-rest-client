package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobsArtifactsRefNameDownload}, without paging.
 *
 * @param jobToken the job token
 * @param searchRecentSuccessfulPipelines the search recent successful pipelines
 * @param downloadMode the download mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobsArtifactsRefNameDownload/parameters")
public record GitLabProjectJobsGetArtifactsDownloadFilter(
        @Nullable String jobToken,
        @Nullable Boolean searchRecentSuccessfulPipelines,
        @Nullable GitLabProjectJobsGetArtifactsDownloadMode downloadMode) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code jobToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectJobsGetArtifactsDownloadFilter[" + "jobToken=<redacted>"
                + ", searchRecentSuccessfulPipelines=" + searchRecentSuccessfulPipelines + ", downloadMode="
                + downloadMode + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsGetArtifactsDownloadFilter empty() {
        return GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder().build();
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
                .wire("download_mode", downloadMode, GitLabProjectJobsGetArtifactsDownloadMode::wireValue)
                .build();
    }
}
