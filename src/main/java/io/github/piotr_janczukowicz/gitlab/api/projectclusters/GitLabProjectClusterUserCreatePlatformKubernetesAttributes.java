package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project cluster user create platform kubernetes attributes of a GitLab resource.
 *
 * @param apiUrl the api url
 * @param token the token
 * @param caCert the ca cert
 * @param namespace the namespace
 * @param authorizationType the authorization type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdClustersUser/requestBody/properties/platform_kubernetes_attributes")
public record GitLabProjectClusterUserCreatePlatformKubernetesAttributes(
        @Nullable String apiUrl,
        @Nullable String token,
        @Nullable String caCert,
        @Nullable String namespace,
        @Nullable GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType authorizationType) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectClusterUserCreatePlatformKubernetesAttributes[" + "apiUrl=" + apiUrl + ", token=<redacted>"
                + ", caCert=" + caCert + ", namespace=" + namespace + ", authorizationType=" + authorizationType + "]";
    }
}
