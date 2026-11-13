package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update ecdsa sk key restriction. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/ecdsa_sk_key_restriction")
public enum GitLabSettingsUpdateEcdsaSkKeyRestriction {
    N_0(0),
    N_256(256),
    MINUS_ONE(-1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateEcdsaSkKeyRestriction> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateEcdsaSkKeyRestriction.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateEcdsaSkKeyRestriction(final int wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public int wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabSettingsUpdateEcdsaSkKeyRestriction fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
