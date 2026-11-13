package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab offline transfers create imports gcs hmac configuration of a GitLab resource.
 *
 * @param googleStorageAccessKeyId the google storage access key id
 * @param googleStorageSecretAccessKey the google storage secret access key
 * @param region the region
 * @param pathStyle the path style
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OfflineImports/requestBody/properties/gcs_hmac_configuration")
public record GitLabOfflineTransfersCreateImportsGcsHmacConfiguration(
        @Nullable String googleStorageAccessKeyId,
        @Nullable String googleStorageSecretAccessKey,
        @Nullable String region,
        @Nullable Boolean pathStyle) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code googleStorageSecretAccessKey} redacted
     */
    @Override
    public String toString() {
        return "GitLabOfflineTransfersCreateImportsGcsHmacConfiguration[" + "googleStorageAccessKeyId="
                + googleStorageAccessKeyId + ", googleStorageSecretAccessKey=<redacted>" + ", region=" + region
                + ", pathStyle=" + pathStyle + "]";
    }
}
