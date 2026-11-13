package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab runner controllers create state. */
@CatalogSchema("operations/postApiV4RunnerControllers/requestBody/properties/state")
public enum GitLabRunnerControllersCreateState {
    DISABLED("disabled"),
    ENABLED("enabled"),
    DRY_RUN("dry_run");

    private static final EnumUtils.WireIndex<GitLabRunnerControllersCreateState> WIRE_INDEX =
            EnumUtils.index(GitLabRunnerControllersCreateState.class, GitLabRunnerControllersCreateState::wireValue);

    private final String wireValue;

    GitLabRunnerControllersCreateState(final String wireValue) {
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
    public static GitLabRunnerControllersCreateState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
