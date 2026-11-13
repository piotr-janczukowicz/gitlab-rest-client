package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update default project creation. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/default_project_creation")
public enum GitLabSettingsUpdateDefaultProjectCreation {
    N_0(0),
    N_3(3),
    N_4(4),
    N_1(1),
    N_2(2);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateDefaultProjectCreation> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateDefaultProjectCreation.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateDefaultProjectCreation(final int wireValue) {
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
    public static GitLabSettingsUpdateDefaultProjectCreation fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
