package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project remote mirrors create auth method. */
@CatalogSchema("operations/postApiV4ProjectsIdRemoteMirrors/requestBody/properties/auth_method")
public enum GitLabProjectRemoteMirrorsCreateAuthMethod {
    SSH_PUBLIC_KEY("ssh_public_key"),
    PASSWORD("password");

    private static final EnumUtils.WireIndex<GitLabProjectRemoteMirrorsCreateAuthMethod> WIRE_INDEX = EnumUtils.index(
            GitLabProjectRemoteMirrorsCreateAuthMethod.class, GitLabProjectRemoteMirrorsCreateAuthMethod::wireValue);

    private final String wireValue;

    GitLabProjectRemoteMirrorsCreateAuthMethod(final String wireValue) {
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
    public static GitLabProjectRemoteMirrorsCreateAuthMethod fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
