package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update logging field schema version. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/logging_field_schema_version")
public enum GitLabSettingsUpdateLoggingFieldSchemaVersion {
    N_0(0),
    N_1(1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateLoggingFieldSchemaVersion> WIRE_INDEX =
            EnumUtils.index(
                    GitLabSettingsUpdateLoggingFieldSchemaVersion.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateLoggingFieldSchemaVersion(final int wireValue) {
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
    public static GitLabSettingsUpdateLoggingFieldSchemaVersion fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
