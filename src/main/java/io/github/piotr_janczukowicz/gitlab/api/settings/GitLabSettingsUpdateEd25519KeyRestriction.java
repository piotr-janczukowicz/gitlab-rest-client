package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update ed25519 key restriction. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/ed25519_key_restriction")
public enum GitLabSettingsUpdateEd25519KeyRestriction {
    N_0(0),
    N_256(256),
    MINUS_ONE(-1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateEd25519KeyRestriction> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateEd25519KeyRestriction.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateEd25519KeyRestriction(final int wireValue) {
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
    public static GitLabSettingsUpdateEd25519KeyRestriction fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
