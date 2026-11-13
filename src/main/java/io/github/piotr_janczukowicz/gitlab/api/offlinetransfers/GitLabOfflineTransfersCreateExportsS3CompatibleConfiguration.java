package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create exports s3 compatible configuration of a GitLab resource.
 *
 * @param awsAccessKeyId the aws access key id
 * @param awsSecretAccessKey the aws secret access key
 * @param region the region
 * @param endpoint the endpoint
 * @param pathStyle the path style
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineExports/requestBody/properties/s3_compatible_configuration")
public record GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration(
        @Nullable String awsAccessKeyId,
        @Nullable String awsSecretAccessKey,
        @Nullable String region,
        @Nullable String endpoint,
        @Nullable Boolean pathStyle) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code awsSecretAccessKey} redacted
     */
    @Override
    public String toString() {
        return "GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration[" + "awsAccessKeyId=" + awsAccessKeyId
                + ", awsSecretAccessKey=<redacted>" + ", region=" + region + ", endpoint=" + endpoint + ", pathStyle="
                + pathStyle + "]";
    }
}
