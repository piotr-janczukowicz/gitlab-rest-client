package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update ecdsa key restriction. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/ecdsa_key_restriction")
public enum GitLabSettingsUpdateEcdsaKeyRestriction {
    N_0(0),
    N_256(256),
    N_384(384),
    N_521(521),
    MINUS_ONE(-1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateEcdsaKeyRestriction> WIRE_INDEX =
            EnumUtils.index(GitLabSettingsUpdateEcdsaKeyRestriction.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateEcdsaKeyRestriction(final int wireValue) {
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
    public static GitLabSettingsUpdateEcdsaKeyRestriction fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
