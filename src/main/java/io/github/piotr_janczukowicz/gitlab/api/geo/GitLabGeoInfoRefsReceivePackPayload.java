package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GeoProxyGitSshInfoRefsReceivePack}.
 *
 * @param secretToken the secret token
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoProxyGitSshInfoRefsReceivePack/requestBody")
public record GitLabGeoInfoRefsReceivePackPayload(
        @Nullable String secretToken, @Nullable GitLabGeoInfoRefsReceivePackData data) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code secretToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabGeoInfoRefsReceivePackPayload[" + "secretToken=<redacted>" + ", data=" + data + "]";
    }
}
