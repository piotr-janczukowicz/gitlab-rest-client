package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance clusters add platform kubernetes attributes of a GitLab resource.
 *
 * @param apiUrl the api url
 * @param token the token
 * @param caCert the ca cert
 * @param namespace the namespace
 * @param authorizationType the authorization type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AdminClustersAdd/requestBody/properties/platform_kubernetes_attributes")
public record GitLabInstanceClustersAddPlatformKubernetesAttributes(
        @Nullable String apiUrl,
        @Nullable String token,
        @Nullable String caCert,
        @Nullable String namespace,
        @Nullable GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType authorizationType) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceClustersAddPlatformKubernetesAttributes[" + "apiUrl=" + apiUrl + ", token=<redacted>"
                + ", caCert=" + caCert + ", namespace=" + namespace + ", authorizationType=" + authorizationType + "]";
    }
}
