package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4OfflineImports}.
 *
 * @param bucket the bucket
 * @param awsS3Configuration the aws s3 configuration
 * @param s3CompatibleConfiguration the s3 compatible configuration
 * @param gcsConfiguration the gcs configuration
 * @param gcsHmacConfiguration the gcs hmac configuration
 * @param gcsAdcConfiguration the gcs adc configuration
 * @param exportPrefix the export prefix
 * @param entities the entities
 * @param importAll the import all
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody")
public record GitLabOfflineTransfersCreateImportsPayload(
        @Nullable String bucket,
        @Nullable GitLabOfflineTransfersCreateImportsAwsS3Configuration awsS3Configuration,
        @Nullable GitLabOfflineTransfersCreateImportsS3CompatibleConfiguration s3CompatibleConfiguration,
        @Nullable GitLabOfflineTransfersCreateImportsGcsConfiguration gcsConfiguration,
        @Nullable GitLabOfflineTransfersCreateImportsGcsHmacConfiguration gcsHmacConfiguration,
        @Nullable GitLabOfflineTransfersCreateImportsGcsAdcConfiguration gcsAdcConfiguration,
        @Nullable String exportPrefix,
        @Nullable List<GitLabOfflineTransfersCreateImportsEntity> entities,
        @Nullable GitLabOfflineTransfersCreateImportsImportAll importAll) {
    public GitLabOfflineTransfersCreateImportsPayload {
        if (entities != null) {
            entities = List.copyOf(entities);
        }
    }
}
