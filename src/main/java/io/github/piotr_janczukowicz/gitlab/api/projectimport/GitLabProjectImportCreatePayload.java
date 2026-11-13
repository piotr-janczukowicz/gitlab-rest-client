package io.github.piotr_janczukowicz.gitlab.api.projectimport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ImportBitbucket}.
 *
 * @param bitbucketEmail the bitbucket email
 * @param bitbucketApiToken the bitbucket api token
 * @param repoPath the repo path
 * @param targetNamespace the target namespace
 * @param newName the new name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ImportBitbucket/requestBody")
public record GitLabProjectImportCreatePayload(
        @Nullable String bitbucketEmail,
        @Nullable String bitbucketApiToken,
        @Nullable String repoPath,
        @Nullable String targetNamespace,
        @Nullable String newName) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code bitbucketApiToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectImportCreatePayload[" + "bitbucketEmail=" + bitbucketEmail
                + ", bitbucketApiToken=<redacted>" + ", repoPath=" + repoPath + ", targetNamespace=" + targetNamespace
                + ", newName=" + newName + "]";
    }
}
