package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update rsa key restriction. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/rsa_key_restriction")
public enum GitLabSettingsUpdateRsaKeyRestriction {
    N_0(0),
    N_1024(1024),
    N_2048(2048),
    N_3072(3072),
    N_4096(4096),
    MINUS_ONE(-1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateRsaKeyRestriction> WIRE_INDEX =
            EnumUtils.index(GitLabSettingsUpdateRsaKeyRestriction.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateRsaKeyRestriction(final int wireValue) {
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
    public static GitLabSettingsUpdateRsaKeyRestriction fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
