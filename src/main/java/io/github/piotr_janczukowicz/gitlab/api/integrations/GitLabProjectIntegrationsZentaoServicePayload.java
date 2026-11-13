package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesZentao}.
 *
 * @param url the url
 * @param apiUrl the api url
 * @param apiToken the api token
 * @param zentaoProductXid the zentao product xid
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesZentao/requestBody")
public record GitLabProjectIntegrationsZentaoServicePayload(
        @Nullable String url,
        @Nullable String apiUrl,
        @Nullable String apiToken,
        @Nullable String zentaoProductXid,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code apiToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsZentaoServicePayload[" + "url=" + url + ", apiUrl=" + apiUrl
                + ", apiToken=<redacted>" + ", zentaoProductXid=" + zentaoProductXid + ", useInheritedSettings="
                + useInheritedSettings + "]";
    }
}
