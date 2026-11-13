package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab user sshand gpgkeys create usage type. */
@CatalogSchema("operations/postApiV4UserKeys/requestBody/properties/usage_type")
public enum GitLabUserSSHAndGPGKeysCreateUsageType {
    AUTH_AND_SIGNING("auth_and_signing"),
    AUTH("auth"),
    SIGNING("signing");

    private static final EnumUtils.WireIndex<GitLabUserSSHAndGPGKeysCreateUsageType> WIRE_INDEX = EnumUtils.index(
            GitLabUserSSHAndGPGKeysCreateUsageType.class, GitLabUserSSHAndGPGKeysCreateUsageType::wireValue);

    private final String wireValue;

    GitLabUserSSHAndGPGKeysCreateUsageType(final String wireValue) {
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
    public static GitLabUserSSHAndGPGKeysCreateUsageType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
