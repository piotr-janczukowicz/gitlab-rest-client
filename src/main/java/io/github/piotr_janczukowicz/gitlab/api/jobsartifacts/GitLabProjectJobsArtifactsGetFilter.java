package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobsJobIdArtifacts}, without paging.
 *
 * @param fileType the file type
 * @param jobToken the job token
 * @param downloadMode the download mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobsJobIdArtifacts/parameters")
public record GitLabProjectJobsArtifactsGetFilter(
        @Nullable GitLabProjectJobsArtifactsGetFileType fileType,
        @Nullable String jobToken,
        @Nullable GitLabProjectJobsArtifactsGetDownloadMode downloadMode) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code jobToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectJobsArtifactsGetFilter[" + "fileType=" + fileType + ", jobToken=<redacted>"
                + ", downloadMode=" + downloadMode + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsArtifactsGetFilter empty() {
        return GitLabProjectJobsArtifactsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("file_type", fileType, GitLabProjectJobsArtifactsGetFileType::wireValue)
                .text("job_token", jobToken)
                .wire("download_mode", downloadMode, GitLabProjectJobsArtifactsGetDownloadMode::wireValue)
                .build();
    }
}
