package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GeoProxyGitSshUploadPack}.
 *
 * @param secretToken the secret token
 * @param data the data
 * @param output the output
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoProxyGitSshUploadPack/requestBody")
public record GitLabGeoUploadPackPayload(
        @Nullable String secretToken,
        @Nullable GitLabGeoUploadPackData data,
        @Nullable String output) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code secretToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabGeoUploadPackPayload[" + "secretToken=<redacted>" + ", data=" + data + ", output=" + output + "]";
    }
}
