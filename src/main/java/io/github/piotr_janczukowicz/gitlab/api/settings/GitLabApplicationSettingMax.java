package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param maxArtifactsContentIncludeSize the max artifacts content include size
 * @param maxArtifactsSize the max artifacts size
 * @param maxAttachmentSize the max attachment size
 * @param maxDecompressedArchiveSize the max decompressed archive size
 * @param maxExportSize the max export size
 * @param maxGithubResponseSizeLimit the max github response size limit
 * @param maxGithubResponseJsonValueCount the max github response json value count
 * @param maxHttpDecompressedSize the max http decompressed size
 * @param maxHttpResponseSizeLimit the max http response size limit
 * @param maxHttpResponseJsonDepth the max http response json depth
 * @param maxHttpResponseJsonStructuralChars the max http response json structural chars
 * @param maxHttpResponseXmlStructuralChars the max http response xml structural chars
 * @param maxHttpResponseCsvStructuralChars the max http response csv structural chars
 * @param maxImportSize the max import size
 * @param maxImportRemoteFileSize the max import remote file size
 * @param maxLoginAttempts the max login attempts
 * @param maxPagesSize the max pages size
 * @param maxPagesCustomDomainsPerProject the max pages custom domains per project
 * @param maxTerraformStateSizeBytes the max terraform state size bytes
 * @param maxYamlSizeBytes the max yaml size bytes
 * @param maxYamlDepth the max yaml depth
 * @param maxPersonalAccessTokenLifetime the max personal access token lifetime
 * @param maxSshKeyLifetime the max ssh key lifetime
 * @param maxNumberOfRepositoryDownloads the max number of repository downloads
 * @param maxNumberOfRepositoryDownloadsWithinTimePeriod the max number of repository downloads within time period
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingMax(
        @Nullable String maxArtifactsContentIncludeSize,
        @Nullable String maxArtifactsSize,
        @Nullable String maxAttachmentSize,
        @Nullable String maxDecompressedArchiveSize,
        @Nullable String maxExportSize,
        @Nullable String maxGithubResponseSizeLimit,
        @Nullable String maxGithubResponseJsonValueCount,
        @Nullable String maxHttpDecompressedSize,
        @Nullable String maxHttpResponseSizeLimit,
        @Nullable String maxHttpResponseJsonDepth,
        @Nullable String maxHttpResponseJsonStructuralChars,
        @Nullable String maxHttpResponseXmlStructuralChars,
        @Nullable String maxHttpResponseCsvStructuralChars,
        @Nullable String maxImportSize,
        @Nullable String maxImportRemoteFileSize,
        @Nullable String maxLoginAttempts,
        @Nullable String maxPagesSize,
        @Nullable String maxPagesCustomDomainsPerProject,
        @Nullable String maxTerraformStateSizeBytes,
        @Nullable String maxYamlSizeBytes,
        @Nullable String maxYamlDepth,
        @Nullable String maxPersonalAccessTokenLifetime,
        @Nullable String maxSshKeyLifetime,
        @Nullable String maxNumberOfRepositoryDownloads,
        @Nullable String maxNumberOfRepositoryDownloadsWithinTimePeriod) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code maxPersonalAccessTokenLifetime} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingMax[" + "maxArtifactsContentIncludeSize=" + maxArtifactsContentIncludeSize
                + ", maxArtifactsSize=" + maxArtifactsSize + ", maxAttachmentSize=" + maxAttachmentSize
                + ", maxDecompressedArchiveSize=" + maxDecompressedArchiveSize + ", maxExportSize=" + maxExportSize
                + ", maxGithubResponseSizeLimit=" + maxGithubResponseSizeLimit + ", maxGithubResponseJsonValueCount="
                + maxGithubResponseJsonValueCount + ", maxHttpDecompressedSize=" + maxHttpDecompressedSize
                + ", maxHttpResponseSizeLimit=" + maxHttpResponseSizeLimit + ", maxHttpResponseJsonDepth="
                + maxHttpResponseJsonDepth + ", maxHttpResponseJsonStructuralChars="
                + maxHttpResponseJsonStructuralChars + ", maxHttpResponseXmlStructuralChars="
                + maxHttpResponseXmlStructuralChars + ", maxHttpResponseCsvStructuralChars="
                + maxHttpResponseCsvStructuralChars + ", maxImportSize=" + maxImportSize + ", maxImportRemoteFileSize="
                + maxImportRemoteFileSize + ", maxLoginAttempts=" + maxLoginAttempts + ", maxPagesSize=" + maxPagesSize
                + ", maxPagesCustomDomainsPerProject=" + maxPagesCustomDomainsPerProject
                + ", maxTerraformStateSizeBytes=" + maxTerraformStateSizeBytes + ", maxYamlSizeBytes="
                + maxYamlSizeBytes + ", maxYamlDepth=" + maxYamlDepth + ", maxPersonalAccessTokenLifetime=<redacted>"
                + ", maxSshKeyLifetime=" + maxSshKeyLifetime + ", maxNumberOfRepositoryDownloads="
                + maxNumberOfRepositoryDownloads + ", maxNumberOfRepositoryDownloadsWithinTimePeriod="
                + maxNumberOfRepositoryDownloadsWithinTimePeriod + "]";
    }
}
