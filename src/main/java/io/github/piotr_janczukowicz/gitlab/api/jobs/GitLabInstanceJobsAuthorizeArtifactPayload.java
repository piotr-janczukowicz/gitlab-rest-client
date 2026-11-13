package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4JobsIdArtifactsAuthorize}.
 *
 * @param token the token
 * @param filesize the filesize
 * @param artifactType the artifact type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsIdArtifactsAuthorize/requestBody")
public record GitLabInstanceJobsAuthorizeArtifactPayload(
        @Nullable String token,
        @Nullable Integer filesize,
        @Nullable GitLabInstanceJobsAuthorizeArtifactType artifactType) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsAuthorizeArtifactPayload[" + "token=<redacted>" + ", filesize=" + filesize
                + ", artifactType=" + artifactType + "]";
    }
}
