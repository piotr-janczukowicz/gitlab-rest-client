package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project project level variables create variable type. */
@CatalogSchema("operations/postApiV4ProjectsIdVariables/requestBody/properties/variable_type")
public enum GitLabProjectProjectLevelVariablesCreateVariableType {
    ENV_VAR("env_var"),
    FILE("file");

    private static final EnumUtils.WireIndex<GitLabProjectProjectLevelVariablesCreateVariableType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectLevelVariablesCreateVariableType.class,
                    GitLabProjectProjectLevelVariablesCreateVariableType::wireValue);

    private final String wireValue;

    GitLabProjectProjectLevelVariablesCreateVariableType(final String wireValue) {
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
    public static GitLabProjectProjectLevelVariablesCreateVariableType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
