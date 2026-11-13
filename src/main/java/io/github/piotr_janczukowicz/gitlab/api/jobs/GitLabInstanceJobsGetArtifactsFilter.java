package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4JobsIdArtifacts}, without paging.
 *
 * @param token the token
 * @param directDownload the direct download
 * @param downloadMode the download mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4JobsIdArtifacts/parameters")
public record GitLabInstanceJobsGetArtifactsFilter(
        @Nullable String token,
        @Nullable Boolean directDownload,
        @Nullable GitLabInstanceJobsGetArtifactsDownloadMode downloadMode) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsGetArtifactsFilter[" + "token=<redacted>" + ", directDownload=" + directDownload
                + ", downloadMode=" + downloadMode + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceJobsGetArtifactsFilter empty() {
        return GitLabInstanceJobsGetArtifactsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("token", token)
                .value("direct_download", directDownload)
                .wire("download_mode", downloadMode, GitLabInstanceJobsGetArtifactsDownloadMode::wireValue)
                .build();
    }
}
