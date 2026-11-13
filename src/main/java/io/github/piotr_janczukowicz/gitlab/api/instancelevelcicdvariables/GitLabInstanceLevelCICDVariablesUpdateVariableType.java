package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance level cicdvariables update variable type. */
@CatalogSchema("operations/putApiV4AdminCiVariablesKey/requestBody/properties/variable_type")
public enum GitLabInstanceLevelCICDVariablesUpdateVariableType {
    ENV_VAR("env_var"),
    FILE("file");

    private static final EnumUtils.WireIndex<GitLabInstanceLevelCICDVariablesUpdateVariableType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabInstanceLevelCICDVariablesUpdateVariableType.class,
                    GitLabInstanceLevelCICDVariablesUpdateVariableType::wireValue);

    private final String wireValue;

    GitLabInstanceLevelCICDVariablesUpdateVariableType(final String wireValue) {
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
    public static GitLabInstanceLevelCICDVariablesUpdateVariableType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
