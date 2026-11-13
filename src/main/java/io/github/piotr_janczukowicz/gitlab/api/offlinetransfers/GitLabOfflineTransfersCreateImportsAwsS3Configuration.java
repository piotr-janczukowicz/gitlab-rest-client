package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create imports aws s3 configuration of a GitLab resource.
 *
 * @param awsAccessKeyId the aws access key id
 * @param awsSecretAccessKey the aws secret access key
 * @param region the region
 * @param pathStyle the path style
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody/properties/aws_s3_configuration")
public record GitLabOfflineTransfersCreateImportsAwsS3Configuration(
        @Nullable String awsAccessKeyId,
        @Nullable String awsSecretAccessKey,
        @Nullable String region,
        @Nullable Boolean pathStyle) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code awsSecretAccessKey} redacted
     */
    @Override
    public String toString() {
        return "GitLabOfflineTransfersCreateImportsAwsS3Configuration[" + "awsAccessKeyId=" + awsAccessKeyId
                + ", awsSecretAccessKey=<redacted>" + ", region=" + region + ", pathStyle=" + pathStyle + "]";
    }
}
