package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance clusters add platform kubernetes attributes authorization type. */
@CatalogSchema(
        "operations/postApiV4AdminClustersAdd/requestBody/properties/platform_kubernetes_attributes/properties/authorization_type")
public enum GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType {
    UNKNOWN_AUTHORIZATION("unknown_authorization"),
    RBAC("rbac"),
    ABAC("abac");

    private static final EnumUtils.WireIndex<GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType>
            WIRE_INDEX = EnumUtils.index(
                    GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.class,
                    GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType::wireValue);

    private final String wireValue;

    GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
