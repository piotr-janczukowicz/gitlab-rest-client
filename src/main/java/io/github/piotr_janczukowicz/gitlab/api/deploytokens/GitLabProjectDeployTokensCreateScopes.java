package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project deploy tokens create scopes. */
@CatalogSchema("operations/postApiV4ProjectsIdDeployTokens/requestBody/properties/scopes/items")
public enum GitLabProjectDeployTokensCreateScopes {
    READ_REPOSITORY("read_repository"),
    READ_REGISTRY("read_registry"),
    WRITE_REGISTRY("write_registry"),
    READ_PACKAGE_REGISTRY("read_package_registry"),
    WRITE_PACKAGE_REGISTRY("write_package_registry"),
    READ_VIRTUAL_REGISTRY("read_virtual_registry"),
    WRITE_VIRTUAL_REGISTRY("write_virtual_registry");

    private static final EnumUtils.WireIndex<GitLabProjectDeployTokensCreateScopes> WIRE_INDEX = EnumUtils.index(
            GitLabProjectDeployTokensCreateScopes.class, GitLabProjectDeployTokensCreateScopes::wireValue);

    private final String wireValue;

    GitLabProjectDeployTokensCreateScopes(final String wireValue) {
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
    public static GitLabProjectDeployTokensCreateScopes fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
