package io.github.piotr_janczukowicz.gitlab.api.keys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab keys create users key usage type. */
@CatalogSchema("operations/postApiV4UsersUserIdKeys/requestBody/properties/usage_type")
public enum GitLabKeysCreateUsersKeyUsageType {
    AUTH_AND_SIGNING("auth_and_signing"),
    AUTH("auth"),
    SIGNING("signing");

    private static final EnumUtils.WireIndex<GitLabKeysCreateUsersKeyUsageType> WIRE_INDEX =
            EnumUtils.index(GitLabKeysCreateUsersKeyUsageType.class, GitLabKeysCreateUsersKeyUsageType::wireValue);

    private final String wireValue;

    GitLabKeysCreateUsersKeyUsageType(final String wireValue) {
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
    public static GitLabKeysCreateUsersKeyUsageType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
