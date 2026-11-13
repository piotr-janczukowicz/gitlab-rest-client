package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project pipelines create variable type. */
@CatalogSchema("operations/postApiV4ProjectsIdPipeline/requestBody/properties/variables/items/properties/variable_type")
public enum GitLabProjectPipelinesCreateVariableType {
    ENV_VAR("env_var"),
    FILE("file");

    private static final EnumUtils.WireIndex<GitLabProjectPipelinesCreateVariableType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectPipelinesCreateVariableType.class, GitLabProjectPipelinesCreateVariableType::wireValue);

    private final String wireValue;

    GitLabProjectPipelinesCreateVariableType(final String wireValue) {
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
    public static GitLabProjectPipelinesCreateVariableType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
