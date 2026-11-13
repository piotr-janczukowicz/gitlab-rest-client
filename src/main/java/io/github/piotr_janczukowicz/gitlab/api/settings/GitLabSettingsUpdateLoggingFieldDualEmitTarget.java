package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update logging field dual emit target. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/logging_field_dual_emit_target")
public enum GitLabSettingsUpdateLoggingFieldDualEmitTarget {
    N_1(1);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateLoggingFieldDualEmitTarget> WIRE_INDEX =
            EnumUtils.index(
                    GitLabSettingsUpdateLoggingFieldDualEmitTarget.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateLoggingFieldDualEmitTarget(final int wireValue) {
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
    public static GitLabSettingsUpdateLoggingFieldDualEmitTarget fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
