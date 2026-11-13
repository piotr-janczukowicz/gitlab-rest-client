package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param maxArtifactsSize the max artifacts size
 * @param maxAttachmentSize the max attachment size
 * @param maxExportSize the max export size
 * @param maxGithubResponseSizeLimit the max github response size limit
 * @param maxGithubResponseJsonValueCount the max github response json value count
 * @param maxImportSize the max import size
 * @param maxImportRemoteFileSize the max import remote file size
 * @param maxDecompressedArchiveSize the max decompressed archive size
 * @param maxPagesSize the max pages size
 * @param maxPagesCustomDomainsPerProject the max pages custom domains per project
 * @param maxTerraformStateSizeBytes the max terraform state size bytes
 * @param maxHttpDecompressedSize the max http decompressed size
 * @param maxHttpResponseCsvStructuralChars the max http response csv structural chars
 * @param maxHttpResponseJsonDepth the max http response json depth
 * @param maxHttpResponseJsonStructuralChars the max http response json structural chars
 * @param maxHttpResponseSizeLimit the max http response size limit
 * @param maxHttpResponseXmlStructuralChars the max http response xml structural chars
 * @param maxLoginAttempts the max login attempts
 * @param maxYamlDepth the max yaml depth
 * @param maxYamlSizeBytes the max yaml size bytes
 * @param maxNumberOfRepositoryDownloads the max number of repository downloads
 * @param maxNumberOfRepositoryDownloadsWithinTimePeriod the max number of repository downloads within time period
 * @param maxPersonalAccessTokenLifetime the max personal access token lifetime
 * @param maxSshKeyLifetime the max ssh key lifetime
 * @param maxArtifactsContentIncludeSize the max artifacts content include size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateMax(
        @Nullable Long maxArtifactsSize,
        @Nullable Long maxAttachmentSize,
        @Nullable Long maxExportSize,
        @Nullable Integer maxGithubResponseSizeLimit,
        @Nullable Integer maxGithubResponseJsonValueCount,
        @Nullable Long maxImportSize,
        @Nullable Long maxImportRemoteFileSize,
        @Nullable Long maxDecompressedArchiveSize,
        @Nullable Long maxPagesSize,
        @Nullable Integer maxPagesCustomDomainsPerProject,
        @Nullable Long maxTerraformStateSizeBytes,
        @Nullable String maxHttpDecompressedSize,
        @Nullable String maxHttpResponseCsvStructuralChars,
        @Nullable String maxHttpResponseJsonDepth,
        @Nullable String maxHttpResponseJsonStructuralChars,
        @Nullable String maxHttpResponseSizeLimit,
        @Nullable String maxHttpResponseXmlStructuralChars,
        @Nullable String maxLoginAttempts,
        @Nullable String maxYamlDepth,
        @Nullable String maxYamlSizeBytes,
        @Nullable Integer maxNumberOfRepositoryDownloads,
        @Nullable Integer maxNumberOfRepositoryDownloadsWithinTimePeriod,
        @Nullable String maxPersonalAccessTokenLifetime,
        @Nullable String maxSshKeyLifetime,
        @Nullable String maxArtifactsContentIncludeSize) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code maxPersonalAccessTokenLifetime} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateMax[" + "maxArtifactsSize=" + maxArtifactsSize + ", maxAttachmentSize="
                + maxAttachmentSize + ", maxExportSize=" + maxExportSize + ", maxGithubResponseSizeLimit="
                + maxGithubResponseSizeLimit + ", maxGithubResponseJsonValueCount=" + maxGithubResponseJsonValueCount
                + ", maxImportSize=" + maxImportSize + ", maxImportRemoteFileSize=" + maxImportRemoteFileSize
                + ", maxDecompressedArchiveSize=" + maxDecompressedArchiveSize + ", maxPagesSize=" + maxPagesSize
                + ", maxPagesCustomDomainsPerProject=" + maxPagesCustomDomainsPerProject
                + ", maxTerraformStateSizeBytes=" + maxTerraformStateSizeBytes + ", maxHttpDecompressedSize="
                + maxHttpDecompressedSize + ", maxHttpResponseCsvStructuralChars=" + maxHttpResponseCsvStructuralChars
                + ", maxHttpResponseJsonDepth=" + maxHttpResponseJsonDepth + ", maxHttpResponseJsonStructuralChars="
                + maxHttpResponseJsonStructuralChars + ", maxHttpResponseSizeLimit=" + maxHttpResponseSizeLimit
                + ", maxHttpResponseXmlStructuralChars=" + maxHttpResponseXmlStructuralChars + ", maxLoginAttempts="
                + maxLoginAttempts + ", maxYamlDepth=" + maxYamlDepth + ", maxYamlSizeBytes=" + maxYamlSizeBytes
                + ", maxNumberOfRepositoryDownloads=" + maxNumberOfRepositoryDownloads
                + ", maxNumberOfRepositoryDownloadsWithinTimePeriod=" + maxNumberOfRepositoryDownloadsWithinTimePeriod
                + ", maxPersonalAccessTokenLifetime=<redacted>" + ", maxSshKeyLifetime=" + maxSshKeyLifetime
                + ", maxArtifactsContentIncludeSize=" + maxArtifactsContentIncludeSize + "]";
    }
}
