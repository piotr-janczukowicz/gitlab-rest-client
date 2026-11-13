package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab runner controllers update state. */
@CatalogSchema("operations/putApiV4RunnerControllersId/requestBody/properties/state")
public enum GitLabRunnerControllersUpdateState {
    DISABLED("disabled"),
    ENABLED("enabled"),
    DRY_RUN("dry_run");

    private static final EnumUtils.WireIndex<GitLabRunnerControllersUpdateState> WIRE_INDEX =
            EnumUtils.index(GitLabRunnerControllersUpdateState.class, GitLabRunnerControllersUpdateState::wireValue);

    private final String wireValue;

    GitLabRunnerControllersUpdateState(final String wireValue) {
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
    public static GitLabRunnerControllersUpdateState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
