package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ImportBitbucketServer}.
 *
 * @param bitbucketServerUrl the bitbucket server url
 * @param bitbucketServerUsername the bitbucket server username
 * @param personalAccessToken the personal access token
 * @param bitbucketServerProject the bitbucket server project
 * @param bitbucketServerRepo the bitbucket server repo
 * @param newName the new name
 * @param newNamespace the new namespace
 * @param timeoutStrategy the timeout strategy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ImportBitbucketServer/requestBody")
public record GitLabImportRepositoryFromBitbucketServerCreatePayload(
        @Nullable String bitbucketServerUrl,
        @Nullable String bitbucketServerUsername,
        @Nullable String personalAccessToken,
        @Nullable String bitbucketServerProject,
        @Nullable String bitbucketServerRepo,
        @Nullable String newName,
        @Nullable String newNamespace,
        @Nullable GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy timeoutStrategy) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code personalAccessToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabImportRepositoryFromBitbucketServerCreatePayload[" + "bitbucketServerUrl=" + bitbucketServerUrl
                + ", bitbucketServerUsername=" + bitbucketServerUsername + ", personalAccessToken=<redacted>"
                + ", bitbucketServerProject=" + bitbucketServerProject + ", bitbucketServerRepo=" + bitbucketServerRepo
                + ", newName=" + newName + ", newNamespace=" + newNamespace + ", timeoutStrategy=" + timeoutStrategy
                + "]";
    }
}
