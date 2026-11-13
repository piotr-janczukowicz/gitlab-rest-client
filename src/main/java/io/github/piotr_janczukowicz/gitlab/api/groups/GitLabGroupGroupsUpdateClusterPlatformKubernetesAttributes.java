package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group groups update cluster platform kubernetes attributes of a GitLab resource.
 *
 * @param apiUrl the api url
 * @param token the token
 * @param caCert the ca cert
 * @param namespace the namespace
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdClustersClusterId/requestBody/properties/platform_kubernetes_attributes")
public record GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes(
        @Nullable String apiUrl,
        @Nullable String token,
        @Nullable String caCert,
        @Nullable String namespace) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes[" + "apiUrl=" + apiUrl + ", token=<redacted>"
                + ", caCert=" + caCert + ", namespace=" + namespace + "]";
    }
}
