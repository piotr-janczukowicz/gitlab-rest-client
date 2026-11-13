package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4OfflineExports}.
 *
 * @param bucket the bucket
 * @param awsS3Configuration the aws s3 configuration
 * @param s3CompatibleConfiguration the s3 compatible configuration
 * @param gcsConfiguration the gcs configuration
 * @param gcsHmacConfiguration the gcs hmac configuration
 * @param gcsAdcConfiguration the gcs adc configuration
 * @param entities the entities
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineExports/requestBody")
public record GitLabOfflineTransfersCreateExportsPayload(
        @Nullable String bucket,
        @Nullable GitLabOfflineTransfersCreateExportsAwsS3Configuration awsS3Configuration,
        @Nullable GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration s3CompatibleConfiguration,
        @Nullable GitLabOfflineTransfersCreateExportsGcsConfiguration gcsConfiguration,
        @Nullable GitLabOfflineTransfersCreateExportsGcsHmacConfiguration gcsHmacConfiguration,
        @Nullable GitLabOfflineTransfersCreateExportsGcsAdcConfiguration gcsAdcConfiguration,
        @Nullable List<GitLabOfflineTransfersCreateExportsEntity> entities) {
    public GitLabOfflineTransfersCreateExportsPayload {
        if (entities != null) {
            entities = List.copyOf(entities);
        }
    }
}
