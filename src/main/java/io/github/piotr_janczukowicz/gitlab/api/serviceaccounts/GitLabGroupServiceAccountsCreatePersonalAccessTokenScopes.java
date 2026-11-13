package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group service accounts create personal access token scopes. */
@CatalogSchema(
        "operations/postApiV4GroupsIdServiceAccountsUserIdPersonalAccessTokens/requestBody/properties/scopes/items")
public enum GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes {
    API("api"),
    READ_API("read_api"),
    READ_USER("read_user"),
    CREATE_RUNNER("create_runner"),
    MANAGE_RUNNER("manage_runner"),
    K8S_PROXY("k8s_proxy"),
    SELF_ROTATE("self_rotate"),
    MCP("mcp"),
    MCP_ORBIT("mcp_orbit"),
    GRANULAR("granular"),
    READ_REPOSITORY("read_repository"),
    WRITE_REPOSITORY("write_repository"),
    READ_REGISTRY("read_registry"),
    WRITE_REGISTRY("write_registry"),
    READ_VIRTUAL_REGISTRY("read_virtual_registry"),
    WRITE_VIRTUAL_REGISTRY("write_virtual_registry"),
    READ_OBSERVABILITY("read_observability"),
    WRITE_OBSERVABILITY("write_observability"),
    AI_FEATURES("ai_features"),
    SUDO("sudo"),
    ADMIN_MODE("admin_mode"),
    READ_SERVICE_PING("read_service_ping");

    private static final EnumUtils.WireIndex<GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes.class,
                    GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes::wireValue);

    private final String wireValue;

    GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes(final String wireValue) {
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
    public static GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
