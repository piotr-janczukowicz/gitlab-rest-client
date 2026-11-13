package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab personal access token create scopes. */
@CatalogSchema("operations/postApiV4UserPersonalAccessTokens/requestBody/properties/scopes/items")
public enum GitLabPersonalAccessTokenCreateScopes {
    K8S_PROXY("k8s_proxy"),
    SELF_ROTATE("self_rotate");

    private static final EnumUtils.WireIndex<GitLabPersonalAccessTokenCreateScopes> WIRE_INDEX = EnumUtils.index(
            GitLabPersonalAccessTokenCreateScopes.class, GitLabPersonalAccessTokenCreateScopes::wireValue);

    private final String wireValue;

    GitLabPersonalAccessTokenCreateScopes(final String wireValue) {
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
    public static GitLabPersonalAccessTokenCreateScopes fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
